public class BSTtest {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.add(5);
        tree.add(6);
        tree.add(2);
        tree.add(2);
        tree.addAll(new int[] { 1, 4, 7, 10, 11, 14, 3 });
        System.out.println("Size");
        System.out.println(tree.size());
        System.out.println();

        int[] list = tree.sortedArray();

        for (int i : list) {
            System.out.println(i);
        }
        
        int[] listInRange = tree.findInRange(2, 10);

        for (int i : listInRange) {
            System.out.println(i);
        }
        System.out.println(tree.existsInTree(7));
        System.out.println(tree.findNearestSmallerThan(7));
        System.out.println(tree.findNearestSmallerThan(10));
        System.out.println(tree.findNearestSmallerThan(1));
        System.out.println(tree.findNearestSmallerThan(7));

        System.out.println(tree.remove(7));
        System.out.println(tree.existsInTree(7));
    }
}