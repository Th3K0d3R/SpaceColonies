/**
 * 
 */
package spacecolonies;

import java.util.Arrays;
import list.AList;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey (906291314)

/**
 * Handles acceptions and rejections of the applicants. works together with the
 * SpaceWindow
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/12/21
 *
 */
public class ColonyCalculator {
    private Planet[] planets;
    /**
     * final number of planets
     */
    public static final int NUM_PLANETS = 3;
    /**
     * final minimum skill level
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * final maximum skill level
     */
    public static final int MAX_SKILL_LEVEL = 5;

    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;

    /**
     * constructor for ColonyCalculator
     * 
     * @param queue
     *            queue of applicants
     * @param planets
     *            array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> queue, Planet[] planets) {
        applicantQueue = queue;
        if (applicantQueue == null) {
            throw new IllegalArgumentException();
        }
        this.planets = planets;
        rejectBus = new AList<Person>();
    }


    /**
     * gets the applicantQueue with all of the applicants
     * 
     * @return queue of applicants
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;

    }


    /**
     * gets the planets in an array
     * 
     * @return array of planets
     */
    public Planet[] getPlanets() {
        return planets;

    }


    private boolean canAccept(Planet planet, Person person) {
        return planet.isQualified(person);

    }


    /**
     * if the person has a preference and qualifies for a specific planet then
     * it is returned, and if the person does not have a preference then they
     * are put into the one with the highest capacity given they are qualified
     * for it and there are still spaces left on the planets
     * 
     * @param nextPerson
     *            the next person up on the applicantQueue
     * @return the planet that they are eligible for
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson != null) {
            String preference = nextPerson.getPlanetPreference();
            int index = -1;
            switch (preference) {
                case "Planet1":
                    preference = planets[0].getName();
                    index = getPlanetIndex(preference);
                    break;
                case "Planet2":
                    preference = planets[1].getName();
                    index = getPlanetIndex(preference);
                    break;
                case "Planet3":
                    preference = planets[2].getName();
                    index = getPlanetIndex(preference);
                    break;
                default:
                    preference = "No-Planet";
                    index = getPlanetIndex(preference);
            }
            if (index != -1) {
                Planet desiredPlanet = planets[index];
                if (canAccept(desiredPlanet, nextPerson) && !desiredPlanet
                    .isFull()) {
                    return desiredPlanet;
                }
            }
            else {
                Planet[] planetsCopy = Arrays.copyOf(getPlanets(),
                    planets.length);
                Arrays.sort(planetsCopy);
                for (int i = planetsCopy.length - 1; i >= 0; i--) {
                    if (!planetsCopy[i].isFull() && canAccept(planetsCopy[i],
                        nextPerson)) {
                        return planetsCopy[i];
                    }
                }
            }
        }
        return null;

    }

    /*
     * private Planet getHighestCapacityPlanet(Person person) {
     * return null;
     * 
     * }
     */


    /**
     * Evaluates whether or not a person is accepted or not for a planet
     * 
     * @return true if the person is accepted, false if person is not accepted
     */
    public boolean accept() {
        if (applicantQueue.getSize() > 0) {
            Person applicant = applicantQueue.getFront();
            Planet planetPreference = getPlanetForPerson(applicant);
            if (planetPreference != null) {
                planetPreference.addPerson(applicant);
                applicantQueue.dequeue();
                return true;
            }
        }
        return false;
    }


    /**
     * Removes applicant and puts them on rejectBus back to skill training
     * school
     */
    public void reject() {
        Person applicant = applicantQueue.getFront();
        applicantQueue.dequeue();
        rejectBus.add(applicant);
    }


    /**
     * Finds the index of the planet in the array of planets
     * 
     * @param planet
     *            planet to be find
     * @return the index of the planet from the planets array
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;

    }
}
