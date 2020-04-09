package com.wenka.study.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目1
 * @param <T>
 */
public class TwoForkTree<T> {

    public static void main(String[] args) {
        TwoForkTree<Integer> tree = new TwoForkTree<Integer>();
        for (int i = 1; i <= 15; i++) {
            tree.add(i);
        }

        System.out.println(tree.getString());
        System.out.println("--------删除 3-------------");

        tree.delete(3);
        System.out.println(tree.getString());


        System.out.println("----------删除 2，3-----------");
        tree.delete(2);
        System.out.println(tree.getString());


    }

    private List<Node> rootList = new ArrayList<>();

    private int size;

    public List<Node> getRoot() {
        return rootList;
    }

    public void add(T v) {
        Node node = new Node();
        node.setValue(v);
        if (size == 0) {
            rootList.add(node);
        } else {
            Node last = this.findLast(this.rootList.get(0));
            node.setParent(last);
            last.add(node);
        }
        size++;
    }

    private Node findLast(Object... nodes) {
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < nodes.length; i++) {
            Node n = (Node) nodes[i];
            if (!n.isFull()) {
                return n;
            } else {
                Node left = n.left;
                Node right = n.right;
                nodeList.add(left);
                nodeList.add(right);
            }
        }
        return findLast(nodeList.toArray());
    }


    private void delete(T v) {
        if (size == 0) {
            return;
        } else {
            Node temp = null;
            for (Node node : this.rootList) {
                temp = this.find(node, v);
                if (temp != null) {
                    break;
                }
            }
            if (temp != null) {
                temp.value = null;
                if (temp.left != null) {
                    this.rootList.add(temp.left);
                }
                if (temp.right != null) {
                    this.rootList.add(temp.right);
                }
            }
        }
        size--;
    }

    private Node find(Node node, T v) {
        if (node.value.equals(v)) {
            return node;
        }
        boolean flag = true;
        Node parent = node;
        Node temp = node;
        while (temp.hasChildren()) {
            Node left = temp.left;
            if (left != null && left.value != null && left.value.equals(v)) {
                return left;
            }
            Node right = temp.right;
            if (right != null && right.value != null && right.value.equals(v)) {
                return right;
            }
            if (flag) {
                temp = parent.left;
                flag = false;
            } else {
                temp = parent.right;
                flag = true;
                parent = parent.left;
            }
        }
        return null;
    }

    private void print(Node node, List<Node> list) {
//        return string;
        list.add(node);
        if (node.hasChildren()) {
            if (node.getLeft() != null && node.getLeft().value != null) {
                print(node.getLeft(), list);
            } else {
                list.add(node.getLeft());
            }
            if (node.getRight() != null && node.getRight().value != null) {
                print(node.getRight(), list);
            } else {
                list.add(node.getRight());
            }
        }
    }


    private String getString() {
        List<List<Node>> n = new ArrayList<>();
        for (Node root : rootList) {
            List<Node> nodeList = new ArrayList<>();
            n.add(nodeList);
            print(root, nodeList);
        }
        return Arrays.toString(n.toArray());
    }


    class Node {

        private Node parent;

        private Node left;

        private T value;

        private Node right;

        public Node getParent() {
            return parent;
        }

        public Node setParent(Node parent) {
            this.parent = parent;
            return this;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean hasChildren() {
            return left != null;
        }

        public boolean isFull() {
            return left != null && right != null;
        }

        public void add(Node node) {
            if (left == null) {
                left = node;
            } else if (right == null) {
                right = node;
            }
        }

        @Override
        public String toString() {
            return value == null ? null : value.toString();
        }
    }
}
