/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package automatastarter;

/**
 *
 * @author yuetang
 */
import java.util.Random;
public class BriansBrain {
    static int[][] grid;
    static int[][] duplicateGrid;
    static int rows = 20;
    static int cols = 80;
    static boolean simulationRunning = true;
    static int generationCount = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initializeGrid();
        printGrid();
        while (simulationRunning){
            updateGrid();
            printGrid();
            
            //add 1-second delay and handle the exception
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void setDimensions(int r, int c){
        rows = r;
        cols = c;
    }
    
    public static int countOnCells(){
        int count = 0;
        for (int[] row: grid){
            for (int cell: row){
                if (cell == 2){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int countDyingCells(){
        int count = 0;
        for (int[] row: grid){
            for (int cell: row){
                if (cell == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int countOffCells(){
        int count = 0;
        for (int[] row: grid){
            for (int cell: row){
                if (cell == 0){
                    count++;
                }
            }
        }
        return count;
    }
    
    /**
     * Generate and randomize the grid.
     */
    public static void initializeGrid(){
        Random random = new Random();
        grid = new int[rows][cols];
        duplicateGrid = new int[rows][cols];

        //assign a random number between 0 and 2 to each cell
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                grid[r][c] = random.nextInt(3);
            }
        }
        
        //copy the grid into the duplicate grid
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                duplicateGrid[r][c] = grid[r][c];
            }
        }
        generationCount = 0;
    }
    
    /**
     * Check the cell's current state and apply rules. 
     */
    public static void updateGrid(){
        //update the grid according to the values stored in the duplicate grid
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (duplicateGrid[r][c] == 2 || duplicateGrid[r][c] == 1){
                    grid[r][c]--;
                }
                else if (duplicateGrid[r][c] == 0 && countOnCells(r, c) == 2){
                    grid[r][c] = 2;
                }
            }
        }
        
        //copy the grid into the duplicate grid
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                duplicateGrid[r][c] = grid[r][c];
            }
        }
        generationCount++;
    }
    
    /**
     * Count the number of neighboring cells.
     * @param   r   the row of the cell
     * @param   c   the column of the cell
     * @return      the number of neighboring cells
     */
    private static int countOnCells(int r, int c){
        //count the on cells in the 3*3 cell grid around it
        int count = 0;
        for (int i = r - 1; i <= r + 1; i++){
            for (int j = c - 1; j <= c + 1; j++){
                if (i >= 0 && i < rows && j >= 0 && j < cols){
                    if (duplicateGrid[i][j] == 2){
                    count++;
                    }
                }
            }
        }
        return count;
    }
    
    /**
     * print the grid to the console.
     */
    private static void printGrid() {
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Return the grid.
     * @return  the grid
     */
    public static int[][] getGrid(){
        return grid;
    }
}
