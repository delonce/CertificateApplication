package main.GUIPackage.Windows;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

abstract public class AbstractGUIManager extends JFrame {
    private static JPanel panel = new JPanel();

    private static AbstractGUIManager currentWindow;

    private ArrayList<Component> allGUIComponents = new ArrayList<>();

    private Container container = this.getContentPane();

    private void initializeGUIComponents() {}

    public void buildGUIApplication() {
        container.add(panel);
    };

    public AbstractGUIManager() {
        super("QrApplication");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponentsIntoPanel() {
        for (Component component : allGUIComponents) {
            panel.add(component);
        }
    }

    public Container getContainer() {
        return container;
    }

    public ArrayList<Component> getAllGUIComponents() {
        return allGUIComponents;
    }

    public static AbstractGUIManager getCurrentWindow() {
        return currentWindow;
    }

    public static void setCurrentWindow(AbstractGUIManager currentWindow) {
        AbstractGUIManager.currentWindow = currentWindow;
    }

    public void setAllGUIComponents(ArrayList<Component> allGUIComponents) {
        this.allGUIComponents = allGUIComponents;
    }

    public void updateAllGUIComponents(Component guiComponent) {
        this.allGUIComponents.add(guiComponent);
    }

    public static JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
