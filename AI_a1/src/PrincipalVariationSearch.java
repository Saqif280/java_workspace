
/**
 *       Name: Saqif Badruddin
 * Student ID: 17200777
 * 
 * */
import java.util.ArrayList;

public class PrincipalVariationSearch {

    // INSTANCE VARIABLES
    private int staticEvaluations;

    // CONSTRUCTORS
    public PrincipalVariationSearch() {
        staticEvaluations = 0;
    }

    // METHODS
    /**
     * 
     * @param node
     * @param a
     * @param b
     * @param d
     * @param useModDaughters
     * @return arraylist of objects containing value
     */
    public ArrayList<Object> pvs(Node node, int a, int b, int d,
            boolean useModDaughters) {
        if (!useModDaughters) {
            return pvsOnD1(node, a, b, d);
        } else {
            return pvsOnD2(node, a, b, d);
        }
    }

    public ArrayList<Object> pvsOnD1(Node node, int a, int b, int d) {
        // if d=0 or no moves available
        if (d == 0 || node.getDaughters().isEmpty()) {
            staticEvaluations++;
            ArrayList<Object> retValues = new ArrayList<Object>();
            retValues.add(node.getE());
            return retValues;
        } else {
            // make move(1)
            ArrayList<Object> tempValues1 = pvsOnD1(node.getDaughters().get(0), -b, -a,
                    d - 1);
            int score = -1 * (int) tempValues1.get(0);
            ArrayList<Node> orderedDaughters = new ArrayList<Node>();
            orderedDaughters.add(0, node.getDaughters().get(0));
            // unmake move(1)
            if (score < b) {
                // for moves 2 - last move
                for (int i = 1; i < node.getDaughters().size(); i++) {
                    int lb = Math.max(a, score);
                    int ub = lb + 1;
                    // make move(m)
                    ArrayList<Object> tempValues2 = pvsOnD1(node.getDaughters().get(i),
                            -b, -a, d - 1);
                    int temp = -1 * (int) tempValues2.get(0);
                    if (temp >= ub && temp < b) {
                        tempValues2 = pvsOnD1(node.getDaughters().get(i), -b, -temp,
                                d - 1);
                        temp = -1 * (int) tempValues2.get(0);
                    }
                    // unmake move(m)
                    int originalScore = score;
                    score = Math.max(score, temp);
                    if (score > originalScore) {
                        orderedDaughters.add(0, node.getDaughters().get(i));
                    } else {
                        orderedDaughters.add(node.getDaughters().get(i));
                    }
                    if (temp >= b) {
                        break;
                    }
                }
            }
            node.setReorderedDaughters(orderedDaughters);
            tempValues1.set(0, score);
            return tempValues1;
        }
    }

    public ArrayList<Object> pvsOnD2(Node node, int a, int b, int d) {
        // if d=0 or no moves available
        if (d == 0 || node.getReorderedDaughters().isEmpty()) {
            staticEvaluations++;
            ArrayList<Object> retValues = new ArrayList<Object>();
            retValues.add(node.getE());
            return retValues;
        } else {
            // make move(1)
            ArrayList<Object> tempValues1 = pvsOnD2(node.getReorderedDaughters().get(0),
                    -b, -a, d - 1);
            int score = -1 * (int) tempValues1.get(0);
            // unmake move(1)
            if (score < b) {
                // for moves 2 - last move
                for (int i = 1; i < node.getReorderedDaughters().size(); i++) {
                    int lb = Math.max(a, score);
                    int ub = lb + 1;
                    // make move(m)
                    ArrayList<Object> tempValues2 = pvsOnD2(
                            node.getReorderedDaughters().get(i), -b, -a, d - 1);
                    int temp = -1 * (int) tempValues2.get(0);
                    if (temp >= ub && temp < b) {
                        tempValues2 = pvsOnD2(node.getReorderedDaughters().get(i), -b,
                                -temp, d - 1);
                        temp = -1 * (int) tempValues2.get(0);
                    }
                    // unmake move(m)
                    score = Math.max(score, temp);
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
