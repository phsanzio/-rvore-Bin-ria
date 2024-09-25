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
            System.out.println(element.getValue() + " ");
            printPreOrder(element.getLeft());
            printPreOrder(element.getRight());
        }
    }

    public int allNodes(Node element){
        if (element == null) {
            return 0;
        } else {
            return 1 + allNodes(element.getLeft()) + allNodes(element.getRight());
        }
    }

    public int rootNodes(Node element){
        if (element == null){
            return 0;
        } 
        else if (element.getRight() != null){
            return 1 + rootNodes(element.getRight());
        }   
        else if (element.getLeft() != null){
                return 1 + rootNodes(element.getLeft());
        }
        else {
            return 1;
        }
    }

    public int leafNodes(Node element){
        if (element == null){
            return 0;
        } 
        else if (element.getRight() != null && element.getLeft() != null){
            return leafNodes(element.getRight()) + leafNodes(element.getLeft());
        }   
        else if (element.getLeft() != null){
            return leafNodes(element.getLeft());
        } 
        else if (element.getRight() != null){
            return leafNodes(element.getRight());
        }
        else {
            return 1;
        }
    }

    public int height(Node element){
        if (element == null){
            return 0;
        } 
        else {
            int heightLeft = height(element.getLeft());
            int heightRight = height(element.getRight());
            if (heightLeft > heightRight){
                return heightLeft + 1;
            } else {
                return heightRight + 1;
            }
        } 
    }

    public void countNodes(Node root){
        System.out.println("Número de nós na árvore: " + allNodes(root));
        System.out.println("Número de nós não-folhas na árvore: " + rootNodes(root));
        System.out.println("Número de nós folhas na árvore: " + leafNodes(root));
        System.out.println("Altura da árvore: " + height(root));
    }
    
    public void printInOrder(Node newNode){
        if (newNode != null) {
            printInOrder(newNode.getLeft());
            System.out.println(newNode.getValue() + " ");
            printInOrder(newNode.getRight());
        }
    }

    public void printPosOrder(Node newNode){
        if (newNode != null) {
            printPosOrder(newNode.getLeft());
            printPosOrder(newNode.getRight());
            System.out.println(newNode.getValue() + " ");
        }
    }

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