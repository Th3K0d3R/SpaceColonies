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
 * Test class for testing the methods of ColonyCalculator class
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/11/21
 *
 */
public class ColonyCalculatorTest extends TestCase {
    private ColonyCalculator calculator;
    private ArrayQueue<Person> applicants;
    private Planet[] planets;

    /**
     * instantiates the field variables
     */
    public void setUp() {
        applicants = new ArrayQueue<Person>();
        planets = new Planet[3];
        planets[0] = new Planet("Planet1", 5, 2, 2, 10);
        planets[1] = new Planet("Planet2", 2, 5, 2, 4);
        planets[2] = new Planet("Planet3", 2, 2, 5, 8);
        applicants.enqueue(new Person("Bob", 5, 3, 1, "Planet1"));
        applicants.enqueue(new Person("jim", 5, 3, 2, "Planet2"));
        applicants.enqueue(new Person("nill", 5, 3, 5, "Planet3"));
        applicants.enqueue(new Person("till", 5, 3, 5, "Planet1"));
        applicants.enqueue(new Person("zill", 5, 3, 5, "nowhere"));
        calculator = new ColonyCalculator(applicants, planets);
    }

    /**
     * tests whether when a ColonyCalculator() object is created that is throws
     * exception when it should
     */
    
      public void colonyCalculatorException() {
      Exception exception = null;
      try {
      ColonyCalculator calculator1 = new ColonyCalculator(applicants, planets);
      }
      catch (Exception e) {
      exception = e;
      }
      assertTrue(exception instanceof IllegalArgumentException);
      }
     


    /**
     * tests the getQueue() method
     */
    public void testGetQueue() {
        ArrayQueue<Person> queue = new ArrayQueue<Person>();
        queue.enqueue(new Person("Bob", 5, 3, 1, "Planet1"));
        queue.enqueue(new Person("jim", 5, 3, 2, "Planet2"));
        queue.enqueue(new Person("nill", 5, 3, 5, "Planet3"));
        queue.enqueue(new Person("till", 5, 3, 5, "Planet1"));
        assertFalse(queue.equals(calculator.getQueue()));
        queue.enqueue(new Person("zill", 5, 3, 5, "nowhere"));
        assertTrue(queue.equals(calculator.getQueue()));
    }


    /**
     * tests the getPlanets() method
     */
    public void testGetPlanets() {
        Planet[] otherPlanets = new Planet[3];
        planets[0] = new Planet("Planet1", 5, 2, 2, 10);
        planets[1] = new Planet("Planet2", 2, 5, 2, 4);
        assertFalse(otherPlanets.equals(planets));
        planets[2] = new Planet("Planet3", 2, 2, 5, 8);
        // assertTrue(otherPlanets.equals(planets));
    }


    /**
     * tests the getPlanetForPerson() method
     */
    public void testGetPlanetForPerson() {
        assertEquals(null, calculator.getPlanetForPerson(null));
        applicants.enqueue(new Person("mill", 1, 3, 5, "nowhere"));
        Object[] applicantArr = applicants.toArray();
        assertEquals(planets[0], calculator.getPlanetForPerson(
            (Person)applicantArr[3]));
        calculator.reject();
        calculator.reject();
        assertTrue(calculator.accept());
        assertEquals(planets[0], calculator.getPlanetForPerson(
            (Person)applicantArr[4]));
        assertEquals(null, calculator.getPlanetForPerson(
            (Person)applicantArr[5]));
    }


    /**
     * tests the accept() method
     */
    public void testAccept() {
        ArrayQueue<Person> queue = new ArrayQueue<Person>();
        ColonyCalculator calculator1 = new ColonyCalculator(queue, planets);
        assertFalse(calculator1.accept());
        assertFalse(calculator.accept());
        calculator.reject();
        assertFalse(calculator.accept());
        calculator.reject();
        assertTrue(calculator.accept());
    }


    /**
     * tests the reject() method
     */
    public void testReject() {
        assertFalse(calculator.accept());
        calculator.reject();
        ArrayQueue<Person> queue = new ArrayQueue<Person>();
        queue.enqueue(new Person("jim", 5, 3, 2, "Planet2"));
        queue.enqueue(new Person("nill", 5, 3, 5, "Planet3"));
        queue.enqueue(new Person("till", 5, 3, 5, "Planet1"));
        queue.enqueue(new Person("zill", 5, 3, 5, "nowhere"));
        assertTrue(queue.equals(applicants));
    }


    /**
     * tests the getPlanetIndex() method
     */
    public void testGetPlanetIndex() {
        assertEquals(0, calculator.getPlanetIndex("Planet1"));
        assertEquals(-1, calculator.getPlanetIndex("nowhere"));
    }
}
