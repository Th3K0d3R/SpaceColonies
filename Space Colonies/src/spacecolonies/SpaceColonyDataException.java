/**
 * 
 */
package spacecolonies;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey (906291314)

/**
 * This class throws an exception if data is incorrect in the input files
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/11/21
 *
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {

    /**
     * Constructor for class
     * 
     * @param string
     *            message to be passed
     * 
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }

}
