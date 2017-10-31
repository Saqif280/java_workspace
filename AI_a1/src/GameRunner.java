import java.util.ArrayList;

public class GameRunner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
////		create game tree from notes
		
//		Node root = new Node(-3);
////		layer 1
//		Node n1a1 = new Node(6);
//		root.addDaughter(n1a1);
//		Node n1a2 = new Node(3);
//		root.addDaughter(n1a2);
////		layer 2
//		Node n2a1 = new Node(-6);
//		n1a1.addDaughter(n2a1);
//		Node n2a2 = new Node(-4);
//		n1a1.addDaughter(n2a2);
//		Node n2b1 = new Node(-3);
//		n1a2.addDaughter(n2b1);
//		Node n2b2 = new Node(6);
//		n1a2.addDaughter(n2b2);
////		layer 3
//		Node n3a1 = new Node(8);
//		n2a1.addDaughter(n3a1);
//		Node n3a2 = new Node(6);
//		n2a1.addDaughter(n3a2);
//		Node n3b1 = new Node(4);
//		n2a2.addDaughter(n3b1);
//		Node n3b2 = new Node(7);
//		n2a2.addDaughter(n3b2);
//		Node n3c1 = new Node(6);
//		n2b1.addDaughter(n3c1);
//		Node n3c2 = new Node(3);
//		n2b1.addDaughter(n3c2);
//		Node n3c3 = new Node(4);
//		n2b1.addDaughter(n3c3);
//		Node n3d1 = new Node(1);
//		n2b2.addDaughter(n3d1);
//		Node n3d2 = new Node(-6);
//		n2b2.addDaughter(n3d2);
//		System.out.println("DEFAULT GAME TREE:");
//		root.printTree(root);
		
//		test for tree constructor
		Node root = new Node();
		int height = 6;
		int branchingFactor = 6;
		int approx = 10;
		new TreeConstructor(height,branchingFactor,approx,root);
		System.out.println("DYNAMIC GAME TREE:");
		System.out.println("Height: "+height);
		System.out.println("Branching Factor: "+branchingFactor);
		System.out.println("Approx: "+approx);
		//root.printTree(root);
		
//		test alphabeta
		AlphaBeta ab = new AlphaBeta();
		ArrayList<Object> values = ab.ab(root,10,-10000,10000,false);
		System.out.println("\n\nALPHA BETA:");
		System.out.println("Returned Value: "+ values.get(0));
//		System.out.println("Node Value: "+((Node) values.get(2)).getE());
//		test static evaluations count
		System.out.println("Num SE: "+ab.getNumSE());
//		test principal variation
//		@SuppressWarnings("unchecked")
//		ArrayList<Node> principalVar = (ArrayList<Node>)values.get(1);
//		System.out.print("Principal Var: ");
//		for(int i=0; i<principalVar.size(); i++) {
//			System.out.print(principalVar.get(i).getE() + ", ");
//		}
		
//		test alphabeta on d2
		AlphaBeta ab2 = new AlphaBeta();
		ArrayList<Object> values2 = ab2.ab(root,10,-10000,10000,true);
		System.out.println("\n\nALPHA BETA ON REORDERED:");
		System.out.println("Returned Value: "+ values2.get(0));
		System.out.println("Num SE: "+ab2.getNumSE());
		
//		test principal variation reordering
//		System.out.println("\n\nREORDERED GAME TREE:");
//		root.printReorderedTree();
		
//		reset tree for pvs
		root.resetReorderedDaughters();
		
//		test pvs
		PrincipalVariationSearch pvs = new PrincipalVariationSearch();
		ArrayList<Object> valuesPVS = pvs.pvs(root,-10000,10000,10,false);
		System.out.println("\n\nPVS:");
		System.out.println("Returned Value: "+ valuesPVS.get(0));
		System.out.println("Num SE: "+pvs.getNumSE());
		
//		test pvs on d2
		PrincipalVariationSearch pvs2 = new PrincipalVariationSearch();
		ArrayList<Object> valuesPVS2 = pvs2.pvs(root,-10000,10000,10,true);
		System.out.println("\n\nPVS ON REORDERED:");
		System.out.println("Returned Value: "+ valuesPVS2.get(0));
		System.out.println("Num SE: "+pvs2.getNumSE());
	}
}
