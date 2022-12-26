package main.GUIPackage.Windows;

import main.GUIPackage.ActionListeners.FactoryActionListners;

import javax.swing.*;
import java.awt.*;

public class StartedWindow extends AbstractGUIManager {

    private void initializeGUIComponents() {
        AbstractGUIManager.setCurrentWindow(this);

        JButton buttonConfirm = new JButton("Проверить QR-код");
        JButton buttonCreate = new JButton("Создать сертификат");
        JLabel mainLabel = new JLabel("Выберите действие", SwingConstants.CENTER);

        buttonCreate.addActionListener(FactoryActionListners.createChangeWindowListener(new CreationWindow()));
        buttonConfirm.addActionListener(FactoryActionListners.createChangeWindowListener(new ConfirmWindow()));

        updateAllGUIComponents(mainLabel);
        updateAllGUIComponents(buttonCreate);
        updateAllGUIComponents(buttonConfirm);
    }

    @Override
    public void buildGUIApplication() {
        this.setBounds(200, 200, 400, 300);

        getPanel().setBorder(BorderFactory.createEmptyBorder(40,30,40,30));
        getPanel().setLayout(new GridLayout(0,1, 10, 20));

        initializeGUIComponents();
        addComponentsIntoPanel();

        super.buildGUIApplication();
    }
}
