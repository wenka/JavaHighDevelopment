package com.wenka.study.core.btree;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/08/26  上午 09:16
 * @description:
 */
public interface AbstractTree<T> {

    T put(T t);

    T putLeft(int index, T t);

    T putRight(int index, T t);

    T delete(T t);

    T delete(int index);

    boolean isEmpty();

    T root();

    String printTree();
}
