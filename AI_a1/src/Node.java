import java.util.ArrayList;

public class Node {
	
//	INSTANCE VARIABLES
//	static evaluation
	private int e;
//	list of daughters
	private ArrayList<Node> daughters;
//	list of reorderedDaughters
	private ArrayList<Node> reorderedDaughters;
	
	
//	PUBLIC CONSTRUCTORS
//	create node
	public Node() {
		daughters = new ArrayList<Node>();
		reorderedDaughters = new ArrayList<Node>();
	}
//	create node with static evaluation
	public Node(int static_evaluation) {
		e = static_evaluation;
		daughters = new ArrayList<Node>();
		reorderedDaughters = new ArrayList<Node>();
	}
	
	
//	ACCESSOR METHODS
//	get static evaluation
	public int getE() {
		return e;
	}
//	get daughters
	public ArrayList<Node> getDaughters() {
		return daughters;
	}
//	get reordered daughters
	public ArrayList<Node> getReorderedDaughters() {
		return reorderedDaughters;
	}
	
	
//	MUTATOR METHODS
//	set static evaluation
	public void setE(int staticEvaluation) {
		e = staticEvaluation;
	}
//	add daughter
	public void addDaughter(Node d) {
		daughters.add(d);
		reorderedDaughters.add(d);
	}
//	set reordered daughters list
	public void reorderDaughters(ArrayList<Node> newOrder) {
		reorderedDaughters = newOrder;
	}
}
