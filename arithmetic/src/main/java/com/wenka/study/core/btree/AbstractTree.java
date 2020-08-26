package com.wenka.study.core.btree;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/08/26  上午 09:16
 * @description:
 */
public interface AbstractTree<T> {

    /**
     * 顺位添加元素
     *
     * @param t
     * @return
     */
    T put(T t);

    /**
     * 给第<code>index</code>个节点添加左子节点
     *
     * @param index
     * @param t
     * @return
     */
    T putLeft(int index, T t);

    /**
     * 给第<code>index</code>个节点添加右子节点
     *
     * @param index
     * @param t
     * @return
     */
    T putRight(int index, T t);

    /**
     * 删除所有<code>t</code>元素及其子树
     *
     * @param t
     * @return
     */
    T delete(T t);

    /**
     * 删除第<code>index</code>个节点及其子树
     *
     * @param index
     * @return
     */
    T delete(int index);

    /**
     * 判断二叉树是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回二叉树根节点
     *
     * @return
     */
    T root();

    /**
     * 打印树状二叉树
     *
     * @return
     */
    String printTree();

    /**
     * 返回二叉树元素数量
     *
     * @return
     */
    int size();

    /**
     * 判断当前位置是否有值
     *
     * @param index
     * @return
     */
    boolean isNil(int index);
}
