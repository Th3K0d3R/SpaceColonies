/**
 * 
 */
package spacecolonies;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey (906291314)

/**
 * @author Fiifi Sackey
 * @version 10/31/21
 *
 */
public class Person {
    private String name;
    private Skillset skills;
    private String planetPreference;

    /**
     * Constructor for person class
     * 
     * @param name
     *            person's name
     * @param agri
     *            person' agriculture level
     * @param medi
     *            person's medicine level
     * @param tech
     *            person's technology level
     * @param planet
     *            person's desired planet
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skillset(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * gets the person's name
     * 
     * @return name of person
     */
    public String getName() {
        return name;
    }


    /**
     * gets the person's skillset
     * 
     * @return person's skillset
     */
    public Skillset getSkills() {
        return skills;
    }


    /**
     * gets the person's planet preference
     * 
     * @return planet preference
     */
    public String getPlanetPreference() {
        return planetPreference;
    }


    /**
     * returns a string compiled with name, skill rank, and planet preference
     * 
     * @return string in format "(Name) A:? M:? T:? Wants: ?" or "No-Planet
     *         (Name) A:? M:? T:?"
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (planetPreference.length() > 0) {
            // String.valueOf(
            builder.append(name + " A:" + skills.getAgriculture() + " M:"
                + skills.getMedicine() + " T:" + skills.getTechnology()
                + " Wants: " + planetPreference);
        }
        else {
            builder.append("No-Planet " + name + " A:" + skills
                .getAgriculture() + " M:" + skills.getMedicine() + " T:"
                + skills.getTechnology());

        }
        return builder.toString();
    }


    /**
     * checks to see if "this" has the same values as the person being compared
     * to
     * 
     * @param obj
     *            other object for comparing to
     *
     * @return true if both person objects are the same or equivalent
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Person person = (Person)obj;
            if (name.equals(person.getName()) && skills.compareTo(person
                .getSkills()) == 0 && planetPreference.equals(person
                    .getPlanetPreference())) {
                return true;
            }
        }
        return false;
    }
}
