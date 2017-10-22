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
//		System.out.println("GAME TREE:");
//		System.out.println(root.getE());
//		for(int i=0;i<root.getDaughters().size();i++) {
//			System.out.println("   " + root.getDaughters().get(i).getE()+ ":");
//			for(int j=0;j<root.getDaughters().get(i).getDaughters().size();j++) {
//				System.out.println("     " + root.getDaughters().get(i).getDaughters().get(j).getE()+":");
//				for(int k=0;k<root.getDaughters().get(i).getDaughters().get(j).getDaughters().size();k++) {
//					System.out.println("         "
//					+ root.getDaughters().get(i).getDaughters().get(j).getDaughters().get(k).getE());
//				}
//			}
//		}
		
		
//		test for tree constructor
		Node root = new Node();
		new TreeConstructor(3,3,5,root);
		System.out.println("GAME TREE:");
		System.out.println(root.getE());
		for(int i=0;i<root.getDaughters().size();i++) {
			System.out.print("  " + root.getDaughters().get(i).getE()+ ": ");
			for(int j=0;j<root.getDaughters().get(i).getDaughters().size();j++) {
				System.out.print("(" + root.getDaughters().get(i).getDaughters().get(j).getE()+"), ");
			}
			System.out.println();
		}
		
//		test alphabeta
		AlphaBeta ab = new AlphaBeta();
		ArrayList<Object> values = ab.ab(root,6,-10000,10000,false);
		System.out.println("");
		System.out.println("ALPHA BETA:");
		System.out.println("Value: "+values.get(0));
//		test static evaluations count
		System.out.println("Num SE: "+ab.getNumSE());
//		test principal variation
		@SuppressWarnings("unchecked")
		ArrayList<Node> principalVar = (ArrayList<Node>)values.get(1);
		System.out.print("Principal Var: ");
		for(int i=0; i<principalVar.size(); i++) {
			System.out.print(principalVar.get(i).getE() + ", ");
		}
		
	}
}
