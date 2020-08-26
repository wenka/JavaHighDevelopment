package com.wenka.study.core.btree;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2020/08/26  下午 01:37
 * @description:
 */
public class BTreeMain {

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
        System.out.println(binaryArrayTree.get(8));
        System.out.println(binaryArrayTree.get(9));
        System.out.println(binaryArrayTree.get(10));
        System.out.println(binaryArrayTree.get(100));
    }
}
