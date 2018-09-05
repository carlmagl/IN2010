public class BSTree implements BSTOper {
    Node root;

    private class Node {
        Node left, right;
        int value;

        //Constructor without value input
        Node() {
            this.left = null;
            this.right = null;
        }

        //constructor with value input
        Node(int v) {
            this.left = null;
            this.right = null;
            this.value = v;
        }
    }

    public void add(int value){

        //check to see if tree is empty
        if(root == null){
            root = new Node(value);
        }else{
            Node curNode = root;
            Node parent = null;

            while(true){
                if(value < curNode.value){
                    System.out.println("Traversing left");
                    parent = curNode;
                    curNode = curNode.left;
                    if(curNode == null){
                        curNode = new Node(value);
                        System.out.println("Node added left");
                        return;
                    }
                }
                if(value > curNode.value){
                    parent = curNode;
                    curNode = curNode.right;
                    System.out.println("Traversing right");
                    if(curNode == null){
                        curNode = new Node(value);
                        System.out.println("Node added right");
                        return;
                    }
                }
            }
        }
    }

    public boolean remove(int value){

        if(root == null){
            System.out.println("Tree is empty, nothing to remove");
            return false;
        }
        Node childRight = null;
        Node childLeft = null;
        Node curNode = root;
        Node parent = null;

        while(true){
            if(value == curNode.value){
                parent.left = childLeft;
                parent.right = childRight;
                return true;
            }
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node node){
        if(node == null){
            return 0;
        }else{
            return (size(node.left) + 1 + size(node.right));
        }
    }

    public boolean existsInTree(int value){
        return existsInTree(value);
    }
    public boolean existsInTree(int value, Node currNode){
        if (currNode == null){
            return false;
        }
        if(value == currNode.value){
            System.out.println("Value found in tree");
            return true;
        }else{
            return(existsInTree(value, currNode.left) || existsInTree(value, currNode.right));
        }
    }

    public int findNearestSmallerThan(int value){
        return 0;
    }

    public void addAll(int[] integers){
        if(integers == null || integers.length == 0){
            System.out.println("Array is empty");
            return;
        }
        for(int i = 0; i < integers.length; i++){
            add(integers[i]);
        }
    }

    public int[] sortedArray(){
        return sortedArray(root);
    } // inorder

    public int[] sortedArray(Node currNode){
        if(currNode == null){
            return null;
        }
        return (new int[]{sortedArray(currNode.left), sortedArray(currNode.right)});
    }

    public int[] findInRange(int low, int high){
        int[] jos = new int[4];
        return jos;
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