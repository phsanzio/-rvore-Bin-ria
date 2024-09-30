public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.Insert(new Node(30));
        tree.Insert(new Node(10));
        tree.Insert(new Node(20));
        tree.Insert(new Node(40));
        //tree.Insert(new Node(40));
        //tree.Insert(new Node(30));
        //tree.Insert(new Node(10));
        //tree.Insert(new Node(20));
        tree.Insert(new Node(15));
        tree.Insert(new Node(5));
        // tree.Insert(new Node(52));
        // tree.Insert(new Node(50));
        //tree.Insert(new Node(51));
        //tree.printInOrder(tree.getRoot());
        tree.removeValue(30);
        tree.removeValue(10);
        tree.removeValue(20);
        tree.removeValue(40);
        tree.printInOrder(tree.getRoot());
        //System.out.println(tree.findNode(tree.getRoot(), 40));
        //tree.countNodes(tree.getRoot());
    }
}
