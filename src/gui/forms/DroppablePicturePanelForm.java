package gui.forms;

import gui.image.DroppablePicturePanel;

import javax.swing.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static constants.ConstantsGUI.*;

public class DroppablePicturePanelForm {
    private JPanel rootPanel;
    private DroppablePicturePanel picturePanel;
    private JPanel imagePlaceholderPanel;
    private final JFrame frame;

    public DroppablePicturePanelForm(JFrame frame){
        this.frame = frame;
        rootPanel.setPreferredSize(SIZE_MEDIUM);
        frame.setTitle(DROPABLE_PICTURE_PANEL_TITLE);
        picturePanel.setColor(frame.getBackground());
        picturePanel.setDimensions(imagePlaceholderPanel.getSize());

        PropertyChangeListener addImage = e -> {
            System.out.println("Image added");
        };
        picturePanel.addPropertyChangeListener(addImage);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
