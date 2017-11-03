
/**
 *       Name: Saqif Badruddin
 * Student ID: 17200777
 * 
 * */

import java.util.ArrayList;

public class Node {

    // INSTANCE VARIABLES
    // static evaluation
    private int e;
    // list of daughters
    private ArrayList<Node> daughters;
    // list of reorderedDaughters
    private ArrayList<Node> reorderedDaughters;

    // PUBLIC CONSTRUCTORS
    // create node
    public Node() {
        daughters = new ArrayList<Node>();
        reorderedDaughters = new ArrayList<Node>();
    }

    // create node with static evaluation
    public Node(int static_evaluation) {
        e = static_evaluation;
        daughters = new ArrayList<Node>();
        reorderedDaughters = new ArrayList<Node>();
    }

    // ACCESSOR METHODS
    // get static evaluation
    public int getE() {
        return e;
    }

    // get daughters
    public ArrayList<Node> getDaughters() {
        return daughters;
    }

    // get reordered daughters
    public ArrayList<Node> getReorderedDaughters() {
        return reorderedDaughters;
    }

    // MUTATOR METHODS
    // set static evaluation
    public void setE(int staticEvaluation) {
        e = staticEvaluation;
    }

    // add daughter
    public void addDaughter(Node d) {
        daughters.add(d);
        reorderedDaughters.add(d);
    }

    // set reordered daughters list
    public void setReorderedDaughters(ArrayList<Node> newOrder) {
        reorderedDaughters = newOrder;
    }

    // reset all reordered daughters
    public void resetReorderedDaughters() {
        this.reorderedDaughters = this.daughters;
        for (int i = 0; i < this.daughters.size(); i++) {
            this.daughters.get(i).resetReorderedDaughters();
        }
    }

    // PRINT FUNCTIONS
    // print tree
    public void printTree() {
        Node n = this;
        System.out.println(sV(n.e));
        for (int i = 0; i < n.getDaughters().size(); i++) {
            System.out.print("    ");
            n.getDaughters().get(i).printTree(1);
        }
    }

    private void printTree(int l) {
        Node n = this;
        System.out.println(sV(n.e));
        for (int i = 0; i < n.getDaughters().size(); i++) {
            for (int j = 0; j <= l; j++) {
                System.out.print("    ");
            }
            n.getDaughters().get(i).printTree(l + 1);
        }
    }

    // print reordered tree
    public void printReorderedTree() {
        Node n = this;
        System.out.println(sV(n.e));
        for (int i = 0; i < n.getReorderedDaughters().size(); i++) {
            System.out.print("    ");
            n.getReorderedDaughters().get(i).printReorderedTree(1);
        }
    }

    private void printReorderedTree(int l) {
        Node n = this;
        System.out.println(sV(n.e));
        for (int i = 0; i < n.getReorderedDaughters().size(); i++) {
            for (int j = 0; j <= l; j++) {
                System.out.print("    ");
            }
            n.getReorderedDaughters().get(i).printReorderedTree(l + 1);
        }
    }

    // spaced value helper
    private String sV(int val) {
        if (val >= 0) {
            return " " + val;
        }
        return "" + val;
    }
}