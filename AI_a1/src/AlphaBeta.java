
public class AlphaBeta {
/**	alpha beta algorithm
 * 
 * @param node
 * @param ht
 * @param achievable
 * @param hope
 * @return
 */
	public int ab(Node node, int ht, int achievable, int hope) {
//		if height is zero or no more moves exist
		if(ht==0 || node.getDaughters().isEmpty()) {
			return node.getE();
		} else {
			int temp;
//			for each move
			for (int i=0;i<node.getDaughters().size();i++) {
				temp = ab(node.getDaughters().get(i),ht-1,-hope,-achievable);
				if (temp >= hope) {
					return temp;
				}
				achievable = Math.max(temp, achievable);
			}
			return achievable;
		}
	}
}
