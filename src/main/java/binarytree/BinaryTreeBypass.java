package binarytree;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Logger;

import static java.util.Objects.nonNull;

public class BinaryTreeBypass {
    private static Logger log = Logger.getLogger(BinaryTreeBypass.class.getName());
    private static BinaryTree binaryTree = new BinaryTree();

    public static void main(String[] args) {
        initializeBinaryTree();
        printNodes(binaryTree);

    }

    private static void initializeBinaryTree() {
        binaryTree.add(10);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(44);
        binaryTree.add(15);
        binaryTree.add(6);
        binaryTree.add(1);
        binaryTree.add(83);
        binaryTree.add(30);
        binaryTree.add(11);
    }

    public static void printNodes(BinaryTree binaryTree) {
        Node root = binaryTree.getRoot();
        if (root == null) {
            return;
        }
        Queue<Node> firstQueue = new ArrayDeque<>();
        firstQueue.add(root.getLeft());
        Queue<Node> secondQueue = new ArrayDeque<>();
        secondQueue.add(root.getRight());
        while (!firstQueue.isEmpty()) {
            int n = firstQueue.size();
            while (n-- > 0) {
                Node node1 = firstQueue.poll();
                if (nonNull(node1)) {
                    log.info(String.valueOf(node1.getValue()));
                    if (nonNull(node1.getLeft())) {
                        firstQueue.add(node1.getLeft());
                    }
                    if (nonNull(node1.getRight())) {
                        firstQueue.add(node1.getRight());
                    }
                }
                Node node2 = secondQueue.poll();
                if (nonNull(node2)) {
                    log.info(String.valueOf(node2.getValue()));
                    if (nonNull(node2.getRight())) {
                        secondQueue.add(node2.getRight());
                    }
                    if (nonNull(node2.getLeft())) {
                        secondQueue.add(node2.getLeft());
                    }
                }
            }
        }
    }
}
