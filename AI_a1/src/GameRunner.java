
public class GameRunner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node();
		new TreeConstructor(3,3,0,root);
		System.out.println();
		System.out.println(root.getE());
		for(int i=0;i<root.getDaughters().size();i++) {
			System.out.print("  " + root.getDaughters().get(i).getE()+ ": ");
			for(int j=0;j<root.getDaughters().get(i).getDaughters().size();j++) {
				System.out.print("(" + root.getDaughters().get(i).getDaughters().get(j).getE()+"), ");
			}
			System.out.println();
		}
	}
}
