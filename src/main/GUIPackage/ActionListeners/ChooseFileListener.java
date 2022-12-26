package main.GUIPackage.ActionListeners;

import main.CertificateCenter.CertificateChecker;
import main.GUIPackage.Windows.AbstractGUIManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ChooseFileListener implements ActionListener {
    private String reqFormat;

    public ChooseFileListener(String reqFormat) {
        this.reqFormat = reqFormat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileFilter(getFileFilter());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.showOpenDialog(AbstractGUIManager.getPanel());

        try {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().endsWith(reqFormat)) {
                JOptionPane.showMessageDialog(null, "Формат файла не поддерживается", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                if (reqFormat == "png") {
                    CertificateChecker.setPathToQr(file.getAbsolutePath());
                } else if (reqFormat == "key"){
                    CertificateChecker.setPathToKey(file.getAbsolutePath());
                }
            }
        } catch (NullPointerException exception) {
            return;
        }
    }

    private javax.swing.filechooser.FileFilter getFileFilter() {
        return new javax.swing.filechooser.FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.getName().endsWith(reqFormat)) {
                    return true;
                } else if (f.isDirectory()) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return ".png";
            }
        };
    }
}
