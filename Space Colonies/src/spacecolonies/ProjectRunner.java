/**
 * 
 */
package spacecolonies;

import java.io.FileNotFoundException;
import java.text.ParseException;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey 

/**
 * This is the main method of the ProjectRunner class used to build GUI and run
 * the Space Colonies
 * 
 * @author Fiifi Sackey
 *
 * @version 11/12/21
 */
public class ProjectRunner {

    /**
     * Takes in two files or uses the default files to run Space Colonies
     * 
     * @param args
     *            files to be ran
     * @throws ParseException
     *             thrown if there are not the correct amount of skill values
     * @throws FileNotFoundException
     *             thrown if there is no such file
     * @throws SpaceColonyDataException
     *             thrown if there are less than three planets
     * @throws NullPointerException
     *             thrown if there are null values
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException,
        NullPointerException {
        // throw new NullPointerException();

        if (args.length == 2) {
            ColonyReader reader = new ColonyReader(args[0], args[1]);
        }
        else {
            ColonyReader reader = new ColonyReader("input.txt", "planets.txt");
        }

    }

}
