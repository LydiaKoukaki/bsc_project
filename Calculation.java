package finalproject;

import java.util.*;

/**
 * Class Calculation has been created in order to provide the rules by which the 
 * agent will move to the grid according to their neighbors.
 * 
 * @author Lydia Koukaki
 */
public class Calculation {

    //inform the user whether or not he chose the three colour agents option
    private boolean threeColorAgents = false;
    //the length of the array in the x axis
    private int xlength = 20;
    //the length of the array in the y axis
    private int ylength = 20;
    //the array of the agents and takes inside the brackets the xlength and the 
    //ylength fields
    private Agent[][] array = new Agent[xlength][ylength];
    //a Random object
    private Random r = new Random();
    //a Movements object
    private Movements m = new Movements();

    public Calculation() {
        setArrayRandom();
    }

    /**
     * Sets whether the agents are three colored or not
     *
     * @param threeColorAgents the agent's number of colors
     */
    public void setThreeColorAgents(boolean threeColorAgents) {
        this.threeColorAgents = threeColorAgents;
    }

    /**
     * Defines the happiness of all the agents 
     * It has a double for loop for the agents array and if the agent is 
     * coloured it calls the rules method and it defines in each agent if it is 
     * happy or not.
     */
    public void defineHappiness() {
        for (int i = 0; i < xlength; i++) {
            for (int j = 0; j < ylength; j++) {
                if (array[i][j].getColor().equals("none") == false) {
                    rules(i, j);
                }
            }
        }
    }

