import java.util.ArrayList;
import java.util.Scanner;

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
    private Scanner sc = new Scanner(System.in);
    
    // make gameboard from prompts and rungame
    public GameBoard() {
        // welcome message  
        System.out.println("Welcome to Much-modified Connect Four!\n");
        
        // board arguments
        int numColumns = 0;
        int[] c;
        int[] dc1 = new int[2];
        int[] dc2 = new int[2];
        
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
        c = new int[numColumns];
        
        // ask for column lengths
        for(int i=0;i<numColumns;i++) {
            c[i] = -1;
            while(c[i] == -1) {
                System.out.println("How long is column "+(i+1)+"?");
                // if input is integer
                if(sc.hasNextInt()) {
                    // get integer
                    int length = sc.nextInt();
                    // if within bounds, set columns value
                    if(length > 0) {
                        c[i] = length;
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
            System.out.println("Column number? (1-"+c[tempCol]+")");
            // if input is integer
            if(sc.hasNextInt()) {
                // get integer
                tempRow = sc.nextInt()-1;
                // if not within bounds, reset columns value
                if(tempRow < 0 || tempRow >= c[tempCol]) {
                    tempRow = -1;
                }
            } else {
                sc.next();
            }
        }
        dc1 = new int[] {tempCol, tempRow};
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
            System.out.println("Column number? (1-"+c[tempCol]+")");
            // if input is integer
            if(sc.hasNextInt()) {
                // get integer
                tempRow = sc.nextInt()-1;
                // if not within bounds, reset columns value
                if(tempRow < 0 || tempRow >= c[tempCol]) {
                    tempRow = -1;
                }
            } else {
                sc.next();
            }
        }
        dc2 = new int[] {tempCol, tempRow};
        
        // finished collecting values for game board
        System.out.println("\nThank you! Now generating game board ...");
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
        printBoard();
        
        // asks whos playing
        System.out.println("\nWho will be playing?");
        int players = 0;
        while(players==0) {
            System.out.println("(1) computer(X) vs computer(O)");
            System.out.println("(2) human(X) vs computer(O)");
            if(sc.hasNextInt()) {
                players = sc.nextInt();
                if(players != 1 && players != 2) {
                    players = 0;
                }
            } else {
                sc.next();
            }
        }
        players--;
        // ask for who plays first
        int tempCurrPlayer = 0;
        while(tempCurrPlayer==0) {
            System.out.println("Who moves first? (1)"+PLAYER1+" or (2)"+PLAYER2);
            if(sc.hasNextInt()) {
                tempCurrPlayer = sc.nextInt();
                if(tempCurrPlayer != 1 && tempCurrPlayer != 2) {
                    tempCurrPlayer = 0;
                }
            } else {
                sc.next();
            }
        }
        currPlayer=(tempCurrPlayer==1)?PLAYER1:PLAYER2;
        
        // ask for computer difficulty
        int comp1diff = -1;
        int comp2diff = -1;
        while(comp1diff==-1) {
            System.out.println("What is one computer player's difficulty? (1-25000)");
            if(sc.hasNextInt()) {
                comp1diff = sc.nextInt();
                if(comp1diff < 1 || comp1diff > 25000) {
                    comp1diff = -1;
                }
            } else {
                sc.next();
            }
        }
        if(players==0) {
            while(comp2diff==-1) {
                System.out.println("What is other computer player's difficulty? (1-25000)");
                if(sc.hasNextInt()) {
                    comp2diff = sc.nextInt();
                    if(comp2diff < 1 || comp2diff > 25000) {
                        comp2diff = -1;
                    }
                } else {
                    sc.next();
                }
            }
        }
        
        System.out.println("\nThank you! Now we will begin the game ...");
        runGame(players,comp1diff,comp2diff);
        System.out.println("Done.");
    }
    
    // make gameboard with specs
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
    
    // run game
    public void runGame(int p, int c1diff, int c2diff) {
     // if human participant
        if(p==1) {
            // ask to make move until game ends
            while((int)checkGameCompletion().get(0)==-1) {
                System.out.println();
                // if humans turn
                if(currPlayer==PLAYER1) {
                    // ask for move col
                    int col = -1;
                    while(col==-1) {
                        System.out.println("Your move. What column? "
                                + "(1-"+columns.length+")");
                        if(sc.hasNextInt()) {
                            col = sc.nextInt()-1;
                            if(!makeMove(col)) {
                                col = -1;
                            }
                        } else {
                            sc.next();
                        }
                    }
                } else if ((int)checkGameCompletion().get(0)==-1) {
                    // make comp move
                    //int col = (int)(Math.random() * columns.length);
                    int col = monteCarloSearch(c1diff);
                    makeMove(col);
                    System.out.println("Computer move");
                }
                printBoard();
                System.out.println((String)checkGameCompletion().get(1));
            }
            sc.close();
        } else {
            sc.close();
            // play comp game
            while((int)checkGameCompletion().get(0)==-1) {
                //System.out.println();
                // if comp1 turn
                if(currPlayer==PLAYER1) {
                    int col = monteCarloSearch(c1diff);
                    makeMove(col);
                } else if ((int)checkGameCompletion().get(0)==-1) {
                    int col = monteCarloSearch(c2diff);
                    makeMove(col);
                }
                printBoard();
                System.out.println((String)checkGameCompletion().get(1));
            }
        }
    }
    
    // monte carlo search
    private int monteCarloSearch(int runs) {
        // num wins, num lossed, num ties for each column
        int[][] ratios = new int[columns.length][3];
        // run monte carlo search runs amount of times
        for(int i=0;i<runs;i++) {
            //System.out.println(i);
            int[] runVals = monteCarloSearch();
            // win
            int col = runVals[0];
            if(runVals[1]==1) {
                ratios[col][0] += 1;
            } else if (runVals[1]==-1) {
                ratios[col][1] += 1;
            } else {
                ratios[col][2] += 1;
            }
        }
        // find best ratio
        double bestRatio = 0;
        int bestRatioCol = -1;
        for(int i=0;i<ratios.length;i++) {
            if(ratios[i][1]==0 && ratios[i][0]+ratios[i][2]!=0) {
                bestRatioCol = i;
                break;
            } else if (ratios[i][0]+ratios[i][1]+ratios[i][2]!=0){
                double tempRatio = ratios[i][0];
                if(ratios[i][1]!=0) tempRatio /= ratios[i][1];
                if(tempRatio>bestRatio || bestRatioCol == -1) {
                    bestRatio = tempRatio;
                    bestRatioCol = i;
                }
                //System.out.println(i+":"+tempRatio+" = "+ratios[i][0]+"/"+ratios[i][1]);
            }
        }
        
//        for(int i=0;i<ratios.length;i++) {
//            System.out.println(i+": "+ratios[i][0]+"-"+ratios[i][1]+"-"+ratios[i][2]);
//        }
        
        System.out.println("Best Column"+bestRatioCol);
        return bestRatioCol;
    }
    
    // monte carlo iterative
    private int[] monteCarloSearch() {
        // array with col, path result
        int[] retValues = new int[2];
        // copy current player
        Character initialPlayer = currPlayer;
        // copy board
        Character [][] initialBoard = new Character[columns.length][];
        for(int i = 0; i < columns.length; i++) {
            initialBoard[i] = columns[i].clone();
        }
        // while game is not over
        int pathResult = -2;
        int col = -1;
        boolean firstMove = true;
        while((int)checkGameCompletion().get(0)==-1) {
            int tempCol = -1;
            // check if there is a winning move
            for(int i = 0; i < columns.length; i++) {
                if(makeMove(i)) {
                    // if winning move
                    if((int)checkGameCompletion().get(0)!=-1) {
                        pathResult = (int)checkGameCompletion().get(0);
                        tempCol = i;
                        // if first move
                        if(col==-1) {
                            col = i;
                            firstMove=false;
                        }
                        // end loop
                        //System.out.println("win");
                        break;
                    }
                    // undo move
                    undoMove(i);
                }
            }
            // if no  winning move was found
            if (tempCol == -1 && !firstMove) {
                // make random move
                tempCol = (int)(Math.random() * columns.length);
                while(!makeMove(tempCol)) {
                    tempCol = (int)(Math.random() * columns.length);
                }
            } else if (tempCol == -1 && firstMove){
                // make random move
                col = (int)(Math.random() * columns.length);
                while(!makeMove(col)) {
                    col = (int)(Math.random() * columns.length);
                }
                firstMove=false;
            }
            // if game isnt over
            if((int)checkGameCompletion().get(0)==-1) {
                // check if there is a winning move
                tempCol = -1;
                for(int i = 0; i < columns.length; i++) {
                    if(makeMove(i)) {
                        // if winning move
                        if((int)checkGameCompletion().get(0)!=-1) {
                            pathResult = -1*(int)checkGameCompletion().get(0);
                            tempCol = i;
                            // end loop
                            // System.out.println("loss");
                            break;
                        }
                        // undo move
                        undoMove(i);
                    }
                }
                if(tempCol==-1) {
                    tempCol = (int)(Math.random() * columns.length);
                    while(!makeMove(tempCol)) {
                        tempCol = (int)(Math.random() * columns.length);
                    }
                }
            }
        }
        //System.out.println("done");
        if(pathResult==-2) {
            pathResult=0;
            //System.out.println("tie");
        }
        // copy back current player
        currPlayer = initialPlayer;
        // copy back the board
        columns = new Character[initialBoard.length][];
        for(int i = 0; i < initialBoard.length; i++) {
            columns[i] = initialBoard[i].clone();
        }
        // return values
        retValues[0]=col;
        retValues[1]=pathResult;
        return retValues;
    }
    
    // make a move on the board
    private boolean makeMove(int c) {
        // if out of bounds
        if(c >= columns.length || c<0) {
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
    
    // undo move on the board
    private boolean undoMove(int c) {
        // if out of bounds
        if(c >= columns.length || c<0) {
            return false;
        }
        // if there is a played spot
        for(int r=columns[c].length-1;r>=0;r--) {
            // if spot is taken
            if(columns[c][r]==PLAYER1 || columns[c][r]==PLAYER2) {
                // undo place piece here
                columns[c][r]=EMPTY;
                currPlayer = (currPlayer==PLAYER1)?PLAYER2:PLAYER1;
                return true;
            } else if (columns[c][r]==PLAYER1_DC || columns[c][r]==PLAYER2_DC) {
                // place dont count piece here
                columns[c][r]=DC;
                currPlayer = (currPlayer==PLAYER1)?PLAYER2:PLAYER1;
                return true;
            }
        }
        return false;
    }
    
    // check if game is done
    private ArrayList<Object> checkGameCompletion() {
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
                        retArray.add(1);
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
                        retArray.add(1);
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
                        retArray.add(1);
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
                        retArray.add(1);
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
                        retArray.add(1);
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
                        retArray.add(1);
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
                        retArray.add(1);
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
                        retArray.add(1);
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
            retArray.add(0);
            retArray.add("It's a tie!");
            return retArray;
        }
        
        // else, return false
        retArray.add(-1);
        retArray.add("No one has won yet.");
        return retArray;
    }
    
    // print board
    private void printBoard() {
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
        System.out.print("\n\n");
    }
    
    
}
