package adventOfCode.solver;

import java.util.Scanner;

public abstract class AdventOfCodeSolver {

    protected Scanner scanner = new Scanner(System.in);

    // All puzzles follow the same format
    // This code prints out the time it takes to solve the puzzle.
    public void solve() {

        System.out.println("Paste input here (hit enter if the input does not end in a blank line)");
        readInput();

        System.out.println("Start Part 1");
        long start = System.currentTimeMillis();
        solvePart1();
        long end = System.currentTimeMillis();
        System.out.println("Part 1 finished in " + ((double)end-start)/1000.0 + "s");

        System.out.println("\n\nStart Part 2");
        start = System.currentTimeMillis();
        solvePart2();
        end = System.currentTimeMillis();
        System.out.println("Part 2 finished in " + ((double)end-start)/1000.0 + "s");

    }

    protected abstract void readInput();

    protected abstract void solvePart1();

    protected abstract void solvePart2();
}
