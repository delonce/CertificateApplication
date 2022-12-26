package main.GUIPackage.ActionListeners;

import main.CertificateCenter.CertificateChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CertificateChecker certificateChecker = new CertificateChecker();

        if (certificateChecker.isFilesExist()) {
            try {
                String qrData = certificateChecker.getQrManager().ScanQrCode(certificateChecker.getPathToQr());
                String encodedData = qrData.split("___")[0];

                String decodedData = certificateChecker.getCryptoManager().DecodeByPublicKey(encodedData, certificateChecker.getPathToKey());
                String checkString = qrData.split("___")[1];

                byte[] check = checkString.getBytes();
                byte[] decoded = decodedData.getBytes();

                for (int i = 0; i < check.length; i++) {
                    if (check[i] != decoded[i]) {
                        throw new RuntimeException();
                    }
                }

                JOptionPane.showMessageDialog(null, "Сертификат верен!", "Успех", JOptionPane.PLAIN_MESSAGE);

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Сертификат недействителен!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Выберите оба файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
