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
// -- Your Fiifi Sackey (906291314)

/**
 * Test class for Planet class methods
 * 
 * @author Fiifi Sackey
 *
 * @version 11/11/21
 */
public class PlanetTest extends TestCase {
    private Planet planet;
    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;

    /**
     * instantiates our field variables
     */
    public void setUp() {
        planet = new Planet("Shroom", 1, 2, 3, 10);
        person = new Person("bill", 5, 6, 7, "Zarg");
        person1 = new Person("jill", 7, 6, 5, "Twilight");
        person2 = new Person("grill", 6, 5, 7, "Diamond");
        person3 = new Person("gazorpazorp", 1, 1, 1, "Gazorpazorp World");
    }


    /**
     * tests the setName() method
     */
    public void testSetName() {
        assertEquals("Shroom", planet.getName());
        planet.setName("Mushroom");
        assertEquals("Mushroom", planet.getName());
    }


    /**
     * tests the getName() method
     */
    public void testGetName() {
        assertEquals("Shroom", planet.getName());
    }


    /**
     * 
     */
    public void testGetSkills() {
        Skillset skillz = new Skillset(1, 2, 3);
        assertEquals(0, skillz.compareTo(planet.getSkills()));
    }


    /**
     * tests getPopulation() method
     */
    public void testGetPopulation() {
        planet.addPerson(person);
        planet.addPerson(person1);
        planet.addPerson(person2);
        Person[] population = planet.getPopulation();
        assertEquals(person, population[0]);
        assertEquals(person1, population[1]);
        assertEquals(person2, population[2]);
    }


    /**
     * tests the getPopulationSize() method
     */
    public void testGetPopulationSize() {
        assertEquals(0, planet.getPopulationSize());
        planet.addPerson(person);
        planet.addPerson(person1);
        planet.addPerson(person2);
        assertEquals(3, planet.getPopulationSize());
    }


    /**
     * tests getCapacity() method
     */
    public void testGetCapacity() {
        assertEquals(10, planet.getCapacity());
    }


    /**
     * tests getAvailability() method
     */
    public void testGetAvailability() {
        assertEquals(10, planet.getAvailability());
        planet.addPerson(person);
        planet.addPerson(person1);
        planet.addPerson(person2);
        assertEquals(7, planet.getAvailability());
    }


    /**
     * tests the isFull() method
     */
    public void testIsFull() {
        assertFalse(planet.isFull());
        for (int i = 0; i <= planet.getCapacity(); i++) {
            planet.addPerson(person);
        }
        assertTrue(planet.isFull());
    }


    /**
     * tests the addPerson() method
     */
    public void testAddPerson() {
        assertTrue(planet.addPerson(person));
        assertFalse(planet.addPerson(person3));
    }


    /**
     * tests the isQualified() method
     */
    public void testIsQualified() {
        assertTrue(planet.isQualified(person));
        assertFalse(planet.isQualified(person3));
    }


    /**
     * tests the toString() method
     */
    public void testToString() {
        assertEquals(
            "Shroom, population 0 (cap: 10), Requires: A >= 1, M >= 2, T >= 3",
            planet.toString());
    }


    /**
     * tests the compareTo() method
     */
    public void testCompareTo() {
        Planet planet2 = new Planet("Snake", 1, 2, 3, 5);
        assertEquals(5, planet.compareTo(planet2)); // compares capacities
        Planet planet3 = new Planet("Spider", 3, 2, 3, 10);
        planet.addPerson(person);
        planet.addPerson(person1);
        planet.addPerson(person2);
        assertEquals(-3, planet.compareTo(planet3)); // compares availabilities
        Planet planet4 = new Planet("Fruit", 1, 1, 1, 10);
        planet4.addPerson(person);
        planet4.addPerson(person1);
        planet4.addPerson(person2);
        assertEquals(3, planet.compareTo(planet4)); // compares skills
        Planet planet5 = new Planet("Vegetable", 1, 2, 3, 10);
        planet5.addPerson(person);
        planet5.addPerson(person1);
        planet5.addPerson(person2);
        assertEquals(-3, planet.compareTo(planet5)); // compares names
        Planet planet6 = new Planet("New Animal Kingdom", 1, 2, 3, 10);
        planet6.addPerson(person);
        planet6.addPerson(person1);
        planet6.addPerson(person2);
        planet6.setName(planet.getName());
        assertEquals(0, planet.compareTo(planet6)); // compareTo() will return
                                                    // zero because they have
                                                    // exactly the same values
    }


    /**
     * tests the equals() method
     */
    public void testEquals() {
        assertTrue(planet.equals(planet));
        assertFalse(planet.equals(null));
        Planet planet2 = new Planet("Snake", 1, 2, 3, 5);
        assertFalse(planet.equals(planet2));
        Planet planet3 = new Planet("Shroom", 1, 2, 3, 10);
        assertTrue(planet.equals(planet3));
        planet.addPerson(person);
        planet3.addPerson(person);
        assertTrue(planet.equals(planet3));
        assertFalse(planet.equals("woah"));
    }
}
