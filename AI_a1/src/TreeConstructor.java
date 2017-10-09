import java.util.ArrayList;

public class TreeConstructor {
	
//	INSTANCE VARIABLES
//	height of tree
	private int height;
//	branching factor
	private int branchingFactor;
//	approximation
	private int approx;
//	root node
	private Node root;
	
	
//	PUBLIC CONSTRUCTORS
	public TreeConstructor(int h, int b, int a) {
		height = h;
		branchingFactor = b;
		approx = a;
		
//		t set to random value between -2500 and 2500
		int t = (int)(Math.random()*5000-2500);
//		e is t + value between -approx and approx
		int error = (int)(Math.random()*a*2-a);
//		create root node
		root = new Node(t+error);
	}
	
	
//	ACCESSOR METHODS
//	get root node
	public Node getRoot(){
		return root;
	}
}
