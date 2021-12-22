/**
 * 
 */
package spacecolonies;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey 

/**
 * @author Fiifi Sackey
 * @version 10/31/21
 *
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;

    /**
     * constructor for Planet class
     * 
     * @param planetName
     *            name of planet
     * @param planetAgri
     *            minimum agriculture requirement
     * @param planetMedi
     *            minimum medicine requirement
     * @param planetTech
     *            minimum technology requirement
     * @param planetCap
     *            planet's maximum capacity
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        setName(planetName);
        minSkills = new Skillset(planetAgri, planetMedi, planetTech);
        population = new Person[planetCap];
        populationSize = 0;
        capacity = planetCap;
    }


    /**
     * sets the name of the planet
     * 
     * @param planetName
     *            name of planet
     */
    public void setName(String planetName) {
        this.name = planetName;
    }


    /**
     * gets the planet's name
     * 
     * @return name of planet
     */
    public String getName() {
        return name;

    }


    /**
     * gets a planet's minimum skill requirements
     * 
     * @return skills
     */
    public Skillset getSkills() {
        return minSkills;

    }


    /**
     * gets the people on the planet in an array
     * 
     * @return people on the planet
     */
    public Person[] getPopulation() {
        return population;

    }


    /**
     * size of the population
     * 
     * @return the population's size
     */
    public int getPopulationSize() {
        return populationSize;

    }


    /**
     * gets the planet's capacity
     * 
     * @return planet's capacity
     */
    public int getCapacity() {
        return capacity;

    }


    /**
     * gets the amount of available spaces on the planet
     * 
     * @return available spaces
     */
    public int getAvailability() {
        return capacity - populationSize;

    }


    /**
     * checks to see if the planet if full or not
     * 
     * @return true if planet is full, false if not
     */
    public boolean isFull() {
        return getAvailability() == 0;

    }


    /**
     * Checks whether or not person can be added to planet
     * 
     * @param person
     *            the person to be evaluated for a spot on the planet
     * 
     * @return true if person is added, false if not
     */
    public boolean addPerson(Person person) {
        if (!isFull() && isQualified(person)) {
            population[populationSize++] = person;
            return true;
        }
        return false;

    }


    /**
     * checks whether person is qualified for planet
     * 
     * @param person
     *            person whose qualifications will be checked
     * 
     * @return whether person is qualified or not
     */
    public boolean isQualified(Person person) {
        Skillset applicantSkills = person.getSkills();
        return minSkills.isLessThanOrEqualTo(applicantSkills);

    }


    /**
     * Concatenates a String of planet name, population, capacity, and required
     * minimum skills
     * 
     * @return planets information
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ", population " + populationSize + " (cap: "
            + capacity + "), Requires: A >= " + minSkills.getAgriculture()
            + ", M >= " + minSkills.getMedicine() + ", T >= " + minSkills
                .getTechnology());
        return builder.toString();

    }


    /**
     * compares two planets to find which is the greater of the two in terms of
     * the values. If the variables are equal then the next field variables will
     * be checked against each other until there is no more comparisons left
     * 
     * @return true if "this" is greater than "other", false if less than, or
     *         zero if equal
     */
    @Override
    public int compareTo(Planet other) {
        if (capacity - other.getCapacity() != 0) {
            return capacity - other.getCapacity();
        }
        else if (getAvailability() - other.getAvailability() != 0) {
            return getAvailability() - other.getAvailability();
        }
        else if (minSkills.compareTo(other.getSkills()) != 0) {
            return minSkills.compareTo(other.getSkills());
        }
        else if (name.compareTo(other.getName()) != 0) {
            return name.compareTo(other.getName());
        }
        return 0;
    }


    /**
     * checks whether two planets are equal by checking the equivalence of the
     * five field variables
     * 
     * @param obj
     *            the other object to be checked if it equals "this"
     * 
     * @return true if both planets are equal, false if not
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            Planet otherPlanet = (Planet)obj;
            if (name.equals(otherPlanet.getName()) && minSkills.equals(
                otherPlanet.getSkills()) && populationSize == otherPlanet
                    .getPopulationSize() && capacity == otherPlanet
                        .getCapacity()) {
                // checks if people in both populations are equivalent

                if (populationSize == 0 && otherPlanet
                    .getPopulationSize() == 0) {
                    return true;
                }
                Person[] population2 = otherPlanet.getPopulation();
                for (int i = 0; i < populationSize; i++) {

                    if (population2[i].equals(population[i])) {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                return true;
            }

        }
        return false;

    }

    /**
     * checks whether a population has a person in it
     * 
     * @param population2
     *            population that is given to be checked for person
     * @param person
     *            person to be checked for
     * @return true if person is in population, false if not
     */
    /*
     * private boolean contains(Person[] population2, Person person) {
     * return false;
     * }
     */

}
