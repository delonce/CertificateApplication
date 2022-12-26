package main;

import java.io.*;
import java.security.*;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.google.zxing.NotFoundException;
import main.GUIPackage.Windows.AbstractGUIManager;
import main.GUIPackage.Windows.StartedWindow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException, NotFoundException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        AbstractGUIManager guiManager = new StartedWindow();
        guiManager.buildGUIApplication();
        guiManager.setVisible(true);
    }
}

class StartedGUIPage extends JFrame {
    private JButton buttonConfirm = new JButton("Проверить QR-код");
    private JButton buttonCreate = new JButton("Создать сертификат");
    private JLabel mainLabel = new JLabel("Выберите действие", SwingConstants.CENTER);
    private Container container;
    private JPanel panel = new JPanel();

    public StartedGUIPage() {
        super("QRApplication");
    }

    public void buildStartedWindow() {
        this.setBounds(200, 200, 400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBorder(BorderFactory.createEmptyBorder(40,30,40,30));
        panel.setLayout(new GridLayout(0,1, 10, 20));

        buttonCreate.addActionListener(new CreateButtonListener());

        panel.add(mainLabel);
        panel.add(buttonConfirm);
        panel.add(buttonCreate);

        container = this.getContentPane();
        container.add(panel);
    }

    private void buildCreationPanel() {
        JLabel toLabel = new JLabel("Кому назначается сертификат (ФИО):");
        JLabel fromLabel = new JLabel("От кого назначается (ФИО):");
        JLabel reasonLabel = new JLabel("За что назначется сертификат:");
        JLabel orgLabel = new JLabel("Организация:");

        JTextField toField = new JTextField("", 8);
        JTextField fromField = new JTextField("", 8);
        JTextArea reasonField = new JTextArea(5, 20);

        reasonField.setLineWrap(true);

        JTextField orgField = new JTextField("", 8);

        JButton backButton = new JButton("Назад");
        JButton confirmButton = new JButton("Создать");

        this.setBounds(200, 200, 800, 600);
        panel.setLayout(new GridLayout(0,2, 10, 20));

        panel.add(toLabel);
        panel.add(toField);
        panel.add(fromLabel);
        panel.add(fromField);
        panel.add(reasonLabel);
        panel.add(reasonField);
        panel.add(orgLabel);
        panel.add(orgField);
        panel.add(backButton);
        panel.add(confirmButton);
    }

    class CreateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.remove(buttonConfirm);
            revalidate();
            panel.remove(buttonCreate);
            revalidate();
            panel.remove(mainLabel);
            revalidate();

            buildCreationPanel();
            revalidate();
        }
    }
}
