/**
 * 
 */
package spacecolonies;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey 

/**
 * Test class for SpaceColonyDataException class
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/11/21
 *
 */
public class SpaceColonyDataExceptionTest extends TestCase {

    private SpaceColonyDataException exception;

    /**
     * instantiates the field variable
     */
    public void setUp() {
        exception = new SpaceColonyDataException(
            "The data being input is incorrect");
    }


    /**
     * test method for SpaceColonyException()
     */
    public void testSpaceColonyDataException() {
        assertEquals("The data being input is incorrect", exception
            .getMessage());
    }

}
