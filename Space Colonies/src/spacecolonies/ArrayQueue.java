/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey 

/**
 * Creates an array based queue
 * 
 * @author Fiifi Sackey
 * @version 10/11/21
 * @param <T>
 *
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    /**
     * sets the default capacity of the array
     */
    public static final int DEFAULT_CAPACITY = 20;

    /**
     * non-parameterized constructor for ArrayQueue
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * constructor for ArrayQueue
     * 
     * @param length
     *            the capacity of the
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int length) {
        queue = (T[])new Object[length + 1];
        enqueueIndex = queue.length - 1;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * clears the array
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        enqueueIndex = queue.length - 1;
        dequeueIndex = 0;
        size = 0;

    }


    /**
     * removes value from the front of the queue
     * 
     * @return the value that was removed
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        T removed = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return removed;
    }


    /**
     * adds value to the back of the queue
     * 
     * @param newEntry
     *            value to be added
     */
    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = newEntry;
        size++;
    }


    /**
     * gets the value at the front of the queue
     * 
     * @return the value at the front of the queue
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * checks whether or not the queue is empty
     * 
     * @return true if the queue is empty, false if it is not empty
     */
    @Override
    public boolean isEmpty() {
        return dequeueIndex == (enqueueIndex + 1) % queue.length;
    }


    /**
     * gets the length of the array including the unused spot
     * 
     * @return length of array
     * 
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }


    /**
     * gets the number of items in the queue
     * 
     * @return number of items
     */
    public int getSize() {
        return size;
    }


    private boolean isFull() {
        return dequeueIndex == (enqueueIndex + 2) % queue.length;
    }


    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] oldContents = queue;
            int oldSize = queue.length;
            int newSize = oldSize * 2;
            queue = (T[])new Object[newSize - 1];

            int j = dequeueIndex;
            for (int i = 0; i < oldSize; i++) {
                queue[i] = oldContents[j];
                j = (j + 1) % oldSize;
            }

            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;

        }
    }


    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * creates an array of all the values we currently have in the queue array
     * 
     * @return array of values
     */
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        T[] contents = (T[])new Object[size];
        int j = dequeueIndex;
        for (int i = 0; i < size; i++) {
            contents[i] = queue[j];
            j = (j + 1) % queue.length;
        }
        return contents;
    }


    /**
     * Creates String of the array's values concatenated
     * 
     * @return String of array values
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int j = dequeueIndex;
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                builder.append(queue[j].toString() + ", ");
                j = (j + 1) % queue.length;
            }
            else {
                builder.append(queue[j].toString());
            }

        }
        builder.append("]");
        return builder.toString();
    }


    /**
     * Compares two ArrayQueue's to each other and returns true if they are the
     * same and false if not
     * 
     * @param obj
     *            the Object that is being compared to "this"
     * 
     * @return true or false depending on if two ArrayQueue's are equivalent
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            ArrayQueue<T> otherQueue = (ArrayQueue<T>)obj;
            if (size == otherQueue.getSize()) {
                for (int i = 0; i < size; i++) {
                    T myElement = queue[(dequeueIndex + i) % queue.length];
                    T otherElement = otherQueue.queue[(otherQueue.dequeueIndex
                        + i) % otherQueue.queue.length];
                    if (!myElement.equals(otherElement)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;

    }

}
