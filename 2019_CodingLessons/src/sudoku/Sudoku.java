package sudoku;

public class Sudoku {

	/**
	 * main runnable method.  In FRC code, we
	 * will never have this method.  The main
	 * method starting our robot is part of the 
	 * FRC build.
	 * @param args none
	 */
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		if (!sudoku.solve()) {
			sudoku.printPuzzle();
			System.out.println("\nThis Sudoku has no solution!");
		}
	}
	
	// The puzzle is a Sudoku
	int[][] puzzle = 
		{{5, 3, 0,   0, 7, 0,   0, 0, 0},
		 {6, 0, 0,   1, 9, 5,   0, 0, 0},
		 {0, 9, 8,   0, 0, 0,   0, 6, 0},
		 
		 {8, 0, 0,   0, 6, 0,   0, 0, 3},
		 {4, 0, 0,   8, 0, 3,   0, 0, 1},
		 {7, 0, 0,   0, 2, 0,   0, 0, 6},
		 
		 {0, 6, 0,   0, 0, 0,   2, 8, 0},
		 {0, 0, 0,   4, 1, 9,   0, 0, 5},
		 {0, 0, 0,   0, 8, 0,   0, 7, 9}
		};
	
	/**
	 * Solve this puzzle
	 * @return {@code true} if solved {@code false} if no solution 
	 * could be found
	 */
	public boolean solve() {
		
		Tile emptyTile = nextEmptyTile();
		
		// If all the tiles are filled
		// then the puzzle is solved, so print it!
		if (emptyTile == null) {
			printPuzzle();
			System.out.println("\nSolved!");
			return true;
		}
		
		// If an empty tile is found, then 
		// try to fill it in with all possible
		// values until a solution is found
		for (int i=1; i<10; i++) {
			
			// Fill in the tile with the value i
			setTile(emptyTile, i);
			
			// Is the board valid?
			// If not, then continue and 
			// check the next value in this
			// tile
			if (!checkPuzzle(emptyTile)) {
				continue;
			}
			
			// Try solving from here.
			// If it is solved now, then 
			// we are done!
			// NOTE: the solution will
			// have been printed above
			if (solve()) {
				return true;
			}
		}
		
		// If we tried all of the values (1-9), and the 
		// puzzle was not solved, then 
		// blank out this tile, and return false.
		// Returning false will cause the previous
		// value to incremented to the next try
		setTile(emptyTile, 0);
		
		return false;
	}
	
	/**
	 * Check if the puzzle is valid
	 * Note: all zero values are valid, so 
	 * only check the non-zero values in
	 * the puzzle
	 * @param tile the last tile that was set
	 * @return {@code true} if the puzzle is 
	 * valid, {@code false} otherwise
	 */
	public boolean checkPuzzle(Tile tile) {
		
		// The puzzle was valid before this 
		// call, so for efficiency, you should
		// need to check the row, col, and 
		// box where the last value was set
		
		// Uncomment this code, and create the 
		// routines required to solve the 
		// sudoku!
		
//		if (!checkRow(tile.row)) {
//			return false;
//		}
		
//		if (!checkCol(tile.col)) {
//		    return false;
//	    }
	
//		if (!checkBox(tile)) {
//	    	return false;
//      }

		// Without the above methods coded,
		// returning true will fill the 
		// sudoku with 1, and returning
		// false will print the 
		// "Cannot be solved" result.
		return true;
	}
	
	/**
	 * Set the value of the passed in tile to 
	 * the value specified
	 * @param tile to set
	 * @param value to set
	 */
	public void setTile(Tile tile, int value) {
		puzzle[tile.row][tile.col] = value;
	}
	
	/**
	 * Print the current puzzle values in 
	 * a nice layout
	 */
	public void printPuzzle() {
		
		for (int row=0; row<9; row++) {
		
			// Every 3rd row, print a blank line
			if (row%3 == 0) {
				System.out.println();
			}
			
			for (int col=0; col<9; col++) {
			
				// Every 3rd col, add some spaces
				if (col%3 == 0) {
					System.out.print("   ");
				}
				
				// When printing without advancing the row, 
				// use System.out.print() instead of 
				// System.out.println()  (the ln adds a new line)
				System.out.print(puzzle[row][col] + " ");
			}
			
			// End each row with a new line
			System.out.println();
		}
	}
	
	/**
	 * Find the next empty tile in the puzzle
	 * <p>
	 * Return a tile object in order to be
	 * able to return BOTH a row and a col.
	 * 
	 * @return Tile containing the row and 
	 * col of the next empty tile or 
	 * {@code null} if there are no empty
	 * tiles.
	 */
	public Tile nextEmptyTile() {
		
		Tile tile = new Tile();

		for (int row=0; row<puzzle.length; row++) {
			for (int col=0; col<puzzle[row].length; col++) {
				if (puzzle[row][col] == 0) {
					tile.row = row;
					tile.col = col;
					return tile;
				}
			}
		}
		
		// Return null if an empty Tile is not found
		return null;
	}
}
