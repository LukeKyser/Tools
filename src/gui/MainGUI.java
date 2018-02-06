package gui;

import gui.forms.DroppablePicturePanelForm;

import javax.swing.*;

public class MainGUI {
    private static JFrame frame = new JFrame();

    /**
     * Main Method of Project
     *
     * @param args arguments passed into Main
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(MainGUI::createDroppablePictureGUI);
    }

    public static void createDroppablePictureGUI() {
        frame = new JFrame();
        DroppablePicturePanelForm dropForm = new DroppablePicturePanelForm(frame);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(dropForm.getRootPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void disposeFrame() {
        frame.dispose();
    }
}
