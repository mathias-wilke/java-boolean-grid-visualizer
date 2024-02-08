import java.util.Random;

public class StartUp {

	private static RuleSet ruleSet = RuleSet.BELOUSOV_ZHABOTINSKY_REACTION;
	
    public static void main(String[] args) {
        // Initial setup for visualizer and grid
        BooleanGridVisualizer visualizer = new BooleanGridVisualizer(3, 3);
        visualizer.setVisible(true);
        boolean[][] grid = generateRandomBooleanGrid(300, 300); // Placeholder for grid initialization
        visualizer.drawBooleanArray(grid);
        
        boolean running = true;
        
        if(ruleSet == RuleSet.CONWAYS_GAME_OF_LIFE){
        	visualizer.setTitle("Conway's Game of Life");
		    while (running) {
		        delay(10); // Delay to see the changes
		        grid = updateGridConways(grid); // Update the grid based on the game's rules
		        visualizer.drawBooleanArray(grid);
		    }
        } else if(ruleSet == RuleSet.BELOUSOV_ZHABOTINSKY_REACTION) {
        	visualizer.setTitle("Belousov Zhabotinsky Reaction");
        	while (running) {
		        delay(10); // Delay to see the changes
		        grid = updateGridBelousov(grid); // Update the grid based on the game's rules
		        visualizer.drawBooleanArray(grid);
		    }
        }
    }
    
    /**
     * Updates the grid based on the rules of Conway's Game of Life.
     * 
     * @param grid The current state of the grid.
     * @return A two-dimensional boolean array representing the next state of the grid.
     */
    private static boolean[][] updateGridConways(boolean[][] grid) {
        
    	boolean[][] newGrid = new boolean[grid.length][grid[0].length];
    	
    	for(int x = 0; x < grid.length; x++) {
    		for(int y = 0; y < grid[0].length; y++) {
    			
    			short livingNeighbors = countLivingNeighbors(grid, x, y); 
    			
    			boolean oldState = grid[x][y];
    			boolean newState = oldState;
    			
    			if(oldState && (livingNeighbors < 2 || livingNeighbors > 3)) {
    				newState = false;
    			}
    			
    			if(!oldState && livingNeighbors == 3) {
    				newState = true;
    			}
    			
    			newGrid[x][y] = newState;
    			
    		}
    	}
    	
        return newGrid;
    }

    private static boolean[][] updateGridBelousov(boolean[][] grid) {
        
    	boolean[][] newGrid = new boolean[grid.length][grid[0].length];
    	
    	for(int x = 0; x < grid.length; x++) {
    		for(int y = 0; y < grid[0].length; y++) {
    			
    			short livingNeighbors = countLivingNeighbors(grid, x, y); 
    			
    			boolean oldState = grid[x][y];
    			boolean newState = oldState;
    			
    			System.out.println("TBD");
    			
    			newGrid[x][y] = newState;
    			
    		}
    	}
    	
        return newGrid;
    }

    
    /**
     * Counts the living neighbors around a specific cell in the grid.
     * 
     * @param grid The grid in which to count neighbors.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The number of living neighbors around the cell at [row][col].
     */
    private static short countLivingNeighbors(boolean[][] grid, int row, int col) {
    	// These variables just allow me to write less characters in the if statements
    	int lx = grid.length - 1;
    	int ly = grid[0].length - 1;
    	
    	short livingNeighbors = 0;
    	
    	if(row > 0) {
    		
    		if(col > 0 && grid[row - 1][col - 1])
    			livingNeighbors++;
    		
    		if(grid[row - 1][col])
    			livingNeighbors++;
    		
    		if(col < ly && grid[row - 1][col + 1])
    			livingNeighbors++;
    		
    	}
    	
    	if(col > 0 && grid[row][col - 1])
    		livingNeighbors++;
    	
    	if(col < ly && grid[row][col + 1])
    		livingNeighbors++;
    	
    	if(row < lx) {
    		
    		if(col > 0 && grid[row + 1][col - 1])
    			livingNeighbors++;
    		
    		if(grid[row + 1][col])
    			livingNeighbors++;
    		
    		if(col < ly && grid[row + 1][col + 1])
    			livingNeighbors++;
    		
    	}
    	
        return livingNeighbors;
    }
    
    /**
     * Generates a two-dimensional boolean array with random values.
     * 
     * @param rows The number of rows in the array.
     * @param cols The number of columns in the array.
     * @return A two-dimensional boolean array.
     */
    private static boolean[][] generateRandomBooleanGrid(int rows, int cols) {
        boolean[][] grid = new boolean[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }

        return grid;
    }
    
    /**
     * Delays the program execution for a specified amount of time.
     * 
     * @param time The delay time in milliseconds.
     */
    private static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
    }
}
