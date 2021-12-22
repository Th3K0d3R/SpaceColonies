/**
 * 
 */
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your Fiifi Sackey (906291314)

/**
 * Parses input from two input data from two data text files and creates planets
 * and queues of applicants
 * 
 * @author Fiifi Sackey
 * 
 * @version 11/11/21
 *
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;

    /**
     * constructor for ColonyReader
     * 
     * @param applicantFileName
     *            text file of the applicants
     * @param planetFileName
     *            text file of the planets
     * @throws ParseException
     *             thrown if there are not the correct amount of skill values
     * @throws FileNotFoundException
     *             thrown if there is no such file
     * @throws SpaceColonyDataException
     *             thrown if there are less than three planets
     * 
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws ParseException,
        FileNotFoundException,
        SpaceColonyDataException {
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
        ColonyCalculator colony = new ColonyCalculator(queue, planets);
        SpaceWindow window = new SpaceWindow(colony);
    }


    private Planet[] readPlanetFile(String fileName)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        planets = new Planet[3];
        Scanner file = new Scanner(new File(fileName));
        int index = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] planet = line.split(",");
            if (planet.length != 5) {
                throw new ParseException("Incorrect amount of skill values", 0);
            }
            int agri = Integer.valueOf(planet[1].replaceAll("\\s", ""));
            int medi = Integer.valueOf(planet[2].replaceAll("\\s", ""));
            int tech = Integer.valueOf(planet[3].replaceAll("\\s", ""));
            int cap = Integer.valueOf(planet[4].replaceAll("\\s", ""));
            if (!isInSkillRange(agri, medi, tech)) {
                throw new SpaceColonyDataException(
                    "Skill levels are not in the desired range of 1-5");
            }
            planets[index] = new Planet(planet[0], agri, medi, tech, cap);
            index++;
        }
        if (index < 3) {
            throw new SpaceColonyDataException("There are less than 3 planets");
        }
        file.close();
        return planets;

    }


    private ArrayQueue<Person> readQueueFile(String fileName)
        throws ParseException,
        FileNotFoundException,
        SpaceColonyDataException {
        queue = new ArrayQueue<Person>();
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.equals("")) {
                line = file.nextLine();
            }
            String[] applicant = line.split("[,]");
            if (applicant.length < 4) {
                throw new ParseException("Incorrect amount of values", 0);
            }
            int agri = Integer.valueOf(applicant[1].replaceAll("\\s", ""));
            int medi = Integer.valueOf(applicant[2].replaceAll("\\s", ""));
            int tech = Integer.valueOf(applicant[3].replaceAll("\\s", ""));
            if (!isInSkillRange(agri, medi, tech)) {
                throw new SpaceColonyDataException(
                    "Skill levels are not in the desired range of 1-5");
            }
            if (applicant.length != 5) {
                queue.enqueue(new Person(applicant[0], agri, medi, tech,
                    "No-Planet"));
            }
            else {
                queue.enqueue(new Person(applicant[0], agri, medi, tech,
                    applicant[4].replaceAll("\\s", "")));
            }

        }
        file.close();
        return queue;

    }


    private boolean isInSkillRange(int num1, int num2, int num3) {
        return ((num1 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num1 <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (num2 >= ColonyCalculator.MIN_SKILL_LEVEL
                && num2 <= ColonyCalculator.MAX_SKILL_LEVEL)
            && (num3 >= ColonyCalculator.MIN_SKILL_LEVEL
                && num3 <= ColonyCalculator.MAX_SKILL_LEVEL));
    }
}
