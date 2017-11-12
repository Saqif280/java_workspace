import java.util.ArrayList;

/**
 * Name: Saqif Badruddin
 * Student ID: 17200777
 * */

// class for creating a game
public class GameBoard {
    // final variables
    private static final Character PLAYER1 = 'X';
    private static final Character PLAYER2 = 'O';
    private static final Character PLAYER1_DC = 'x';
    private static final Character PLAYER2_DC = 'o';
    private static final Character DC = '!';
    private static final Character UNPLAYABLE = '#';
    private static final Character EMPTY = ' ';
    
    // instance variables
    private Character[][] columns;
    private int[] dcCell1;
    private int[] dcCell2;
    private Character currPlayer = PLAYER1;
    
    // constructor
    public GameBoard(int[] c, int[] dc1, int[] dc2) {
        dcCell1 = dc1;
        dcCell2 = dc2;
        
        // initialize gameboard size
        int cols = c.length;
        int rows = 0;
        for(int i=0;i<cols;i++) {
            rows = Math.max(rows, c[i]);
        }
        columns = new Character[cols][rows];
        
        // populate gameboard
        for(int col=0;col<columns.length;col++) {
            for(int row=0;row<columns[col].length;row++) {
                if (col==dcCell1[0] && row==dcCell1[1]
                        || col==dcCell2[0] && row==dcCell2[1]) {
                    // dont count cells
                    columns[col][row] = DC;
                } else if(row < c[col]) {
                    // empty cells
                    columns[col][row] = EMPTY;
                } else {
                    // unplayable cells
                    columns[col][row] = UNPLAYABLE;
                }
                
            }
        }
    }
    
    // make a move on the board
    public boolean makeMove(int c) {
        c--;
        // if out of bounds
        if(c >= columns.length) {
            return false;
        }
        // if there is a playable spot
        for(int r=0;r<columns[c].length;r++) {
            if(columns[c][r]==EMPTY) {
                // place piece here
                columns[c][r]=currPlayer;
                currPlayer = (currPlayer==PLAYER1)?PLAYER2:PLAYER1;
                return true;
            } else if (columns[c][r]==DC) {
                // place dont count piece here
                columns[c][r]=(currPlayer==PLAYER1)?PLAYER1_DC:PLAYER2_DC;
                currPlayer = (currPlayer==PLAYER1)?PLAYER2:PLAYER1;
                return true;
            }
        }
        return false;
    }
    
    // print board
    public void printBoard() {
        System.out.println("\nGame Board:");
        for(int r=columns[0].length-1;r>=0;r--) {
            System.out.print("R"+(r+1)+" ");
            for(int c=0;c<columns.length;c++) {
                System.out.print("["+columns[c][r]+"]");
            }
            System.out.println();
        }
        System.out.print("    ");
        for(int c=0;c<columns.length;c++) {
            System.out.print("C"+(c+1)+" ");
        }
        System.out.print("\n");
    }
    
    public ArrayList<Object> checkGameCompletion() {
        ArrayList<Object> retArray = new ArrayList<Object>();;
        int emptyPositionsCount = 0;
        // if four in a row, return true
        // for each position
        for(int r=0;r<columns[0].length;r++) {
            for(int c=0;c<columns.length;c++) {
                // if valid occupied position
                if(columns[c][r] == PLAYER1 || columns[c][r] == PLAYER2) {
                    Character player = columns[c][r];
                    String winPrint = "Player "+player+" Wins!";
                    int tempR = r;
                    int tempC = c;
                    int numConsecutive;
                    
                    // explore vertical positions
                    numConsecutive = 1;
                    // move up
                    while(numConsecutive < 4
                            && tempR+1<columns[c].length
                            && columns[c][tempR+1] == player) {
                        numConsecutive++;
                        tempR++;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempR = r;
                    // move down
                    while(numConsecutive < 4
                            && tempR-1 >= 0
                            && columns[c][tempR-1] == player) {
                        numConsecutive++;
                        tempR--;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempR = r;
                    
                    // explore horizontal positions
                    numConsecutive = 1;
                    // move right
                    while(numConsecutive < 4
                            && tempC+1<columns.length
                            && columns[tempC+1][r] == player) {
                        numConsecutive++;
                        tempC++;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempC = c;
                    // move down
                    while(numConsecutive < 4
                            && tempC-1 >=0
                            && columns[tempC-1][r] == player) {
                        numConsecutive++;
                        tempC--;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempC = c;
                    
                    // explore diagonal1 positions
                    numConsecutive = 1;
                    // move up right
                    while(numConsecutive < 4
                            && tempC+1<columns.length
                            && tempR+1<columns[c].length
                            && columns[tempC+1][tempR+1] == player) {
                        numConsecutive++;
                        tempC++;
                        tempR++;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempC = c;
                    tempR = r;
                    // move down left
                    while(numConsecutive < 4
                            && tempC-1>=0
                            && tempR-1>=0
                            && columns[tempC-1][tempR-1] == player) {
                        numConsecutive++;
                        tempC--;
                        tempR--;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempC = c;
                    tempR = r;
                    
                    // explore diagonal2 positions
                    numConsecutive = 1;
                    // move up left
                    while(numConsecutive < 4
                            && tempC-1>=0
                            && tempR+1<columns[c].length
                            && columns[tempC-1][tempR+1] == player) {
                        numConsecutive++;
                        tempC--;
                        tempR++;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempC = c;
                    tempR = r;
                    // move down right
                    while(numConsecutive < 4
                            && tempC+1<columns.length
                            && tempR-1>=0
                            && columns[tempC+1][tempR-1] == player) {
                        numConsecutive++;
                        tempC++;
                        tempR--;
                    }
                    if(numConsecutive >= 4) {
                        retArray.add(true);
                        retArray.add(winPrint);
                        return retArray;
                    }
                    tempC = c;
                    tempR = r;
                    
                } else if (columns[c][r] == EMPTY
                        || columns[c][r] == DC) {
                    emptyPositionsCount++;
                }
            }
        }
        
        // if full board, return true
        if(emptyPositionsCount == 0) {
            retArray.add(true);
            retArray.add("It's a tie!");
            return retArray;
        }
        
        // else, return false
        retArray.add(false);
        retArray.add("No one has won yet.");
        return retArray;
    }
    
    
}
