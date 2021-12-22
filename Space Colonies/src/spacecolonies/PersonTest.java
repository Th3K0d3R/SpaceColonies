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
 * test class for Person class methods
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/10/21
 *
 */
public class PersonTest extends TestCase {
    private Person person;
    private Person person1;

    /**
     * instantiates the field variables
     */
    public void setUp() {
        person = new Person(":)", 5, 6, 7, "Zarg");
        person1 = new Person(":(", 7, 6, 5, "Twilight");
    }


    /**
     * tests getName() method
     */
    public void testGetName() {
        assertEquals(":)", person.getName());
    }


    /**
     * tests the getSkills() method
     */
    public void testGetSkills() {
        Skillset skills = new Skillset(5, 6, 7);
        assertTrue(person.getSkills().equals(skills));
    }


    /**
     * tests the getPlanetPreference() method
     */
    public void testGetPlanetPreference() {
        assertEquals("Zarg", person.getPlanetPreference());
    }


    /**
     * tests the toString() method
     */
    public void testToString() {
        assertEquals(":) A:5 M:6 T:7 Wants: Zarg", person.toString());
        Person person2 = new Person(":(", 5, 6, 7, "");
        assertEquals("No-Planet :( A:5 M:6 T:7", person2.toString());
    }


    /**
     * tests the equals() method
     */
    public void testEquals() {
        assertTrue(person.equals(person));
        Person person2 = null;
        assertFalse(person.equals(person2));
        assertFalse(person.equals(person1));
        Person person3 = new Person(":)", 5, 6, 7, "Zarg");
        assertTrue(person.equals(person3));
        assertFalse(person.equals("butt"));

    }
}
