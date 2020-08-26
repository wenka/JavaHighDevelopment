package com.wenka.study.core.btree;

import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/08/26  上午 09:15
 * @description: 基于数组实现的二叉树
 */
public class BinaryArrayTree<T> implements AbstractTree<T> {

    /**
     * 树的所有结点
     */
    private transient TreeNode[] elements;

    private final static int DEFAULT_DEEP = 8;

    /**
     * 树的深度
     */
    private transient int maxDeep;

    private transient int maxSize;

    /**
     * 当前位置
     */
    private int current = -1;
    private int size = 0;

    public BinaryArrayTree() {
        this(DEFAULT_DEEP);
    }

    public BinaryArrayTree(int deep) {
        if (deep < 0) {
            throw new IllegalArgumentException("Illegal deep: " + deep);
        }
        this.maxDeep = deep;
        this.maxSize = (int) Math.pow(2, maxDeep) - 1;
        elements = new TreeNode[this.maxSize];
    }


    @Override
    public T put(T t) {
        if (this.size == this.maxSize) {
            this.grow();
        }
        TreeNode treeNode = new TreeNode(t);
        int index = ++current;
        TreeNode node = this.elements[index];
        this.elements[index] = treeNode;
        this.size++;
        return node == null ? null : (T) node.value;
    }

    @Override
    public T putLeft(int index, T t) {
        if (index < 0) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        // 判断当前位置是否为 null
        if (index >= this.size || this.elements[index] == null) {
            throw new IllegalArgumentException("current parent element's value is empty!");
        }
        if (this.size == this.maxSize || 2 * index + 1 > this.maxSize) {
            this.grow();
        }
        int leftIndex = 2 * index + 1;
        TreeNode treeNode = new TreeNode(t);
        TreeNode node = this.elements[leftIndex];
        if (node == null) {
            this.size++;
        }
        this.elements[leftIndex] = treeNode;
        return node == null ? null : (T) node.value;
    }

    @Override
    public T putRight(int index, T t) {
        if (index < 0) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        // 判断当前位置是否为 null
        if (index >= this.size || this.elements[index] == null) {
            throw new IllegalArgumentException("current parent element's value is empty!");
        }
        if (this.size == this.maxSize || 2 * index + 2 > this.maxSize) {
            this.grow();
        }
        int rightIndex = 2 * index + 2;
        TreeNode treeNode = new TreeNode(t);
        TreeNode node = this.elements[rightIndex];
        if (node == null) {
            this.size++;
        }
        this.elements[rightIndex] = treeNode;
        return node == null ? null : (T) node.value;
    }


    @Override
    public T delete(T t) {
        TreeNode node = null;
        if (t == null) {
            for (int i = 0; i < this.elements.length; i++) {
                TreeNode element = this.elements[i];
                if (element != null && element.value == t) {
                    node = this.elements[i];
                    this.elements[i] = null;
                    // 删除其左子树
                    this.delete(2 * i + 1);
                    // 删除其右子树
                    this.delete(2 * i + 2);
                }
            }
        } else {
            for (int i = 0; i < this.elements.length; i++) {
                TreeNode element = this.elements[i];
                if (element != null && t.equals(element.value)) {
                    node = this.elements[i];
                    this.elements[i] = null;
                    // 删除其左子树
                    this.delete(2 * i + 1);
                    // 删除其右子树
                    this.delete(2 * i + 2);
                }
            }
        }

        if (node != null) {
            this.size--;
        }
        return node == null ? null : (T) node.value;
    }

    @Override
    public T delete(int index) {
        if (index >= this.maxSize) {
            return null;
        }
        if (this.elements[index] == null) {
            return null;
        }
        TreeNode node = this.elements[index];
        this.elements[index] = null;
        // 删除其左子树
        this.delete(2 * index + 1);
        // 删除其右子树
        this.delete(2 * index + 2);
        if (node != null) {
            this.size--;
        }
        return node == null ? null : (T) node.value;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public T root() {
        if (this.size == 0)
            return null;
        return (T) this.elements[0].value;
    }

    @Override
    public String printTree() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.maxDeep; i++) {
            // 遍历每一层
            int beginIndex = (int) Math.pow(2, i) - 1;
            int endIndex = (int) Math.pow(2, i + 1) - 1;
            for (int j = beginIndex; j < endIndex; j++) {
                sb.append(this.elements[j] == null ? "NIL\t" : this.elements[j].value + "\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isNil(int index) {
        return index >= this.maxSize || this.elements[index] == null;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.elements);
    }

    private void grow() {
        this.maxDeep++;
        this.maxSize = (int) Math.pow(2, maxDeep) - 1;
        System.out.println("=====扩容=====");
        System.out.println("深度：" + this.maxDeep + ",最大容量：" + this.maxSize);
        TreeNode[] objects = new TreeNode[this.maxSize];
        System.arraycopy(elements, 0, objects, 0, this.size);
        this.elements = objects;
    }

    static class TreeNode<T> {
        T value;

        TreeNode() {
        }

        TreeNode(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }

    public static void main(String[] args) {
        BinaryArrayTree<Integer> binaryArrayTree = new BinaryArrayTree<>(3);
        for (int i = 0; i < 10; i++) {
            binaryArrayTree.put(i);
        }
        binaryArrayTree.put(null);
        System.out.println(binaryArrayTree.putLeft(3, -1));
        System.out.println(binaryArrayTree.putLeft(8, -10));
//        System.out.println(binaryArrayTree.putRight(18, 10220));
        System.out.println(binaryArrayTree.printTree());
        System.out.println(binaryArrayTree.delete(Integer.valueOf(3)));
        System.out.println(binaryArrayTree.toString());
        System.out.println(binaryArrayTree.printTree());

        System.out.println(binaryArrayTree.isNil(8));
        System.out.println(binaryArrayTree.isNil(9));
        System.out.println(binaryArrayTree.isNil(10));
        System.out.println(binaryArrayTree.isNil(100));
        System.out.println(binaryArrayTree.size());
    }
}
