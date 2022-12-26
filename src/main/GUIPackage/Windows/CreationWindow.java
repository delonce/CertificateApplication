package main.GUIPackage.Windows;

import main.GUIPackage.ActionListeners.FactoryActionListners;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CreationWindow extends AbstractGUIManager {
    private static JTextField toField;
    private static JTextField fromField;
    private static JTextArea reasonField;
    private static JTextField orgField;

    private void initializeGUIComponents() {
        JLabel toLabel = new JLabel("Кому назначается сертификат (ФИО):");
        toField = new JTextField("", 8);

        JLabel fromLabel = new JLabel("От кого назначается (ФИО):");
        fromField = new JTextField("", 8);

        JLabel reasonLabel = new JLabel("За что назначется сертификат:");
        reasonField = new JTextArea(5, 20);

        JLabel orgLabel = new JLabel("Организация:");
        orgField = new JTextField("", 8);

        JButton backButton = new JButton("Назад");
        JButton confirmButton = new JButton("Создать");

        backButton.addActionListener(FactoryActionListners.createBackToStartListener());
        confirmButton.addActionListener(FactoryActionListners.createDataReader());

        reasonField.setLineWrap(true);
        reasonField.setWrapStyleWord(true);

        ArrayList<Component> components = new ArrayList<Component>(Arrays.asList(toLabel, toField,
                fromLabel, fromField,
                reasonLabel, reasonField,
                orgLabel, orgField,
                backButton, confirmButton));

        setAllGUIComponents(components);
    }

    public static JTextField getToField() {
        return toField;
    }

    public static JTextField getFromField() {
        return fromField;
    }

    public static JTextArea getReasonField() {
        return reasonField;
    }

    public static JTextField getOrgField() {
        return orgField;
    }

    @Override
    public void buildGUIApplication() {
        this.setBounds(200, 200, 800, 600);

        getPanel().setLayout(new GridLayout(0,2, 10, 20));

        initializeGUIComponents();
        addComponentsIntoPanel();

        super.buildGUIApplication();
    }
}
