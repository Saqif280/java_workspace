import java.util.Scanner;

/**
 * Name: Saqif Badruddin
 * Student ID: 17200777
 * */

// this class runs the game
public class GameRunner {
    public static void main(String[] args) {
        // welcome message  
        System.out.println("Welcome to Much-modified Connect Four!\n");
        
        // board arguments
        int numColumns = 0;
        int[] columns;
        int[] dcCell1 = new int[2];
        int[] dcCell2 = new int[2];
        
        Scanner sc = new Scanner(System.in);
        
        // ask for num columns
        while(numColumns == 0) {
            System.out.println("How many columns? (6-11)");
            // if input is integer
            if(sc.hasNextInt()) {
                // get integer
                numColumns = sc.nextInt();
                // if not within bounds, reset num columns value
                if(numColumns < 6 || numColumns > 11) {
                    numColumns = 0;
                }
            } else {
                sc.next();
            }
        }
        columns = new int[numColumns];
        
        // ask for column lengths
        for(int i=0;i<numColumns;i++) {
            columns[i] = -1;
            while(columns[i] == -1) {
                System.out.println("How long is column "+(i+1)+"?");
                // if input is integer
                if(sc.hasNextInt()) {
                    // get integer
                    int length = sc.nextInt();
                    // if within bounds, set columns value
                    if(length > 0) {
                        columns[i] = length;
                    }
                } else {
                    sc.next();
                }
            }
        }
        
        // ask for dont-count cell positions
        // cell1
        int tempCol=-1;
        int tempRow=-1;
        System.out.println("For first don't-count cell:");
        while(tempCol==-1) {
            System.out.println("Column number? (1-"+numColumns+")");
            // if input is integer
            if(sc.hasNextInt()) {
                // get integer
                tempCol = sc.nextInt()-1;
                // if not within bounds, reset columns value
                if(tempCol < 0 || tempCol >= numColumns) {
                    tempCol = -1;
                }
            } else {
                sc.next();
            }
        }
        while(tempRow==-1) {
            System.out.println("Column number? (1-"+columns[tempCol]+")");
            // if input is integer
            if(sc.hasNextInt()) {
                // get integer
                tempRow = sc.nextInt()-1;
                // if not within bounds, reset columns value
                if(tempRow < 0 || tempRow >= columns[tempCol]) {
                    tempRow = -1;
                }
            } else {
                sc.next();
            }
        }
        dcCell1 = new int[] {tempCol, tempRow};
        // cell2
        tempCol=-1;
        tempRow=-1;
        System.out.println("For second don't-count cell:");
        while(tempCol==-1) {
            System.out.println("Column number? (1-"+numColumns+")");
            // if input is integer
            if(sc.hasNextInt()) {
                // get integer
                tempCol = sc.nextInt()-1;
                // if not within bounds, reset columns value
                if(tempCol < 0 || tempCol >= numColumns) {
                    tempCol = -1;
                }
            } else {
                sc.next();
            }
        }
        while(tempRow==-1) {
            System.out.println("Column number? (1-"+columns[tempCol]+")");
            // if input is integer
            if(sc.hasNextInt()) {
                // get integer
                tempRow = sc.nextInt()-1;
                // if not within bounds, reset columns value
                if(tempRow < 0 || tempRow >= columns[tempCol]) {
                    tempRow = -1;
                }
            } else {
                sc.next();
            }
        }
        dcCell2 = new int[] {tempCol, tempRow};
        sc.close();
        
        // finished collecting values for game board
        System.out.println("\nThank you! Now generating game board ...");
        GameBoard game = new GameBoard(columns, dcCell1, dcCell2);
        game.printBoard();
        
        // collect values for who is playing
    }
}
