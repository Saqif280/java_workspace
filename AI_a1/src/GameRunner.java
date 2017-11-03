/**
 * Name: Saqif Badruddin Student ID: 17200777
 * 
 */
// import java.util.ArrayList;

public class GameRunner {

    public static void main(String[] args) {

        // CODE I USED TO TEST FUNCTIONS

        //// create game tree from notes

        // Node root = new Node(-3);
        //// layer 1
        // Node n1a1 = new Node(6);
        // root.addDaughter(n1a1);
        // Node n1a2 = new Node(3);
        // root.addDaughter(n1a2);
        //// layer 2
        // Node n2a1 = new Node(-6);
        // n1a1.addDaughter(n2a1);
        // Node n2a2 = new Node(-4);
        // n1a1.addDaughter(n2a2);
        // Node n2b1 = new Node(-3);
        // n1a2.addDaughter(n2b1);
        // Node n2b2 = new Node(6);
        // n1a2.addDaughter(n2b2);
        //// layer 3
        // Node n3a1 = new Node(8);
        // n2a1.addDaughter(n3a1);
        // Node n3a2 = new Node(6);
        // n2a1.addDaughter(n3a2);
        // Node n3b1 = new Node(4);
        // n2a2.addDaughter(n3b1);
        // Node n3b2 = new Node(7);
        // n2a2.addDaughter(n3b2);
        // Node n3c1 = new Node(6);
        // n2b1.addDaughter(n3c1);
        // Node n3c2 = new Node(3);
        // n2b1.addDaughter(n3c2);
        // Node n3c3 = new Node(4);
        // n2b1.addDaughter(n3c3);
        // Node n3d1 = new Node(1);
        // n2b2.addDaughter(n3d1);
        // Node n3d2 = new Node(-6);
        // n2b2.addDaughter(n3d2);
        // System.out.println("DEFAULT GAME TREE:");
        // root.printTree(root);

        //// test for tree constructor
        // Node root = new Node();
        // int height = 3;
        // int branchingFactor = 3;
        // int approx = 10;
        // new TreeConstructor(height,branchingFactor,approx,root);
        // System.out.println("DYNAMIC GAME TREE:");
        // System.out.println("Height: "+height);
        // System.out.println("Branching Factor: "+branchingFactor);
        // System.out.println("Approx: "+approx);
        // root.printTree();
        //
        //// test alphabeta
        // AlphaBeta ab = new AlphaBeta();
        // ArrayList<Object> values = ab.ab(root,10,-10000,10000,false);
        // System.out.println("\n\nALPHA BETA:");
        // System.out.println("Returned Value: "+ values.get(0));
        //// System.out.println("Node Value: "+((Node) values.get(2)).getE());
        //// test static evaluations count
        // System.out.println("Num SE: "+ab.getNumSE());
        //// test principal variation
        //// @SuppressWarnings("unchecked")
        //// ArrayList<Node> principalVar = (ArrayList<Node>)values.get(1);
        //// System.out.print("Principal Var: ");
        //// for(int i=0; i<principalVar.size(); i++) {
        //// System.out.print(principalVar.get(i).getE() + ", ");
        //// }
        //
        //// test alphabeta on d2
        // AlphaBeta ab2 = new AlphaBeta();
        // ArrayList<Object> values2 = ab2.ab(root,10,-10000,10000,true);
        // System.out.println("\n\nALPHA BETA ON REORDERED:");
        // System.out.println("Returned Value: "+ values2.get(0));
        // System.out.println("Num SE: "+ab2.getNumSE());
        //
        //// test principal variation reordering
        //// System.out.println("\n\nREORDERED GAME TREE:");
        //// root.printReorderedTree();
        //
        //// reset tree for pvs
        // root.resetReorderedDaughters();
        //
        //// test pvs
        // PrincipalVariationSearch pvs = new PrincipalVariationSearch();
        // ArrayList<Object> valuesPVS = pvs.pvs(root,-10000,10000,10,false);
        // System.out.println("\n\nPVS:");
        // System.out.println("Returned Value: "+ valuesPVS.get(0));
        // System.out.println("Num SE: "+pvs.getNumSE());
        //
        //// test pvs on d2
        // PrincipalVariationSearch pvs2 = new PrincipalVariationSearch();
        // ArrayList<Object> valuesPVS2 = pvs2.pvs(root,-10000,10000,10,true);
        // System.out.println("\n\nPVS ON REORDERED:");
        // System.out.println("Returned Value: "+ valuesPVS2.get(0));
        // System.out.println("Num SE: "+pvs2.getNumSE());

        // END OF CODE I USED TO TEST FUNCTIONS

        // EXPERIMENT
        // heights
        System.out.println("EXPERIMENT:");

        int numABBeatsPVS = 0;
        int numPVSBeatsAB = 0;
        int numTies = 0;
        int numABBeatsPVSpv = 0;
        int numPVSBeatsABpv = 0;
        int numTiesPV = 0;

        for (int h = 4; h <= 6; h++) {
            // branching factor
            for (int b = 3; b <= 21; b += 3) {
                // approximation
                for (int a = 0; a <= 300; a += 50) {
                    // 25 trees
                    int meanAB1SE = 0;
                    int meanAB2SE = 0;
                    int meanPVS1SE = 0;
                    int meanPVS2SE = 0;

                    System.out.println("\nFor h=" + h + ", b=" + b + ", a=" + a + ":");

                    for (int x = 0; x < 25; x++) {
                        // create tree
                        Node root = new Node();
                        new TreeConstructor(h, b, a, root);
                        // run alphabeta
                        AlphaBeta ab = new AlphaBeta();
                        ab.ab(root, 10, -10000, 10000, false);
                        meanAB1SE += ab.getNumSE();
                        // run alphabeta on pv
                        AlphaBeta abPV = new AlphaBeta();
                        abPV.ab(root, 10, -10000, 10000, true);
                        meanAB2SE += abPV.getNumSE();
                        // reset reordered daugters
                        root.resetReorderedDaughters();
                        // run pvs
                        PrincipalVariationSearch pvs = new PrincipalVariationSearch();
                        pvs.pvs(root, -10000, 10000, 10, false);
                        meanPVS1SE += pvs.getNumSE();
                        // run pvs on pv
                        PrincipalVariationSearch pvsPV = new PrincipalVariationSearch();
                        pvsPV.pvs(root, -10000, 10000, 10, true);
                        meanPVS2SE += pvsPV.getNumSE();
                        // add up statistics
                        if (ab.getNumSE() < pvs.getNumSE()) {
                            numABBeatsPVS++;
                        } else if (ab.getNumSE() > pvs.getNumSE()) {
                            numPVSBeatsAB++;
                        } else {
                            numTies++;
                        }
                        if (abPV.getNumSE() < pvsPV.getNumSE()) {
                            numABBeatsPVSpv++;
                        } else if (abPV.getNumSE() > pvsPV.getNumSE()) {
                            numPVSBeatsABpv++;
                            System.out.println(
                                    " - (+1 case in which PVS beats AB with PV)");
                        } else {
                            numTiesPV++;
                        }
                    }

                    meanAB1SE /= 25;
                    meanAB2SE /= 25;
                    meanPVS1SE /= 25;
                    meanPVS2SE /= 25;

                    // print out means of 25 trees
                    System.out.println("mean of the 25 trees on these settings:");
                    System.out.print("without pv: ");
                    System.out.println(meanAB1SE > meanPVS1SE
                            ? "AB > PVS : (" + meanAB1SE + ") > (" + meanPVS1SE + ")"
                            : "AB < PVS : (" + meanAB1SE + ") < (" + meanPVS1SE + ")\"");
                    System.out.print("with pv:    ");
                    System.out.println(meanAB2SE > meanPVS2SE
                            ? "AB > PVS : (" + meanAB2SE + ") > (" + meanPVS2SE + ")"
                            : "AB < PVS : (" + meanAB2SE + ") < (" + meanPVS2SE + ")\"");
                }
            }
        }

        // print out overall general data
        System.out.println("\nOverall:");
        System.out.println("Num times AB beats PVS: " + numABBeatsPVS);
        System.out.println("Num times PVS beats AB: " + numPVSBeatsAB);
        System.out.println("Num times AB and PVS tie: " + numTies);
        System.out.println("Num times AB beats PVS with PV: " + numABBeatsPVSpv);
        System.out.println("Num times PVS beats AB with PV: " + numPVSBeatsABpv);
        System.out.println("Num times AB and PVS tie with PV: " + numTiesPV);

    }
}
