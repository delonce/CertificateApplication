package main.GUIPackage.ActionListeners;

import main.GUIPackage.Windows.AbstractGUIManager;
import main.GUIPackage.Windows.ConfirmWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeWindowListener implements ActionListener {
    private AbstractGUIManager newGUIWindow;

    public ChangeWindowListener(AbstractGUIManager newGUIWindow) {
        this.newGUIWindow = newGUIWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel panel = AbstractGUIManager.getPanel();
        int nums = panel.getComponentCount();

        for (int i = 0; i < nums; i++) {
            panel.remove(0);

            panel.revalidate();
            panel.repaint();
        }

        AbstractGUIManager.getCurrentWindow().setVisible(false);

        newGUIWindow.buildGUIApplication();
        newGUIWindow.setVisible(true);

        AbstractGUIManager.setCurrentWindow(newGUIWindow);
    }
}
