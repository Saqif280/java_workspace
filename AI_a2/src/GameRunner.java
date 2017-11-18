/**
 * Name: Saqif Badruddin
 * Student ID: 17200777
 * */

// this class runs the game
public class GameRunner {
    public static void main(String[] args) {
        // setup board args
        int[] board = new int[] { 6,5,6,4,5,7 };
        int[] dc1 = new int[] {1,2};
        int[] dc2 = new int[] {4,4};
        // setup game run
        int players = 1;
        int c1diff = 10000;
        int c2diff = 800;
        // run game
        GameBoard game = new GameBoard(board, dc1, dc2);
        game.runGame(players,c1diff,c2diff);
    }
}
