package adventOfCode.day01;

import adventOfCode.solver.AdventOfCodeSolver;

import java.util.ArrayList;
import java.util.List;

public class Day01 extends AdventOfCodeSolver {

    public static void main(String[] args) {
        new Day01().solve();
    }

    /* **********************************************************************************
     * Read the input
     * **********************************************************************************/

    List<Integer> frequencies = new ArrayList<>();

    protected void readInput() {

        while (true) {
            String inputLine = scanner.nextLine();

            if (inputLine.trim().isEmpty()) {
                break;
            }

            frequencies.add(Integer.valueOf(inputLine));
        }
    }

    /* **********************************************************************************
     * Part 1
     * **********************************************************************************/
     protected void solvePart1() {

        int currentFrequency = 0;

        for (int frequency: frequencies) {
            currentFrequency += frequency;
        }

        System.out.println("Frequency " + currentFrequency);
    }

    /* **********************************************************************************
     * Part 2
     * **********************************************************************************/
    protected void solvePart2() {

        List<Integer> pastFrequencies = new ArrayList<>();

        int currentFrequency = 0;

        // Keep looping through the input until a duplicate is found
        while(true) {
            for (int frequency : frequencies) {
                currentFrequency += frequency;

                // If the current frequency is in the list, then
                // the duplicate is found
                if (pastFrequencies.contains(currentFrequency)) {
                    System.out.println("Duplicate frequency " + currentFrequency);
                    System.out.println("Number of frequencies encountered " + pastFrequencies.size());
                    return;
                }

                // Otherwise, add the value to the past frequencies
                pastFrequencies.add(currentFrequency);
            }
        }
    }
}
