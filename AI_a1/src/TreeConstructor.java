/**
 * Name: Saqif Badruddin Student ID: 17200777
 * 
 */
public class TreeConstructor {

    // INSTANCE VARIABLES

    // PUBLIC CONSTRUCTORS

    /**
     * Tree Constructor
     * 
     * @param h
     *            = height
     * @param b
     *            = branching factor
     * @param a
     *            = approx (for error)
     * @param node
     *            = root node
     */
    public TreeConstructor(int h, int b, int a, Node node) {
        // t set to random value between -2500 and 2500
        int t = (int) (Math.random() * 5000 - 2500 + 1);
        createTree(h, b, a, t, node);
    }

    // creates nodes with
    private void createTree(int h, int b, int a, int t, Node node) {
        // if interior node
        if (h > 1) {
            // e is t + value between -approx and approx
            int error = (int) (Math.random() * a * 2 - a);
            // set root node
            node.setE(t + error);
            // calc branches
            int bVar = (int) (Math.random() * 100 + 1);
            int numDaughters = b;
            if (bVar <= 5) {
                numDaughters--;
            } else if (bVar <= 10) {
                numDaughters++;
            }
            // choose random daughter
            int randDaughterIndex = (int) (Math.random() * numDaughters);
            // create numDaughters daughters
            for (int i = 0; i < numDaughters; i++) {
                int newT;
                if (i == randDaughterIndex) {
                    newT = -1 * t;
                } else {
                    int min = -1 * t;
                    newT = (int) (min + Math.random() * (10000 - min + 1));
                }
                Node daughter = new Node();
                node.addDaughter(daughter);
                createTree(h - 1, b, a, newT, daughter);
            }
        }
        // if leaf node
        if (h == 1) {
            // set root node
            node.setE(t);
        }
    }
}
