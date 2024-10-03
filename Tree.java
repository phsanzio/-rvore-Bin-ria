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
        if (existsNode(newNode) == false){
            root = insertNew(newNode, root);
        }
    }

    private boolean existsNode(Node element){
        Node temp = findNode(element.getValue());
        if (temp != null){
            return true;
        } else {
            return false;
        }
    }

    public void printPreOrder(Node element){
        if (element != null) {
            System.out.println(element.getValue() + " ");
            printPreOrder(element.getLeft());
            printPreOrder(element.getRight());
        }
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

    private int allNodes(Node element){
        if (element == null) {
            return 0;
        } else {
            return 1 + allNodes(element.getLeft()) + allNodes(element.getRight());
        }
    }

    private int rootNodes(Node element){
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

    private int leafNodes(Node element){
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

    private int height(Node element){
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
    
    private Node removeNode(Node root, int v){
        if (empty()) {
            return root;
        }
        if (root.getValue() > v){
            root.setLeft(removeNode(root.getLeft(), v));
        } else if (root.getValue() < v) {
            root.setRight(removeNode(root.getRight(), v));
        } else {
            if (root.getRight() == null) {
                return root.getRight();
            }
            if (root.getLeft() == null) {
                return root.getLeft();
            }
            Node prox = getProx(root);
            root.setValue(prox.getValue());
            root.setRight(removeNode(root.getRight(), prox.getValue()));
        }
        return root;
    }

    public void removeValue(int v){
        if (findNode(v) != null) {
            removeNode(root, v);
        }
    }

    public void removeEven(Node root){
        if (root != null) {
            if (root.getValue() % 2 == 0){
                removeValue(root.getValue());
            }
            if (root.getLeft() != null) {
                removeEven(root.getLeft());
            }
            if (root.getRight() != null) {
                removeEven(root.getRight());
            }
        }
    }

    private Node searchValue(Node element, int v){
        if (element == null){
            return null;
        } else if(element.getValue() == v){
            return element;
        } else {
            if (element.getValue() > v) {
                return searchValue(element.getLeft(), v);
            } else {
                return searchValue(element.getRight(), v);
            }
        }
    }

    public Node findNode(int v){
        return searchValue(root, v);
    }

    private Node getProx(Node element) {
        element = element.getRight();
        while (element != null && element.getLeft() != null) {
            element = element.getLeft();
        }
        return element;
    }


    public void mirroring(Node element){
        if (element != null) {
            Node temp = element.getLeft();
            element.setLeft(element.getRight());
            element.setRight(temp);
            mirroring(element.getLeft());
            mirroring(element.getRight());
        }
    }


}