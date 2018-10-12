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

    public void printTree() {
        printTree(root);
    }

    public void printTree(Node node) {
        System.out.println(node.value);
        if (node.left != null) {
            System.out.println(node.value + " er faren til " + node.left.value);
            System.out.println();
            printTree(node.left);
        } else {
            System.out.println("lovnode");
        }
        if (node.right != null) {
            System.out.println(node.value + " er faren til " + node.right.value);
            System.out.println();
            printTree(node.right);
        } else {
            System.out.println("lovnode");
            System.out.println();
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            System.out.println("No tree found, new tree created with value " + value);
        } else {
            add(value, root);
        }
    }

    public void add(int value, Node curNode) {
        if (value == curNode.value) {
            System.out.println("Duplicate node found, terminated node insertion");
            return;
        } else if (value < curNode.value) {
            if (curNode.left == null) {
                curNode.left = new Node(value);
                System.out.println("Node added left with value " + value + " with parent node " + curNode.value);
                return;
            } else {
                add(value, curNode.left);
                System.out.println("Moved to the left from " + curNode.value + " to " + curNode.left.value);
            }
        } else if (value > curNode.value) {
            if (curNode.right == null) {
                curNode.right = new Node(value);
                System.out.println("Node added left with value " + value + " with parent node " + curNode.value);
                return;
            } else {
                System.out.println("Moved to the left from " + curNode.value + " to " + curNode.right.value);
                add(value, curNode.right);
            }
        }
    }
<<<<<<< HEAD

    public boolean remove(int value) {
        if (existsInTree(value)) {
            return remove(value, find(value));
        } else {
=======
    public boolean remove(int value){
        if(existsInTree(value)){
            return remove(value, root);
        }else{
>>>>>>> eeac9722cf823d8da69d7c1d69f2901d70ae1b98
            return false;
        }
    }

    public boolean remove(int value, Node curNode) {
<<<<<<< HEAD
        if (curNode.left == null && curNode.right == null) {
            Node parent = findParent(curNode);
            if (parent.left != null && parent.left.value == curNode.left.value) {
                parent.left = null;
                return true;
            } else {
                parent.right = null;
                return true;
            }
        }else if(curNode.right == null){  
            Node parent = findParent(curNode);
            if (parent.left != null && parent.left.value == curNode.left.value) {
                parent.left = curNode.left;
                return true;
            } else {
                parent.right = curNode.right;
                return true;
            }

        }else if (curNode.left != null && curNode.right != null) {
            Node parent = findParent(curNode);
            if (parent.left != null && parent.left.value == curNode.left.value) {
                int nearestValue = findNearestSmallerThan(value);
                remove(nearestValue);
                parent.left.value = nearestValue;
                return true;
            }else{
                int nearestValue = findNearestSmallerThan(value);
                remove(nearestValue);
                parent.right.value = nearestValue;
=======
        curNode = find(value);
        if(curNode.left == null && curNode.right == null){
            parent = findParent(curNode);
            if(parent.left.value != null && parent.left.value == curNode.left.value){
                parent.left = null;
                return true;
            }else{
                parent.right = null;
                return true;
            }
        }

        if(curNode.left != null && curNode.right != null){
            parent = findParent(curNode);
            if(parent.left.value == curNode.left.value){
                
            }else{
                parent.right = null;
>>>>>>> eeac9722cf823d8da69d7c1d69f2901d70ae1b98
                return true;
            }
        }




        return false;
        
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
        if (root == null) {
            System.out.println("Value does not exist in tree, tree doesnt have any nodes");
            return false;
        }
        return existsInTree(value, root);
    }

    public boolean existsInTree(int value, Node curNode) {
        if (curNode.value == value) {
            return true;
        }
        if (curNode.left != null && existsInTree(value, curNode.left)) {
            return true;
        }
        if (curNode.right != null && existsInTree(value, curNode.right)) {
            return true;
        }
        return false;
    }

    public int findNearestSmallerThan(int value) {
        if (find(value).left == null && find(value).right == null) {
            return value;
        }
        if (find(value).left == null) {
            return findNearestSmallerThan(value, find(value).right);
        }
        return findNearestSmallerThan(value, find(value));
    }

<<<<<<< HEAD
    public int findNearestSmallerThan(int value, Node curNode) {
        if (curNode.left == null) {
            return curNode.value;
        } else {
            return findNearestSmallerThan(value, curNode.left);
=======
    public int findNearestSmallerThan(int value, Node curNode, int nearest) {
        if (curNode == null) {
            return nearest;
        }
        if (value > curNode.value && curNode.value > nearest) {
            System.out.println("Nearest updated to " + curNode.value);
            return (findNearestSmallerThan(value, curNode, curNode.value));
        } else {
            return (findNearestSmallerThan(value, curNode, nearest));
>>>>>>> eeac9722cf823d8da69d7c1d69f2901d70ae1b98
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
        int[] index = { 0 };
        sortedArray(root, sortedNodes, index);
        return sortedNodes;
    }

    public void sortedArray(Node curNode, int[] sortedNodes, int[] index) {
        if (curNode == null) {
            return;
        }
        sortedArray(curNode.left, sortedNodes, index);
        sortedNodes[index[0]] = curNode.value;
        index[0]++;
        sortedArray(curNode.right, sortedNodes, index);
    }

    public int[] findInRange(int low, int high) {
        int[] tree = sortedArray();
        int length = high - low;
        int[] inRange = new int[length];
        for (int i = 0; i < tree.length; i++) {
            if (high >= tree[i] && tree[i] >= low) {
                inRange[i] = tree[i];
            }
        }
        return inRange;
    }

    // konstruktører til BSTree
    private Node findParent(Node lookFor) {
        return findParent(lookFor, root, root);
    }

    private Node findParent(Node lookFor, Node currNode, Node parent) {
        if (lookFor.value == root.value) {
            return null;
        }
        if (currNode.left.value == lookFor.value || currNode.right.value == lookFor.value) {
            return currNode;
        } else if (lookFor.value < currNode.value) {
            findParent(lookFor, currNode.left, currNode);
        } else if (lookFor.value > currNode.value) {
            findParent(lookFor, currNode.right, currNode);
        }
        return null;
    }

    private Node findGrandparent(Node n) {
        return findParent(findParent(n));
    }

    private Node find(int value) {
        return find(value, root);
    }

    public Node find(int value, Node curNode) {
        if (curNode.value == value) {
            return curNode;
        }
        if (value < curNode.value && curNode.left != null) {
<<<<<<< HEAD
            return find(value, curNode.left);
        }
        if (value > curNode.value && curNode.right != null) {
            return find(value, curNode.right);
=======
            find(value, curNode.left);
        }
        if (value > curNode.value && curNode.right != null) {
            find(value, curNode.right);
>>>>>>> eeac9722cf823d8da69d7c1d69f2901d70ae1b98
        }
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