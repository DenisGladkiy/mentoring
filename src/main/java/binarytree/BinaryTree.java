package binarytree;

public class BinaryTree {
    private Node root;

    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeft(addNode(current.getLeft(), value));
        } else if (value > current.getValue()){
            current.setRight(addNode(current.getRight(), value));
        } else {
            return current;
        }
        return current;
    }

    public Node getRoot() {
        return root;
    }
}
