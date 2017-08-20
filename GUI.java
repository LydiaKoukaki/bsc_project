package finalproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Lydia Koukaki
 */
public class GUI extends JFrame {

    //an object taken from the Java.awt.Color
    private Color color1 = new Color(255, 255, 255);
    //the array of the agents
    private Agent[][] array;
    //an object taken from the PaintPane class
    private final PaintPane pp;
    //an object taken from the Calculation class
    private Calculation c = new Calculation();
    //an integer and its default value is ninety
    private int percentageOfHappiness = 90;
    //JLabels
    private JLabel chooseColor = new JLabel("Choose color: ");
    private JLabel happyAgents = new JLabel("0");
    //JTextField
    private JTextField chprOfHa = new JTextField(percentageOfHappiness + "");
    //JChackBox
    private JCheckBox check = new JCheckBox("Three colors");
    //JButtons
    private JButton controlPanelBT = new JButton("OK");
    private JButton redButton = new JButton("Red");
    private JButton blueButton = new JButton("Blue");
    private JButton greenButton = new JButton("Green");
    private JButton randomButton = new JButton("Random");
    private JButton startButton = new JButton("Start");
    private JButton clearButton = new JButton("Clear");

    public GUI() {
        super("Schelling's Model of Segregation");
        array = c.getArray();
        pp = new PaintPane(this);
        this.addComponentsToFrame();
    }

    /**
     * Sets the color in RGB format
     *
     * @param r the red color
     * @param g the green color
     * @param b the blue color
     */
    public void setColor(int r, int g, int b) {
        color1 = new Color(r, g, b);
    }

    /**
     * @return the color
     */
    public Color getColor1() {
        return color1;
    }

    /**
     * @return the array
     */
    public Agent[][] getArray() {
        return array;
    }

    /**
     * @return the paint panel
     */
    public PaintPane getPp() {
        return pp;
    }

    /**
     * @return the calculation
     */
    public Calculation getCalculation() {
        return c;
    }

    /**
     * Sets the GUI components into frame
     */
    public void addComponentsToFrame() {

        //Creates a new menu bar. 
        JMenuBar menuBar = new JMenuBar();
        //Appends the fileMenu menu to the end of the menu bar.
        JMenu fileMenu = new JMenu("File");
        //Appends the helpMenu menu to the end of the menu bar.
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);//Adds the fileMenu menu to the menu bar.
        menuBar.add(helpMenu);//Adds the helpMenu menu to the menu bar.

        //Creates the helpItem menu item
        JMenuItem helpItem = new JMenuItem("Information");
        //Creates the newFile menu item
        JMenuItem newFile = new JMenuItem("New");
        //Creates the exitFile menu item
        JMenuItem exitFile = new JMenuItem("Exit");

        //Adds the helpItem menu item to the helpMenu menu.
        helpMenu.add(helpItem);
        //Adds the newFile menu item to the fileMenu menu.
        fileMenu.add(newFile);
        //Adds the exitFile menu item to the fileMenu menu.
        fileMenu.add(exitFile);

        this.setJMenuBar(menuBar);
        this.setSize(1100, 700); //Sets frame's size to 1100,700.
        //Exits the program when the user closes the frame. 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(pp);//Adds the paint panel to frame.
        //Adds the chooseColor c object to the EAST.
        this.add(chooseColorr(), BorderLayout.EAST);
        this.setLocationRelativeTo(null); //Centers the frame to screen.
        this.setVisible(true); //Makes the frame appear to screen.

