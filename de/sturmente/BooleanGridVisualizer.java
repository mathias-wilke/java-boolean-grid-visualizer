package de.sturmente;
import javax.swing.*;
import java.awt.*;

/**
 * A class for visualizing two-dimensional boolean arrays.
 * It displays boolean arrays as a grid where true values are represented by white cells
 * and false values by black cells. The cell size can be adjusted.
 */
public class BooleanGridVisualizer extends JFrame {

    private static final long serialVersionUID = 1L;
    private BooleanGridPanel gridPanel;
    private int cellWidth; // Width of the cells
    private int cellHeight; // Height of the cells
    private boolean startUp = true;

    /**
     * Constructs a BooleanGridVisualizer with specified cell width and height.
     * 
     * @param cellWidth  The width of each cell in the grid.
     * @param cellHeight The height of each cell in the grid.
     */
    public BooleanGridVisualizer(int cellWidth, int cellHeight) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        gridPanel = new BooleanGridPanel();
        add(gridPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Boolean Grid Visualizer - https://github.com/mathias-wilke/java-boolean-grid-visualizer");
    }

    /**
     * Draws the provided two-dimensional boolean array on the grid.
     * True values are represented by white cells, and false values by black cells.
     * 
     * @param array The two-dimensional boolean array to be visualized.
     */
    public void drawBooleanArray(boolean[][] array) {
        if (array != null && array.length > 0 && array[0].length > 0) {
            gridPanel.setArray(array);
            adjustWindowSize(array.length, array[0].length);
        }
    }

    /**
     * Adjusts the window size based on the dimensions of the boolean array to be displayed.
     * 
     * @param rows The number of rows in the array.
     * @param cols The number of columns in the array.
     */
    private void adjustWindowSize(int rows, int cols) {
        int totalWidth = cols * cellWidth + 15;
        int totalHeight = rows * cellHeight + 38; // +38 for window frame
        setSize(new Dimension(totalWidth, totalHeight));
        revalidate();
        if(startUp) {
        	setLocationRelativeTo(null);
        	startUp = false;
        }
    }

    /**
     * Inner class responsible for rendering the boolean array as a grid.
     */
    private class BooleanGridPanel extends JPanel {

        private static final long serialVersionUID = 1L;
        private boolean[][] array;

        BooleanGridPanel() {
            setBackground(Color.BLACK);
        }

        /**
         * Sets the boolean array to be visualized and triggers a repaint.
         * 
         * @param array The two-dimensional boolean array to be set.
         */
        void setArray(boolean[][] array) {
            this.array = array;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (array != null) {
                drawBooleanArray(g);
            }
        }

        /**
         * Draws the boolean array as a grid on the panel.
         * 
         * @param g The Graphics object used for drawing.
         */
        private void drawBooleanArray(Graphics g) {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[row].length; col++) {
                    g.setColor(array[row][col] ? Color.WHITE : Color.BLACK);
                    g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }
}
