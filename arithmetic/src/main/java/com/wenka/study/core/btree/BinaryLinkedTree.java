package com.wenka.study.core.btree;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/08/26  上午 11:21
 * @description:
 */
public class BinaryLinkedTree<T> implements AbstractTree<T> {

    private TreeNode root;

    private int size;

    @Override
    public T put(T t) {
        return null;
    }

    @Override
    public T putLeft(int index, T t) {
        return null;
    }

    @Override
    public T putRight(int index, T t) {
        return null;
    }

    @Override
    public T delete(T t) {
        return null;
    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T root() {
        return root == null ? null : (T) root.value;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isNil(int index) {
        return false;
    }

    /**
     * 获取第<code>index</code>个节点
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     * 获取第<code>index</code>个节点的左子节点
     *
     * @param index
     * @return
     */
    @Override
    public T getLeft(int index) {
        return null;
    }

    /**
     * 获取第<code>index</code>个节点的右子节点
     *
     * @param index
     * @return
     */
    @Override
    public T getRight(int index) {
        return null;
    }

    /**
     * 打印树状二叉树
     *
     * @return
     */
    @Override
    public String printTree() {
        return null;
    }

    static class TreeNode<T> extends BinaryArrayTree.TreeNode {
        TreeNode left;

        TreeNode right;

        public TreeNode(T value, TreeNode left, TreeNode right) {
            super(value);
            this.left = left;
            this.right = right;
        }

        public TreeNode(T value) {
            super(value);
        }

        public boolean isFull() {
            return this.left != null && this.right == null;
        }
    }
}
