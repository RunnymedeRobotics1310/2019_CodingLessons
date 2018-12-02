package adventOfCode.day02;

import adventOfCode.solver.AdventOfCodeSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day02 extends AdventOfCodeSolver {

    public static void main(String[] args) {
        new Day02().solve();
    }

    /* **********************************************************************************
     * Read the input
     * **********************************************************************************/

    List<String> boxIds = new ArrayList<String>();

    protected void readInput() {

        while (true) {
            String inputLine = scanner.nextLine();

            if (inputLine.trim().isEmpty()) {
                break;
            }

            boxIds.add(inputLine);
        }
    }

    /* **********************************************************************************
     * Part 1
     * **********************************************************************************/
    protected void solvePart1() {

        int twos = 0;
        int threes = 0;

        for (String boxId: boxIds) {

            // Count each letter in the boxId using
            // a map to hold the character and count
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c: boxId.toCharArray()) {
                if (charCount.containsKey(c)) {
                    int count = charCount.get(c);
                    charCount.put(c, count+1);
                } else {
                    charCount.put(c, 1);
                }
            }

            // Once each letter is counted,
            // look for twos and threes
            boolean twoFound = false;
            boolean threeFound = false;
            for (Map.Entry<Character, Integer> entry: charCount.entrySet()) {
                if (entry.getValue() == 2) {
                    twoFound = true;
                }
                if (entry.getValue() == 3) {
                    threeFound = true;
                }
            }

            if (twoFound) {
                twos++;
            }

            if (threeFound) {
                threes++;
            }
        }

        System.out.println("Checksum " + twos * threes);
    }

    /* **********************************************************************************
     * Part 2
     * **********************************************************************************/
    protected void solvePart2() {

        // Look through all of the boxes to try to find two
        // boxes with a one letter difference
        for (int i=0; i<boxIds.size(); i++) {

            for (int j=i+1; j<boxIds.size(); j++) {

                if (differentChars(boxIds.get(i), boxIds.get(j)) == 1) {

                    String output = "";
                    char[] box1Chars = boxIds.get(i).toCharArray();
                    char[] box2Chars = boxIds.get(j).toCharArray();

                    for (int c=0; c<box1Chars.length; c++) {
                        if (box1Chars[c] == box2Chars[c]) {
                            output += box1Chars[c];
                        }
                    }
                    System.out.println(output);
                    return;
                }
            }
        }
        System.out.println("Unsolved");
    }

    private int differentChars(String a, String b) {

        if(a.length() != b.length()) {
            System.out.println("Box ids of different length found " + a + " : " + b);
        }

        int differences = 0;

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        for (int i=0; i<aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                differences++;
            }
        }

        return differences;
    }
}
