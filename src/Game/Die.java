package Game;

import java.util.Random;

public class Die {
    private Random random = new Random();
    private int faceValue, numberOfSides;
    /**
     * Constructor sets amount of sides of die
     * @param sides: int, defines number of sides
     */
    protected Die (int sides){
        numberOfSides = sides;
    }
    /**
     * Constructor sets number of sides to 6
     */
    protected Die() {
        numberOfSides = 6;
    }
    /**
     * Rolls die and returns integer
     */
    public void rollDie() {
        faceValue = random.nextInt(numberOfSides)+1;
    }
    /**
     * Sets specific value of eyes on die
     * @param value: int, sets new value of faceValue.
     */
    public void setFaceValue(int value) {
        faceValue = value;
    }
    /**
     *  Return face value of die
     */
    public int getFaceValue(){
        return faceValue;

    }

}
