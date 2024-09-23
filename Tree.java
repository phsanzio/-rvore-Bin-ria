public class Tree {
    private Node root;

    public Tree(){
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean empty(){
        return root == null;
    }

    private Node insertNew(Node newNode, Node current){
        if (current == null) {
            return newNode;
        }
        if (current.getValue() > newNode.getValue()){
            current.setLeft(insertNew(newNode, current.getLeft()));
        } else {
            current.setRight(insertNew(newNode, current.getRight()));
        }
        return current;
    }

    public void Insert(Node newNode){
        root = insertNew(newNode, root);
    }

    public void printPreOrder(Node element){
        if (element != null) {
            System.out.println(element.getValue() + "\n");
            printPreOrder(element.getLeft());
            printPreOrder(element.getRight());
        }
    }

    // public void printInOrder(Node newNode){
    //     if (newNode != null) {
    //         System.out.println(newNode.getValue() + "\n");
    //         printPreOrder(newNode.getLeft());
    //         printPreOrder(newNode.getRight());
    //     }
    // }

    // public void printPosOrder(Node newNode){
    //     if (newNode != null) {
    //         System.out.println(newNode.getValue() + "\n");
    //         printPreOrder(newNode.getLeft());
    //         printPreOrder(newNode.getRight());
    //     }
    // }

    private Node findNode(Node current, int v){
        if (current == null) {
            return null;
        }
        if (current.getRight() != null) {
            if (current.getRight().getValue() == v) {
                return current;
            }
        }

        if (current.getLeft() != null) {
            if (current.getLeft().getValue() == v) {
                return current;
            }
        }

        if (current.getValue() > v) {
            return findNode(current.getRight(), v);
        } else {
            return findNode(current.getLeft(), v);
        }
    }
}