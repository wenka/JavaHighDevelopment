package com.wenka;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/11/27  下午 03:45
 * Description:
 */
public class ByteTest {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(18);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put("1".getBytes())
                .put("22".getBytes())
                .put("333".getBytes())
                .put("4444".getBytes())
                .putLong(55555);

        byte[] array = buf.array();

        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(array);
        byteBuffer.putLong(22);



        ByteBuffer allocate = ByteBuffer.wrap(byteBuffer.array());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        byte b = allocate.get();
        System.out.println(new String(new byte[]{b}));

        byte[] c = new byte[2];
        allocate.get(c);
        System.out.println(new String(c));

        c = new byte[3];
        allocate.get(c);
        System.out.println(new String(c));

        c = new byte[4];
        allocate.get(c);
        System.out.println(new String(c));
        System.out.println(allocate.getLong());
        System.out.println(allocate.hasRemaining());

        System.out.println(allocate.getLong());
        System.out.println(allocate.hasRemaining());
        allocate.clear();
    }
}
