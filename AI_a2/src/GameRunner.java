/**
 * Name: Saqif Badruddin
 * Student ID: 17200777
 * */

// this class runs the game
public class GameRunner {
    public static void main(String[] args) {
        
        // setup gameboards
        // board config 1
        GameBoard gameboard1 = new GameBoard(new int[] { 6,5,6,4,5,7 }, new int[] {1,2}, new int[] {4,4},'X');
        // board config 2
        GameBoard gameboard2 = new GameBoard(new int[] { 8,2,7,10,3,6,3,10 }, new int[] {2,1}, new int[] {7,0},'X');
        // board config 3
        GameBoard gameboard3 = new GameBoard(new int[] { 2,2,2,2,2,2,2,2 }, new int[] {1,1}, new int[] {0,0},'X');
        // board config 4
        GameBoard gameboard4 = new GameBoard(new int[] { 2,3,4,5,4,3,2 }, new int[] {2,2}, new int[] {4,2},'X');
        
        // play against computer myself (for each board, with each of the following diff: 80,150,500,2000)
        // uncomment as you go
        // on gameboard 1
//        gameboard1.runGame(1, 80, 1);
//        gameboard1.runGame(1, 150, 1);
//        gameboard1.runGame(1, 500, 1);
//        gameboard1.runGame(1, 2000, 1);
        // on gameboard 2
//        gameboard2.runGame(1, 80, 1);
//        gameboard2.runGame(1, 150, 1);
//        gameboard2.runGame(1, 500, 1);
//        gameboard2.runGame(1, 2000, 1);
        // on gameboard 3
//        gameboard3.runGame(1, 80, 1);
//        gameboard3.runGame(1, 150, 1);
//        gameboard3.runGame(1, 500, 1);
//        gameboard3.runGame(1, 2000, 1);
        // on gameboard 4
//        gameboard4.runGame(1, 80, 1);
//        gameboard4.runGame(1, 150, 1);
//        gameboard4.runGame(1, 500, 1);
//        gameboard4.runGame(1, 2000, 1);
        
        // computer vs computer (for each board, with each combination of the following diff: 80,150,500,2000)
        int[] difficulties = new int[] {80,150,500,200};
        // each difficulty combo
        for(int i=0;i<difficulties.length;i++) {
            for(int j=0;j<difficulties.length;j++) {
                System.out.println("Computer 1 ("+difficulties[i]+") vs Computer 2 ("+difficulties[j]+"):");
                // computer 1 wins, losses, ties for each of the 4 gameboards 
                int[][] scores = new int[4][3];
                //play each gameboard iterations times
                int iterations = 10;
                for(int x=0;x<iterations;x++) {
                    // gameboard 1
                    gameboard1.runGame(0, difficulties[i], difficulties[j]);
                    if((int)(gameboard1.checkGameCompletion().get(0))==0) {
                        scores[0][2]++; // tally tie
                    } else if (gameboard1.getCurrentPlayer()==GameBoard.PLAYER1) {
                        scores[0][1]++; // tally player 2 win
                    } else {
                        scores[0][0]++; // tally player 1 win
                    }
                    // gameboard 2
                    gameboard2.runGame(0, difficulties[i], difficulties[j]);
                    if((int)(gameboard2.checkGameCompletion().get(0))==0) {
                        scores[1][2]++; // tally tie
                    } else if (gameboard2.getCurrentPlayer()==GameBoard.PLAYER1) {
                        scores[1][1]++; // tally player 2 win
                    } else {
                        scores[1][0]++; // tally player 1 win
                    }
                    // gameboard 3
                    gameboard3.runGame(0, difficulties[i], difficulties[j]);
                    if((int)(gameboard3.checkGameCompletion().get(0))==0) {
                        scores[2][2]++; // tally tie
                    } else if (gameboard3.getCurrentPlayer()==GameBoard.PLAYER1) {
                        scores[2][1]++; // tally player 2 win
                    } else {
                        scores[2][0]++; // tally player 1 win
                    }
                    // gameboard 4
                    gameboard4.runGame(0, difficulties[i], difficulties[j]);
                    if((int)(gameboard4.checkGameCompletion().get(0))==0) {
                        scores[3][2]++; // tally tie
                    } else if (gameboard4.getCurrentPlayer()==GameBoard.PLAYER1) {
                        scores[3][1]++; // tally player 2 win
                    } else {
                        scores[3][0]++; // tally player 1 win
                    }
                }
                // print scores
                for(int x=0;x<4;x++) {
                    System.out.println("Gameboard "+(x+1)
                            +" - Comp1 Wins: "+((double)scores[x][0]/iterations)*100+"%"
                            +" - Comp2 Wins: "+((double)scores[x][1]/iterations)*100+"%"
                            +" - Ties: "+((double)scores[x][2]/iterations)*100+"%");
                }
                System.out.println();
            }
        }
    }
}
