package practice;

//	Solve the puzzle by getting to the end of the maze following the path where a one is placed.
public class mazeproblem {

	public static void main(String[] args) {
			// a multi-dimensional matrix 
		int[][] maze = {{1, 1, 1, 1},
						{0, 0, 0, 1},
						{1, 1, 1, 1},
						{1, 0, 0, 0}};
			// prints the matrix to the console
		print(maze);
		
			// initiates the recursive call to solve the maze
		if (traverse(maze, 0, 0)) {
			System.out.println("Solved maze");
		}else {
			System.out.println(" Didn't solve maze");
		}
		
			// reprints the maze showing paths that were taken
		print(maze);
	}
		/* This method checks if the row and column passed in are on the board
		 *and then if the value it holds is a 1 to take the path */
	public static boolean isValid(int[][] maze, int row, int col) {
		if (row >= 0 && row < maze.length && col >= 0 && col < maze.length) {		//checks bounds
			return maze[row][col] == 1;		// checks if given index holds a 1 indicating a path we can take
		}
		return false; 	// otherwise not a path we can take return to call stack
	}
		/* Given the matrix, and the starting point as row/column
		 * Passes the matrix and index to see if its a valid path
		 * Checks if we are at our destination 
		 * If not check neighboring cells to find a path */
		 
	public static boolean traverse(int[][] maze, int row, int col) {
		boolean returnValue = false;
		if (isValid(maze, row, col)) {		// checks if the index is valid
			if ( row == 3 && col == 0) {	// Base case checks if we are at the destination
				return true;	//if true puzzle is solved
			}
			
			maze[row][col] = 9;		// Changes the index value to a 9 to show that it is visited
			
				// up
			if (!returnValue) {
			returnValue = traverse(maze, row - 1, col);}	// go up a row
			
				// down
			if(!returnValue) {
				returnValue = traverse(maze, row + 1, col);}	// go down a row
			
				// left
			if(!returnValue) {
				returnValue = traverse(maze, row, col - 1);}	// go left a column
			
				// right
			if(!returnValue) {
				returnValue = traverse(maze, row, col + 1);}	// go right a column
			}
		if (returnValue) {
			System.out.println(row + "," + col);	// print out the coordinates that are visited to get to destination
		}
		return returnValue;
		}
		
		// method to print out the matrix 
	public static void print(int[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
}