        //ActionListener for the helpItem menu.
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String menuText = ((JMenuItem) e.getSource()).getText();
                //Informs the user with a message.
                int messageType = JOptionPane.INFORMATION_MESSAGE;
                JOptionPane.showMessageDialog(null, " Please, choose the colors"
                        + " of the agent of your choice, \n place them on grid "
                        + "and press start. \n Or you can set up the agents and"
                        + " choose the random option!");
            }
        });
        //ActionListener for exiting the application via the File menu.
        exitFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        newFile.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        array[i][j].setColor("none");
                    }
                }
                c.setArray(array);
                pp.paintPane();
                pp.repaint();
            }
          });
    }

    public JPanel chooseColorr() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.add(chooseColor);
        northPanel.add(redButton);
        northPanel.add(blueButton);
        northPanel.add(greenButton);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        southPanel.add(randomButton);
        southPanel.add(startButton);
        southPanel.add(clearButton);
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(southPanel, BorderLayout.SOUTH);

        blueButton.setBackground(new Color(59, 89, 182));
        blueButton.setForeground(Color.WHITE);
        blueButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        blueButton.setFocusPainted(false);

        greenButton.setBackground(new Color(50, 205, 50));
        greenButton.setForeground(Color.WHITE);
        greenButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        greenButton.setFocusPainted(false);

        redButton.setBackground(new Color(238, 44, 44));
        redButton.setForeground(Color.WHITE);
        redButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        redButton.setFocusPainted(false);

        randomButton.setBackground(new Color(238, 44, 44));
        randomButton.setForeground(Color.WHITE);
        randomButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        randomButton.setFocusPainted(false);

        startButton.setBackground(new Color(255, 165, 0));
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        startButton.setFocusPainted(false);

        clearButton.setBackground(new Color(238, 64, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        clearButton.setFocusPainted(false);

        controlPanelBT.setBackground(new Color(238, 64, 0));
        controlPanelBT.setForeground(Color.WHITE);
        controlPanelBT.setFont(new Font("Tahoma", Font.BOLD, 14));
        controlPanelBT.setFocusPainted(false);

        chooseColor.setForeground(Color.BLACK);
        chooseColor.setFont(new Font("Tahoma", Font.BOLD, 14));

        check.setForeground(Color.BLACK);
        check.setFont(new Font("Tahoma", Font.BOLD, 14));

        JPanel controlPanel = new JPanel();

        JLabel labelP = new JLabel("Percentage of happiness:");
        labelP.setForeground(Color.BLACK);
        labelP.setFont(new Font("Tahoma", Font.BOLD, 14));

        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(happyAgents);
        controlPanel.add(labelP);
        controlPanel.add(chprOfHa);
        chprOfHa.setPreferredSize(new Dimension(40, 20));
        controlPanel.add(check);

        controlPanel.add(controlPanelBT);
        panel.add(controlPanel, BorderLayout.CENTER);

        this.actionss();

        return panel;
    }

    /**
     * This method sets all the buttons
     */
    public void actionss() {
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeToRed();
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeToBlue();
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeToGreen();
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCalculation().setArrayRandom();
                getCalculation().defineHappiness();
                getPp().randomAction();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                while (c.percentageOfHappyAgents() < percentageOfHappiness) {
                    c.moveAllAgents();
                    c.defineHappiness();

                    pp.paintPane();
                    pp.repaint();
                    happyAgents.setText(c.percentageOfHappyAgents() + "%");
                    System.out.println(c.percentageOfHappyAgents());

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {   
                    }
                }

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        array[i][j].setColor("none");
                    }
                }
                pp.clear();
                c.setArray(array);
                pp.paintPane();
                pp.repaint();
            }
        });


        controlPanelBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (check.isSelected()) {
                    c.setThreeColorAgents(true);
                } else {
                    c.setThreeColorAgents(false);

                }

                percentageOfHappiness = Integer.parseInt(chprOfHa.getText());

            }
        });
    }

    /**
     * Sets the array
     * @param a the array
     */
    public void setArray(Agent[][] a) {
        c.setArray(a);
        array = c.getArray();
    }

    private void changeToRed() {
        this.setColor(238, 44, 44);
    }

    private void changeToGreen() {
        this.setColor(50, 205, 50);
    }

    private void changeToBlue() {
        this.setColor(59, 89, 182);
    }
}
