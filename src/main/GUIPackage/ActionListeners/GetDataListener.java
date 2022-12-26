package main.GUIPackage.ActionListeners;

import main.CertificateCenter.CertificateCreator;
import main.GUIPackage.Windows.CreationWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GetDataListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] creationFields = {
                CreationWindow.getFromField().getText(),
                CreationWindow.getToField().getText(),
                CreationWindow.getReasonField().getText(),
                CreationWindow.getOrgField().getText()
        };

        if (checkIsEmpty(creationFields) == true) {
            JOptionPane.showMessageDialog(null, "Заполните все поля!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            CertificateCreator manager = new CertificateCreator();
            manager.fillNewCertificate(creationFields[0], creationFields[1], creationFields[2], creationFields[3]);
            manager.encryptCertificate();
        }
    }

    private boolean checkIsEmpty(String[] fields) {
        for (String field : fields) {
            if (field.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