    /**
     * This method determines the rules that will be used to help the agent
     * decide where to move according to its neighbor color.
     *
     * @param x the x axis of the agent
     * @param y the y axis of the agent
     */
    private void rules(int x, int y) {
        int count = 0;

        if (array[x][y].getColor().equals("none") == false) {

            for (String str : m.getNeighbors(x, y, xlength)) {

                String neiborAndress[] = str.split(",");
                int xx = Integer.parseInt(neiborAndress[0]);
                int yy = Integer.parseInt(neiborAndress[1]);

                if (array[x][y].getColor().equals(array[xx][yy].getColor())
                        == true && array[xx][yy].getColor().equals("none") == false) {
                    count++;
                }
            }

            switch (this.numberOfNeighbors(x, y)) {
                case 1:
                    if (count > 0) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);

                    }
                    break;
                case 2:
                    if (count > 0) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);

                    }
                    break;
                case 3:
                    if (count > 1) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);

                    }
                    break;
                case 4:
                    if (count > 1) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);

                    }
                    break;
                case 5:
                    if (count > 1) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);

                    }
                    break;
                case 6:
                    if (count > 2) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);

                    }
                    break;
                case 7:
                    if (count > 2) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);
                    }
                    break;
                case 8:
                    if (count > 3) {
                        array[x][y].setHappy(true);
                    } else {
                        array[x][y].setHappy(false);

                    }
                    break;
                case 0:
                    array[x][y].setHappy(false);
                    break;
            }

        }
    }

    /**
     * This method returns the number of neighbours that an agent has while it
     * is in the x and y axis point. This method takes from the accessor of the 
     * class Movements all the neighbours of the agent and if the neighbour has
     * the same colour with the agent the variable count takes +1
     * 
     * @param x the x axis of the agent
     * @param y the y axis of the agent
     * @return the number of neighbors an agent has at the x and y axis
     */
    public int numberOfNeighbors(int x, int y) {
        int count = 0;

        for (String str : m.getNeighbors(x, y, xlength)) {

            String neighborAddress[] = str.split(",");
            int xx = Integer.parseInt(neighborAddress[0]);
            int yy = Integer.parseInt(neighborAddress[1]);

            if (array[xx][yy].getColor().equals("none") == false) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the array with the agents
     */
    public Agent[][] getArray() {
        return array;
    }

    /**
     * Sets the array with the agents
     *
     * @param array the agents array
     */
    public void setArray(Agent[][] array) {
        this.array = array;
    }

    /**
     * @return the percentage of the happy agents
     */
    public float percentageOfHappyAgents() {
        float quantity = 0;
        float happy = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if (array[i][j].getColor().equals("none") == false) {
                    quantity++;
                    if (array[i][j].isHappy()) {
                        happy++;
                    }
                }
            }
        }

        return (happy * 100) / quantity;
    }

    /**
     * In this method the agent will try to change place with an unhappy agent.
     * If there is no unhappy agent then there is a chance 20% to change place
     * with someone happy.
     *
     * @param x the x axis of the agent
     * @param y the y axis of the agent
     */
    private void moveAgent(int x, int y) {

        //change places with other unhappy agents 
        if (array[x][y].isHappy() == false) {

            if (this.getUnhappyNeighbors(x, y).size() > 0) {
                changeWithUnhappy(x, y);

            } else if (this.getEmptyNeighbor(x, y).size() > 1) {
                int ran = r.nextInt(5);

                switch (ran) {
                    case 0:
                        changeWithEmpty(x, y);
                        break;
                    case 1:
                        changeWithHappy(x, y);
                        break;
                    case 2:
                        changeWithEmpty(x, y);
                        break;
                    case 3:
                        changeWithEmpty(x, y);
                        break;
                    case 4:
                        changeWithEmpty(x, y);
                        break;
                }

            } else {
                changeWithHappy(x, y);

            }
        }

    }

    /**
     * In this method the agent moves to an empty location that is not occupied
     * by another agent
     *
     * @param x the x axis of the agent
     * @param y the y axis of the agent
     */
    private void changeWithEmpty(int x, int y) {
        int moveWith = r.nextInt(this.getEmptyNeighbor(x, y).size());
        String xAndY[] = this.getEmptyNeighbor(x, y).get(moveWith).split(",");

        int changeAgentX = Integer.parseInt(xAndY[0]);
        int changeAgentY = Integer.parseInt(xAndY[1]);

        Agent tempAgent = array[changeAgentX][changeAgentY];
        array[changeAgentX][changeAgentY] = array[x][y];
        array[x][y] = tempAgent;
    }

    /**
     * In this method the agent changes position with an unhappy agent
     *
     * @param x the x axis of the agent
     * @param y the y axis of the agent
     */
    private void changeWithUnhappy(int x, int y) {
        int moveWith = r.nextInt(this.getUnhappyNeighbors(x, y).size());
        String xAndY[] = this.getUnhappyNeighbors(x, y).get(moveWith).split(",");

        int changeAgentX = Integer.parseInt(xAndY[0]);
        int changeAgentY = Integer.parseInt(xAndY[1]);

        Agent tempAgent = array[changeAgentX][changeAgentY];
        array[changeAgentX][changeAgentY] = array[x][y];
        array[x][y] = tempAgent;
    }

    /**
     * In this method the agent changes position with a happy agent
     *
     * @param x the x axis of the agent
     * @param y the y axis of the agent
     */
    private void changeWithHappy(int x, int y) {
        int moveWith = r.nextInt(this.m.getNeighbors(x, y, xlength).size());
        String xAndY[] = this.m.getNeighbors(x, y, xlength).get(moveWith).split(",");

        int changeAgentX = Integer.parseInt(xAndY[0]);
        int changeAgentY = Integer.parseInt(xAndY[1]);

        Agent tempAgent = array[changeAgentX][changeAgentY];
        array[changeAgentX][changeAgentY] = array[x][y];
        array[x][y] = tempAgent;
    }

    /**
     * This method moves all agents
     */
    public void moveAllAgents() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                moveAgent(i, j);
            }
        }
    }

    /**
     * 
     * @param x the x axis point
     * @param y the y axis point
     * @return an ArrayList with all the unhappy agents of an agent 
     */
    public ArrayList<String> getUnhappyNeighbors(int x, int y) {
        ArrayList<String> unhappyList = new ArrayList<String>();

        for (String str : m.getNeighbors(x, y, xlength)) {
            String neiborAndress[] = str.split(",");
            int xx = Integer.parseInt(neiborAndress[0]);
            int yy = Integer.parseInt(neiborAndress[1]);

            if (array[xx][yy].isHappy() == false && array[xx][yy].getColor().equals("none") == false) {
                unhappyList.add(str);
            }
        }
        return unhappyList;
    }

    /**
     * 
     * @param x the x axis point
     * @param y the y axis point
     * @return an ArrayList with the available empty locations near the agent
     */
    public ArrayList<String> getEmptyNeighbor(int x, int y) {
        ArrayList<String> emptyList = new ArrayList<String>();

        for (String str : m.getNeighbors(x, y, xlength)) {
            String neiborAndress[] = str.split(",");
            int xx = Integer.parseInt(neiborAndress[0]);
            int yy = Integer.parseInt(neiborAndress[1]);

            if (array[xx][yy].getColor().equals("none") == true) {
                emptyList.add(str);
            }
        }

        return emptyList;

    }

    /**
     * This method fills the agent's array with agents. If the variable 
     * threeColorAgents is true it fills the array with three colors
     * else with two colors.
     */
    public void setArrayRandom() {

        if (threeColorAgents == true) {
            //set up all agents by green, blue, red or none color
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    int x = r.nextInt(4);
                    if (x == 0) {
                        array[i][j] = new Agent("green", i + "," + j);
                    } else if (x == 1) {
                        array[i][j] = new Agent("blue", i + "," + j);
                    } else if (x == 2) {
                        array[i][j] = new Agent("red", i + "," + j);
                    } else if (x == 3) {
                        array[i][j] = new Agent("none", i + "," + j);
                    }
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    int x = r.nextInt(3);
                    if (x == 0) {
                        array[i][j] = new Agent("green", i + "," + j);
                    } else if (x == 1) {
                        array[i][j] = new Agent("blue", i + "," + j);
                    } else if (x == 2) {
                        array[i][j] = new Agent("none", i + "," + j);
                    }
                }
            }
        }

    }
}
