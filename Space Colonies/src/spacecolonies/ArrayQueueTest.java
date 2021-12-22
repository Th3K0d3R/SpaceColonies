/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey (906291314)

/**
 * Test class for ArrayQueue
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/12/21
 * @param <T>
 *
 */
public class ArrayQueueTest<T> extends TestCase {
    private ArrayQueue<Person> queue;
    private Person person;
    private Person person1;
    private Person person2;

    /**
     * instantiates the field variables
     */
    public void setUp() {
        queue = new ArrayQueue<Person>();
        person = new Person("bill", 5, 6, 7, "Zarg");
        person1 = new Person("jill", 7, 6, 5, "Twilight");
        person2 = new Person("grill", 6, 5, 7, "Diamond");
    }


    /**
     * tests the clear() method
     */
    public void testClear() {
        assertTrue(queue.isEmpty());
        queue.enqueue(person);
        queue.enqueue(person1);
        queue.enqueue(person2);
        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
        queue.enqueue(person);
        queue.dequeue();
    }


    /**
     * tests whether dequeue() throws an exception when called on empty array
     */
    public void testDequeueException() {
        Exception exception = null;
        try {
            queue.dequeue();
            fail("dequeue() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * tests the dequeue() method
     */
    public void testDequeue() {
        assertEquals(0, queue.getSize());
        queue.enqueue(person);
        queue.enqueue(person1);
        queue.enqueue(person2);
        assertEquals(3, queue.getSize());
        assertEquals("bill", queue.getFront().getName());
        queue.dequeue();
        assertEquals(2, queue.getSize());
        assertEquals("jill", queue.getFront().getName());

    }


    /**
     * tests the enqueue() method
     */
    public void testEnqueue() {
        assertEquals(0, queue.getSize());
        queue.enqueue(person);
        queue.enqueue(person1);
        queue.enqueue(person2);
        assertEquals(3, queue.getSize());
        assertEquals("bill", queue.getFront().getName());
    }


    /**
     * tests whether an exception is thrown when getFront() is called on empty
     * queue
     */
    public void testGetFrontException() {
        Exception exception = null;
        try {
            queue.getFront();
            fail("getFront() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * tests the getFront() method
     */
    public void testGetFront() {
        assertEquals(0, queue.getSize());
        queue.enqueue(person);
        queue.enqueue(person1);
        queue.enqueue(person2);
        assertEquals(3, queue.getSize());
        assertEquals("bill", queue.getFront().getName());
        queue.dequeue();
        assertEquals("jill", queue.getFront().getName());
        queue.dequeue();
        assertEquals("grill", queue.getFront().getName());

    }


    /**
     * tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(person);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }


    /**
     * test the getLengthOfUnderlyingArray() method
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(21, queue.getLengthOfUnderlyingArray());
        for (int i = 0; i < 24; i++) {
            queue.enqueue(person);
        }
        assertEquals(41, queue.getLengthOfUnderlyingArray());
    }


    /**
     * tests the getSize() method
     */
    public void testGetSize() {
        assertEquals(0, queue.getSize());
        queue.enqueue(person);
        assertEquals(1, queue.getSize());
        queue.dequeue();
        assertEquals(0, queue.getSize());
    }


    /**
     * tests the toArray() method to see if exception is thrown on empty queue
     */
    public void testToArrayException() {
        Exception exception = null;
        try {
            queue.toArray();
            fail("toArray() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * tests the toArray() method
     */
    public void testToArray() {
        queue.enqueue(person);
        queue.enqueue(person1);
        queue.enqueue(person2);
        Object[] contents = queue.toArray();
        Object[] contentsToCompare = new Object[queue.getSize()];
        contentsToCompare[0] = person;
        contentsToCompare[1] = person1;
        contentsToCompare[2] = person2;

        for (int i = 0; i < contents.length; i++) {
            assertTrue(contents[i].equals(contentsToCompare[i]));
        }

    }


    /**
     * tests the toString() method
     */
    public void testToString() {
        assertEquals("[]", queue.toString());
        queue.enqueue(person);
        queue.enqueue(person1);
        queue.enqueue(person2);
        assertEquals("[bill A:5 M:6 T:7 Wants: Zarg, jill A:7 M:6 T:5 Wants: "
            + "Twilight, grill A:6 M:5 T:7 Wants: Diamond]", queue.toString());
    }


    /**
     * tests the equals() method
     */
    public void testEquals() {
        ArrayQueue<Person> peoples = new ArrayQueue<Person>();
        ArrayQueue<Person> whalePeople = new ArrayQueue<Person>();
        whalePeople.enqueue(new Person("Orca", 4, 5, 6, "Atlantic"));
        whalePeople.enqueue(new Person("Killer", 4, 5, 6, "Arctic"));
        queue.enqueue(person);
        queue.enqueue(person1);
        queue.enqueue(person2);
        peoples.enqueue(person);
        peoples.enqueue(person1);
        peoples.enqueue(person2);
        assertTrue(queue.equals(peoples));
        assertFalse(queue.equals(null));
        assertTrue(queue.equals(queue));
        assertFalse(queue.equals(whalePeople));
        whalePeople.enqueue(new Person("Blue", 4, 5, 6, "Antarctica"));
        assertFalse(queue.equals(whalePeople));
    }
}
