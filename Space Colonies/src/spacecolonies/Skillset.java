package spacecolonies;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey 

/**
 * The skillset class creates instance of skillset where it contains object ints
 * of the three skills
 * 
 * @author Fiifi Sackey
 * @version 10/31/21
 *
 */
public class Skillset implements Comparable<Skillset> {

    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * constructor for skillset class
     * 
     * @param ag
     *            agriculture skill rank
     * @param med
     *            medicine skill rank
     * @param tech
     *            technology skill rank
     */
    public Skillset(int ag, int med, int tech) {
        this.agriculture = ag;
        this.medicine = med;
        this.technology = tech;
    }


    /**
     * gets the rank for agriculture
     * 
     * @return the agriculture value
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * gets the rank for medicine
     * 
     * @return the medicine value
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * gets the rank for technology
     * 
     * @return the technology value
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * Compares "this" skillset to another skillset and returns true if each
     * skill is less than or equal to the "other" skillset's skills
     * 
     * @param other
     *            other Skillset object that will have its values compared
     *            against "this"
     * @return true if less than or equal to "other" skillset values
     */
    public boolean isLessThanOrEqualTo(Skillset other) {
        return (this.agriculture <= other.getAgriculture()
            && this.medicine <= other.getMedicine() && this.technology <= other
                .getTechnology());
    }


    /**
     * creates a string of skills in alphabetical order in the format of
     * "A:? M:? T:?"
     * 
     * @return string of skills
     */
    public String toString() {
        return "A:" + agriculture + " M:" + medicine + " T:" + technology;
    }


    /**
     * checks if two skillset objects are equal
     * 
     * @param obj
     *            the other object to compare to "this"
     * 
     * @return true if they are equal and false if not
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            Skillset otherSkill = (Skillset)obj;
            if (this.agriculture == otherSkill.getAgriculture()
                && this.medicine == otherSkill.getMedicine()
                && this.technology == otherSkill.getTechnology()) {
                return true;
            }
        }
        return false;
    }


    /**
     * compares the sum of all skills "this" object to another skillset object
     * 
     * @param skills
     *            the other object used for comparing
     * 
     * @return negative if "this" is less than the "skills" sum, greater than if
     *         positive, and zero if equal to
     */
    @Override
    public int compareTo(Skillset skills) {
        if (skills == null) {
            throw new IllegalArgumentException();
        }
        int skillSum = this.agriculture + this.medicine + this.technology;
        int otherSkillSum = skills.getAgriculture() + skills.getMedicine()
            + skills.getTechnology();
        return skillSum - otherSkillSum;
    }

}
