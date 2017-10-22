import java.util.ArrayList;

public class AlphaBeta {
	
	private int staticEvaluations;
	
	
	public AlphaBeta() {
		staticEvaluations = 0;
	}
	
/**	alpha beta algorithm
 * 
 * @param node
 * @param ht
 * @param achievable
 * @param hope
 * @param useModDaughters
 * @return
 */
	public ArrayList<Object> ab(Node node, int ht, int achievable, int hope, boolean useModDaughters) {
		if(!useModDaughters) {
			return abOnD1(node,ht,achievable,hope);
		} else {
			return abOnD2(node,ht,achievable,hope);
		}
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Object> abOnD1(Node node, int ht, int achievable, int hope){
//		if height is zero or no more moves exist
		if(ht==0 || node.getDaughters().isEmpty()) {
			staticEvaluations++;
			ArrayList<Object> retValues = new ArrayList<Object>();
			ArrayList<Node> principalVar = new ArrayList<Node>();
			retValues.add(node.getE());
			retValues.add(principalVar);
			return retValues;
		} else {
			ArrayList<Object> temp = null;
			int tempAchievable;
			ArrayList<Node> tempPrincipalVar = null;
			Node bestDaughter = null;
//			for each move
			for (int i=0;i<node.getDaughters().size();i++) {
				temp = abOnD1(node.getDaughters().get(i),ht-1,-hope,-achievable);
				tempAchievable = -1*(int)temp.get(0);
//				if better than we can hope, cutoff?
				if (tempAchievable >= hope) {
					return temp;
				}
				int originalAchievable = achievable;
				achievable = Math.max(tempAchievable, achievable);
//				if max changes, it is current best daughter
				if(achievable > originalAchievable || i == 0) {
					bestDaughter = node.getDaughters().get(i);
					tempPrincipalVar = (ArrayList<Node>)temp.get(1);
				}
			}
//			return best daughter
			tempPrincipalVar.add(0,bestDaughter);
			temp.set(0,achievable);
			temp.set(1,tempPrincipalVar);
			return temp;
		}
	}
	
//	MAKE MATCH abOnD1
	@SuppressWarnings("unchecked")
	private ArrayList<Object> abOnD2(Node node, int ht, int achievable, int hope){
//		if height is zero or no more moves exist
		if(ht==0 || node.getReorderedDaughters().isEmpty()) {
			staticEvaluations++;
			ArrayList<Object> retValues = new ArrayList<Object>();
			ArrayList<Node> principalVar = new ArrayList<Node>();
			retValues.add(node.getE());
			retValues.add(principalVar);
			return retValues;
		} else {
			ArrayList<Object> temp = null;
			int tempAchievable;
			ArrayList<Node> tempPrincipalVar = null;
			Node bestDaughter = null;
//			for each move
			for (int i=0;i<node.getReorderedDaughters().size();i++) {
				temp = abOnD1(node.getReorderedDaughters().get(i),ht-1,-hope,-achievable);
				tempAchievable = -1*(int)temp.get(0);
//				if better than we can hope, cutoff?
				if (tempAchievable >= hope) {
					return temp;
				}
				int originalAchievable = achievable;
				achievable = Math.max(tempAchievable, achievable);
//				if max changes, it is current best daughter
				if(achievable > originalAchievable || i == 0) {
					bestDaughter = node.getReorderedDaughters().get(i);
					tempPrincipalVar = (ArrayList<Node>)temp.get(1);
				}
			}
//			return best daughter
			tempPrincipalVar.add(0,bestDaughter);
			temp.set(0,achievable);
			temp.set(1,tempPrincipalVar);
			return temp;
		}
	}
	
	
	public int getNumSE() {
		return staticEvaluations;
	}
}