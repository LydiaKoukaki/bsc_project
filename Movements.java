package finalproject;

import java.util.ArrayList;

/**
 * This method has been created in order to provide the agent with the
 * information of knowing where he is able to move.
 *
 * @author Lydia Koukaki
 */
public class Movements {

    /**
     * An ArrayList method of the agent’s neighbours called getNeighbors with
     * three parameters the int x, int y, and int arraySize.
     *
     * @param x the position of the agent on the x axis
     * @param y the position of the agent on the y axis
     * @param arraySize the size of the environment of the agents
     *
     * @return the list with the neighbor's of the agent
     */
    public ArrayList<String> getNeighbors(int x, int y, int arraySize) {

        //this ArrayList holds the neighbours in a String representation
        ArrayList<String> list = new ArrayList<String>();

        //the ArrayList checks whether the agent is located at the edges of the
        //grid. If it does not then the number of neighbours that surround it is
        //eight.
        if (x != 0 && x != arraySize - 1 && y != 0 && y != arraySize - 1) {
            list.add((x - 1) + "," + y);
            list.add((x - 1) + "," + (y - 1));
            list.add((x - 1) + "," + (y + 1));
            list.add((x + 1) + "," + y);
            list.add((x + 1) + "," + (y + 1));
            list.add((x + 1) + "," + (y - 1));
            list.add(x + "," + (y - 1));
            list.add(x + "," + (y + 1));
        //whether the agent is located on the (0, 0) of the axis 
        //in this case the agent has three possible neighbours.
        } else if (x == 0 && y == 0) {
            list.add(((x + 1) + "," + (y + 1)));
            list.add((x + 1) + "," + y);
            list.add(x + "," + (y + 1));
        //(last down grid on the right) also has three possible neighbours   
        } else if (x == arraySize - 1 && y == arraySize - 1) {
            list.add((x - 1) + "," + y);
            list.add(x + "," + (y - 1));
            list.add((x - 1) + "," + (y - 1));
        //(last up grid on the right) it also has three neighbours
        } else if (x == 0 && y == arraySize - 1) {
            list.add((x + 1) + "," + y);
            list.add(x + "," + (y - 1));
            list.add((x + 1) + "," + (y - 1));
        //(first down grid on the left) has three neighbours   
        } else if (x == arraySize - 1 && y == 0) {
            list.add((x - 1) + "," + y);
            list.add((x - 1) + "," + (y + 1));
            list.add(x + "," + (y + 1));
        //the agents who are located between those of the second and the forth 
        //if condition agents. Those agents have a maximum of five neighbours
        } else if (x == 0) {
            list.add(x + "," + (y - 1));
            list.add(x + "," + (y + 1));
            list.add((x + 1) + "," + y);
            list.add((x + 1) + "," + (y - 1));
            list.add((x + 1) + "," + (y + 1));
        //the agents who are located between those of the fifth and the third if
        //condition agents. Those agents have a maximum of five neighbours 
        } else if (x == arraySize - 1) {
            list.add(x + "," + (y - 1));
            list.add(x + "," + (y + 1));
            list.add((x - 1) + "," + y);
            list.add((x - 1) + "," + (y + 1));
            list.add((x - 1) + "," + (y - 1));
        //the agents who are located between those of the second and the fifth 
        //if condition agents. Those agents have a maximum of five neighbours
        } else if (y == 0) {
            list.add((x - 1) + "," + y);
            list.add((x + 1) + "," + y);
            list.add(x + "," + (y + 1));
            list.add((x - 1) + "," + (y + 1));
            list.add((x + 1) + "," + (y + 1));
        //the agents who are located between those of the forth and the third if
        //condition agents. Those agents have a maximum of five neighbours 
        } else {
            list.add(x + "," + (y - 1));
            list.add((x - 1) + "," + y);
            list.add((x + 1) + "," + y);
            list.add((x - 1) + "," + (y - 1));
            list.add((x + 1) + "," + (y - 1));
        }
        //return the ArrayList
        return list;
    }
}
