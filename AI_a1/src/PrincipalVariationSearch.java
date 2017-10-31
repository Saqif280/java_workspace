import java.util.ArrayList;

public class PrincipalVariationSearch {
	
//	INSTANCE VARIABLES
	private int staticEvaluations;
	
//	CONSTRUCTORS
	public PrincipalVariationSearch(){
		staticEvaluations = 0;
	}
	
//	METHODS
//	if root, a = -inf, b = inf
	public ArrayList<Object> pvs(Node node, int a, int b, int d, boolean useModDaughters){
//		if d=0 or no moves available
		if (d==0 || node.getDaughters().isEmpty()) {
			staticEvaluations++;
			ArrayList<Object> retValues = new ArrayList<Object>();
			//ArrayList<Node> principalVar = new ArrayList<Node>();
//			System.out.print
			retValues.add(node.getE());
			//retValues.add(principalVar);
			//retValues.add(null);
			return retValues;
		} else {
//			make move(1)
			ArrayList<Object> tempValues1 = pvs(node.getDaughters().get(0),-b,-a,d-1,false);
			int score = -1*(int)tempValues1.get(0);
//			unmake move(1)
			if (score < b) {
//				for moves 2 - last move
				for (int i=1;i<node.getDaughters().size();i++) {
					int lb = Math.max(a,score);
					int ub = lb+1;
//					make move(m)
					ArrayList<Object> tempValues2 = pvs(node.getDaughters().get(i),-b,-a,d-1,false);
					int temp = -1*(int)tempValues2.get(0);
					if (temp >= ub && temp < b) {
						tempValues2 = pvs(node.getDaughters().get(i),-b,-temp,d-1,false);
						temp = -1*(int)tempValues2.get(0);
					}
//					unmake move(m)
					score = Math.max(score,temp);
					if (temp >= b) {
						break;
					}
				}
			}
			tempValues1.set(0, score);
			return tempValues1;
		}
	}
	
	
	public int getNumSE() {
		return staticEvaluations;
	}
	
}