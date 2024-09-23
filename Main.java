public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.Insert(new Node(30));
        tree.Insert(new Node(10));
        tree.Insert(new Node(20));
        tree.Insert(new Node(40));

        tree.printPreOrder(tree.getRoot());
    }
}
