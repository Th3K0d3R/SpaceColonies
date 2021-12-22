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
 * Test class to test Skillset methods
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/10/21
 *
 */
public class SkillsetTest extends TestCase {
    private Skillset skills;

    /**
     * instantiates the field variable
     */
    public void setUp() {
        skills = new Skillset(4, 5, 6);
    }


    /**
     * tests the getAgriculture() method
     */
    public void testGetAgriculture() {
        assertEquals(4, skills.getAgriculture());
    }


    /**
     * tests the getMedicine() method
     */
    public void testGetMedicine() {
        assertEquals(5, skills.getMedicine());
    }


    /**
     * tests the getTechnology() method
     */
    public void testGetTechnology() {
        assertEquals(6, skills.getTechnology());
    }


    /**
     * tests the isLessThanOrEqualTo() method
     */
    public void testIsLessThanOrEqualTo() {
        Skillset skills1 = new Skillset(4, 4, 4);
        Skillset skills2 = new Skillset(9, 9, 9);
        assertFalse(skills.isLessThanOrEqualTo(skills1));
        assertTrue(skills.isLessThanOrEqualTo(skills2));
    }


    /**
     * tests the toString() method
     */
    public void testToString() {
        assertEquals("A:4 M:5 T:6", skills.toString());
    }


    /**
     * tests the equals() method
     */
    public void testEquals() {
        assertTrue(skills.equals(skills));
        Skillset skills1 = null;
        assertFalse(skills.equals(skills1));
        Skillset skills2 = new Skillset(9, 9, 9);
        assertFalse(skills.equals(skills2));
        Skillset skills3 = new Skillset(4, 5, 6);
        assertTrue(skills.equals(skills3));
        assertFalse(skills.equals("wubbalubbadubdub"));
    }


    /**
     * tests CompareTo() method to see if exception is thrown
     */
    public void testCompareToException() {
        Exception exception = null;
        Skillset skills1 = null;
        try {
            skills.compareTo(skills1);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("compareTo() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

    }


    /**
     * tests the compareTo() method
     */
    public void testCompareTo() {
        Skillset skills1 = new Skillset(1, 1, 1);
        assertEquals(12, skills.compareTo(skills1));
    }

}
