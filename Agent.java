package finalproject;

/**
 * 
 * @author Lydia Koukaki
 */
public class Agent {

    private boolean happy = false;  //whether the agent is happy or not
    private String color;           //the color of the agent
    private String id;              //the id of the agent

    /**
     * Constructor requiring the color and the id of the agent
     *
     * @param color the color of the agent
     * @param id the id of the agent
     */
    public Agent(String color, String id) {
        this.color = color;
        this.id = id;
    }

    /**
     * @return whether the agent is happy or not
     */
    public boolean isHappy() {
        return happy;
    }

    /**
     * Sets the happiness of the agent
     *
     * @param happy the agent's happiness
     */
    public void setHappy(boolean happy) {
        this.happy = happy;
    }

    /**
     * Sets the color of the agent
     *
     * @param color the agent's color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the color of the agent
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the agent's id
     */
    public String getId() {
        return id;
    }
}
