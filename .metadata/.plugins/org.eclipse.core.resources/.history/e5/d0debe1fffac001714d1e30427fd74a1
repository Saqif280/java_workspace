import java.util.ArrayList;

public class Node {
	
//	static evaluation
	private int e;
//	list of daughters
	private ArrayList<Node> daughters;
//	list of reorderedDaughters
	private ArrayList<Node> reorderedDaughters;
	
	public Node(int static_evaluation) {
		e = static_evaluation;
		daughters = new ArrayList<Node>();
		reorderedDaughters = new ArrayList<Node>();
	}
	
	public void addDaughter(Node d) {
		daughters.add(d);
		reorderedDaughters.add(d);
	}
	
	public void reorderDaughters(ArrayList<Node> newOrder) {
		reorderedDaughters = newOrder;
	}
}
