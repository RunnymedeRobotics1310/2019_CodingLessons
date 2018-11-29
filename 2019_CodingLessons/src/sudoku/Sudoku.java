package sudoku;

public class Sudoku {

	public static void main(String[] args) {
		new Sudoku().solve();
	}

	int[][] puzzle = 
		{{5, 3, 0,  0, 7, 0,  0, 0, 0},
		 {6, 0, 0,  1, 9, 5,  0, 0, 0},
		 {0, 9, 8,  0, 0, 0,  0, 6, 0},
		 
		 {8, 0, 0,  0, 6, 0,  0, 0, 3},
		 {4, 0, 0,  8, 0, 3,  0, 0, 1},
		 {7, 0, 0,  0, 2, 0,  0, 0, 6},
		 
		 {0, 6, 0,  0, 0, 0,  2, 8, 0},
		 {0, 0, 0,  4, 1, 9,  0, 0, 5},
		 {0, 0, 0,  0, 8, 0,  0, 7, 9}
		};
	
	public void solve() {
		
		printPuzzle();
		
		Tile emptyTile = nextEmptyTile();
		
		if (emptyTile == null) {
			System.out.println("Solved!");
			return;
		}
		
		for (int i=1; i<10; i++) {
			
			setTile(emptyTile, i);
			
			if (!checkPuzzle()) {
				continue;
			}
			
			solve();
			
			if (nextEmptyTile() == null) {
				return;
			}
		}
	}
	
	public boolean checkPuzzle() {
		for (int row=)
		if (!checkRow)
		return false;
	}
	
	public void setTile(Tile tile, int value) {
		puzzle[tile.row][tile.col] = value;
	}
	
	public void printPuzzle() {
		for (int row=0; row<puzzle.length; row++) {
			if (row%3 == 0) {
				System.out.println();
			}
			for (int col=0; col<puzzle[row].length; col++) {
				if (col%3 == 0) {
					System.out.print("   ");
				}
				System.out.print(puzzle[row][col] + " ");
			}
			System.out.println();
		}
	}
	
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
		return null;
	}
}
