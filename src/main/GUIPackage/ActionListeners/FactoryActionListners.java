package main.GUIPackage.ActionListeners;

import main.GUIPackage.Windows.AbstractGUIManager;
import main.GUIPackage.Windows.StartedWindow;

public interface FactoryActionListners {
    static ChangeWindowListener createChangeWindowListener(AbstractGUIManager newManager) {
        return new ChangeWindowListener(newManager);
    };

    static ChangeWindowListener createBackToStartListener() {
        return new ChangeWindowListener(new StartedWindow());
    }

    static GetDataListener createDataReader() {
        return new GetDataListener();
    }

    static ChooseFileListener createFileChooser(String fileFormat) { return new ChooseFileListener(fileFormat); }

    static ConfirmListener createConfirmListener() {
        return new ConfirmListener();
    }
}
