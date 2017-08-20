package finalproject;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * This class is responsible for the creation of the grid and the agents in the
 * Graphical User Interface.
 *
 * @author Lydia Koukaki
 */
public class PaintPane extends JPanel {

    private ArrayList<Shape> grid = new ArrayList<Shape>();
    private HashMap<Shape, Color> fill = new HashMap<Shape, Color>();
    private GUI gui;

    public PaintPane(final GUI gui) {
        this.gui = gui;
        this.init();
    }

    public void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                for (Shape shape : grid) {
                    if (shape.contains(e.getPoint())) {
                        if (fill.containsKey(shape)) {
                            fill.remove(shape);
                        } else {
                            fill.put(shape, gui.getColor1());
                        }
                    }
                }
                gui.setArray(getAgentsSelected());
                repaint();
            }
        });

        int colWidth = 180 / 6;
        int rowHeight = 180 / 6;

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
            }
        }
    }

    public void randomAction() {
        paintPane();
        repaint();

        int colWidth = 180 / 6;
        int rowHeight = 180 / 6;

        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
            }
        }
    }

    public void paintPane() {

        int row = 0;

        for (int i = 0; i < gui.getArray().length; i++) {
            for (int j = 0; j < gui.getArray().length; j++) {
                switch (gui.getArray()[i][j].getColor()) {
                    case "red": {
                        Color color1 = new Color(238, 44, 44);
                        fill.put(grid.get(j + row), color1);
                        break;
                    }
                    case "green": {
                        Color color1 = new Color(50, 205, 50);
                        fill.put(grid.get(j + row), color1);
                        break;
                    }
                    case "blue": {
                        Color color1 = new Color(59, 89, 182);
                        fill.put(grid.get(j + row), color1);
                        break;
                    }
                    default: {
                        Color color1 = new Color(255, 255, 255);
                        fill.put(grid.get(j + row), color1);
                        break;
                    }
                }
            }
            row = row + 20;

        }

    }

    public void clear() {
        grid.removeAll(grid);
        for (Shape key : fill.keySet()) {

            fill.remove(key);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Shape key : fill.keySet()) {
            g2d.setColor(fill.get(key));
            g2d.fill(key);
        }

        g2d.setColor(Color.BLACK);
        for (Shape cell : grid) {
            g2d.draw(cell);
        }
    }

    public Agent[][] getAgentsSelected() {
        Agent[][] agentArray = new Agent[20][20];
        int rowj = 0;
        int rowi = 0;
        Color redColor = new Color(238, 44, 44);
        Color greenColor = new Color(50, 205, 50);
        Color blueColor = new Color(59, 89, 182);

        for (Shape key : grid) {

            if (fill.get(key) == null) {
                agentArray[rowi][rowj] = new Agent("none", rowi + "," + rowj);
            } else if (fill.get(key).equals(redColor)) {
                agentArray[rowi][rowj] = new Agent("red", rowi + "," + rowj);
            } else if (fill.get(key).equals(greenColor)) {
                agentArray[rowi][rowj] = new Agent("green", rowi + "," + rowj);
            } else if (fill.get(key).equals(blueColor)) {
                agentArray[rowi][rowj] = new Agent("blue", rowi + "," + rowj);
            } else {
                agentArray[rowi][rowj] = new Agent("none", rowi + "," + rowj);
            }


            rowj++;
            if (rowj > 19) {
                rowj = 0;
                rowi++;
            }
        }

        return agentArray;
    }
}
