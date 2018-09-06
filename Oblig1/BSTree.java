public class BSTree implements BSTOper {
    Node root;

    private class Node {
        Node left, right;
        int value;

        // Constructor without value input
        Node() {
            this.left = null;
            this.right = null;
        }

        // constructor with value input
        Node(int v) {
            this.left = null;
            this.right = null;
            this.value = v;
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            System.out.println("No tree found, new tree created");
        } else {
            add(value, root);
        }
    }

    public void add(int value, Node currNode) {
        if (value == currNode.value) {
            System.out.println("Duplicate node found, terminated node insertion");
            return;
        } else if (value < currNode.value) {
            if (currNode.left == null) {
                currNode.left = new Node(value);
                System.out.println("Node added left");
                return;
            } else {
                add(value, currNode.left);
                System.out.println("Moved to the left");
            }
        } else if (value > currNode.value) {
            if (currNode.right == null) {
                currNode.right = new Node(value);
                System.out.println("Node added right");
                return;
            } else {
                System.out.println("Moved to the right");
                add(value, currNode.right);
            }
        }
    }

    public boolean remove(int value) {

        if (root == null) {
            System.out.println("Tree is empty, nothing to remove");
            return false;
        }
        if(existsInTree(value)){

        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    public boolean existsInTree(int value) {
        return existsInTree(value, root);
    }

    public boolean existsInTree(int value, Node currNode) {
        if (currNode == null) {
            System.out.println("Value does not exist in tree, tree doesnt have any nodes");
            return false;
        }
        if(value == currNode.value){
            System.out.println("Value " + value + " does exist in tree");
            return true;
        }
        if(value < currNode.value){
            if(currNode.left == null){
                System.out.println(value + "Does not exist in tree");
                return false;
            }else{
                existsInTree(value, currNode.left);
            }
        }else{
            if(currNode.right == null){
                System.out.println(value + "Does not exist in tree");
                return false;
            }else{
                existsInTree(value, currNode.right);
            }
        }
        return false;
    }

    public int findNearestSmallerThan(int value) {
        int nearest = 0;
        if (root == null) {
            return nearest;
        }
        return findNearestSmallerThan(value, root, nearest);
    }

    public int findNearestSmallerThan(int value, Node currNode, int nearest) {
        if (currNode == null) {
            return nearest;
        }
        if (value > currNode.value && currNode.value > nearest) {
            System.out.println("Nearest updated to " + currNode.value);
            return (findNearestSmallerThan(value, currNode, currNode.value));
        } else {
            return (findNearestSmallerThan(value, currNode, nearest));
        }
    }

    public void addAll(int[] integers) {
        if (integers == null || integers.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < integers.length; i++) {
            add(integers[i]);
        }
    }

    public int[] sortedArray() {
        int[] sortedNodes = new int[size()];
        int index = 0;
        return sortedArray(root, sortedNodes, index);
    }

    public int[] sortedArray(Node currNode, int[] sortedNodes, int index) {
        if (currNode == null) {
            return null;
        }
        sortedArray(currNode.left, sortedNodes, index);
        sortedNodes[index++] =  currNode.value;
        sortedArray(currNode.right, sortedNodes, index);
        sortedNodes[index++] = currNode.value;
        return sortedNodes;
    }

    public int[] findInRange(int low, int high) {
        int[] tree = sortedArray();
        int length = high - low;
        int[] inRange = new int[length];
        for(int i = 0; i < tree.length; i++){
            if(high > tree[i] && tree[i] > low){
                inRange[tree[i]];
            }
        }      
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