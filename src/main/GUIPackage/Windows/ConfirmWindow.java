package main.GUIPackage.Windows;

import main.GUIPackage.ActionListeners.FactoryActionListners;

import javax.swing.*;
import java.awt.*;

public class ConfirmWindow extends AbstractGUIManager {
    private void initializeGUIComponents() {
        JButton buttonQr = new JButton("Загрузить QR-код");
        JButton buttonKey = new JButton("Загрузить публичный ключ");
        JButton buttonBack = new JButton("Назад");
        JButton buttonConfirm = new JButton("Проверить");

        JLabel mainLabel = new JLabel("Загрузите данные", SwingConstants.CENTER);

        buttonBack.addActionListener(FactoryActionListners.createBackToStartListener());
        buttonQr.addActionListener(FactoryActionListners.createFileChooser("png"));
        buttonKey.addActionListener(FactoryActionListners.createFileChooser("key"));
        buttonConfirm.addActionListener(FactoryActionListners.createConfirmListener());

        updateAllGUIComponents(mainLabel);
        updateAllGUIComponents(buttonQr);
        updateAllGUIComponents(buttonKey);
        updateAllGUIComponents(buttonBack);
        updateAllGUIComponents(buttonConfirm);
    }

    @Override
    public void buildGUIApplication() {
        this.setBounds(200, 200, 500, 600);

        getPanel().setBorder(BorderFactory.createEmptyBorder(40,30,40,30));
        getPanel().setLayout(new GridLayout(0,1, 10, 20));

        initializeGUIComponents();
        addComponentsIntoPanel();

        super.buildGUIApplication();
    }
}
