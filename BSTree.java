public interface BSTOper {
    public void add(int value);

    public boolean remove(int value);

    public int size();

    public boolean existsInTree(int value);

    public int findNearestSmallerThan(int value);

    public void addAll(int[] integers);

    public int[] sortedArray(); // inorder

    public int[] findInRange(int low, int high);
}

public class BSTree implements BSTOper {
    Node root;

    private class Node {
        Node left, right;
        // verdier i venstre subtre er < verdien i noden selv
        // verdier i høyre subtre er > verdien i noden selv
        int value;

        // konstruktører, programmer disse
        Node() {
            this.left = null;
            this.right = null;
        }

        Node(int v) {
            this.left = null;
            this.right = null;
            this.value = v;
        }
    }

    public void add(int value){
        if(root == null){
            root = new Node(value);
        }else{
            Node choosenNode = root;
            Node parent = null;

            while(true){
                //gaa til venstre
                
                
                if(value < root.value){
                choosenNode = choosenNode.left;
                    if(choosenNode == null){
                        this choosenNode = new Node(value);
                        return;
                    }
                }else{
                    choosenNode = choosenNode.right;
                    if(choosenNode == null){
                        this.choosenNode = new Node(value);
                        return;
                    }
                }

            }

        
        }

    }

    public boolean remove(int value){

    }

    public int size(){

    }

    public boolean existsInTree(int value){

    }

    public int findNearestSmallerThan(int value){

    }

    public void addAll(int[] integers){

    }

    public int[] sortedArray(){

    } // inorder

    public int[] findInRange(int low, int high){

    }


    // konstruktører til BSTree
    private Node findParent(Node n) {
        return null;
    }

    private Node findGrandparent(Node n) {
        return null;
    }

    private Node find(int value) {
        return null;
    }

    // metoder fra BSTOper
    // brukes til rød-svarte trær (tilleggsoppgave)
    private static byte BLACK = 1;
    private static byte RED = 2;

    private class RBNode extends Node {
        private byte colour = 0;

        boolean isRed() {
            return colour == RED;
        }

        boolean isBlack() {
            return colour == BLACK;
        }

        void setToRed() {
            colour = RED;
        }

        void setToBlack() {
            colour = BLACK;
        }
    }
}