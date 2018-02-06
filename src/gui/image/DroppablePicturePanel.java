package gui.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DroppablePicturePanel extends PicturePanel implements DropTargetListener {
    private final static String DROP_TEXT = "Drop Image Here";

    private boolean dragging = false;
    private BufferedImage image = null;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    // Offsets
    private int xOffset = 0;
    private int yOffset = 0;
    private int panelWidthOffset = 0;
    private int panelHeightOffset = 0;

    private Color bgColor = new Color(242, 242, 242, 255);
    private int panelWidth;
    private int panelHeight;

    public DroppablePicturePanel() {
        super();
        new DropTarget(this, this);
    }

    public void setImage(BufferedImage value) {
        image = value;
        repaint();
    }
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();

        System.out.println("this " + panelWidth + " " + panelHeight);

        g.clearRect(0, 0, panelWidth - 1, panelHeight - 1);

        if (image != null) {
            imageAdjust(image);

            // Draw image
            g.setColor(bgColor);
            g.fillRect(0, 0, panelWidth, panelHeight);
            g.drawImage(image, xOffset, yOffset, panelWidth - panelWidthOffset, panelHeight - panelHeightOffset, bgColor, null);

            // Reset Offsets
            panelWidthOffset = 0;
            panelHeightOffset = 0;
            xOffset = 0;
            yOffset = 0;
        } else {
            // Draw drop text
            int textWidth = g.getFontMetrics().stringWidth(DROP_TEXT);
            int textHeight = g.getFontMetrics().getHeight();
            g.setColor(Color.gray);
            g.drawString(DROP_TEXT, (panelWidth - textWidth) / 2, (panelHeight + textHeight / 2)/2);
        }

        // Highlight the panel to show the user is dragging over it.
        if (dragging) {
            g.setColor(new Color(190, 211, 231, 150));
            g.fillRect(0, 0, panelWidth, panelHeight);
        }

        // Draw frame around panel
        g.drawRect(0, 0, panelWidth - 1, panelHeight - 1);
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        // System.out.println("Drag Enter");
        dragging = true;
        repaint();
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        // System.out.println("Drag Over");
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        // System.out.println("Drop Action Changed");
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        // System.out.println("Drag Exit");
        dragging = false;
        repaint();
    }

    private void loadFile(File file) {
        try {
            BufferedImage tempImage = image;
            image = ImageIO.read(file);
            pcs.firePropertyChange("image", tempImage, ImageIO.read(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        dragging = false;
        Transferable tr = dtde.getTransferable();
        DataFlavor[] flavors = tr.getTransferDataFlavors();

        for (DataFlavor flavor : flavors) {
            if (flavor.isFlavorJavaFileListType()) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

                // And add the list of file names to our text area
                List list;
                try {
                    list = (List) tr.getTransferData(flavor);
                    if (list.size() > 0)
                        loadFile((File) list.get(0));
                } catch (UnsupportedFlavorException | IOException e) {
                    e.printStackTrace();
                }

                dtde.dropComplete(true);
                repaint();
                return;
            }
        }
        repaint();
    }

    void imageAdjust(BufferedImage image) {
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        double widthPercent = (double)panelWidth / imageWidth;
        double heightPercent = (double)panelHeight / imageHeight;
        double percentDifference;

        System.out.println("Image crop " + imageWidth + " " + imageHeight);
        System.out.println("Percent " + widthPercent + " " + heightPercent);
        System.out.println("Panel " + (double)panelWidth + " " + (double)panelHeight);
        if (widthPercent > heightPercent) {
            percentDifference = widthPercent - heightPercent;

            widthPercent -= percentDifference;

            int minusPixels = panelWidth - (int)(image.getWidth() * widthPercent);

            xOffset = minusPixels / 2;
            panelWidthOffset = minusPixels;
        }
        if (widthPercent < heightPercent) {
            percentDifference = heightPercent - widthPercent;

            heightPercent -= percentDifference;

            int minusPixels = panelHeight - (int)(image.getHeight() * heightPercent);

            yOffset = minusPixels / 2;
            panelHeightOffset = minusPixels;
        }
    }

    public void
    addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void
    removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public void setColor(Color color) {
        bgColor = color;
    }

    public void setDimensions(Dimension dimension) {
        panelWidth = (int) dimension.getWidth();
        panelHeight = (int) dimension.getHeight();
    }
}