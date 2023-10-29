package com.netty4.core.book.page50;

import java.nio.ByteBuffer;

/**
 * @Author Rrow
 * @Date 2023/10/29 20:34
 * Description: 缓冲区分片
 */
public class BufferSlice {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(((byte) i));
        }

        buffer.position(1);
        buffer.limit(9);
        System.out.println("buffer.position() = " + buffer.position());
        System.out.println("buffer.limit() = " + buffer.limit());
        // 创建子缓冲区,冲position到limit的位置创建了一个缓冲区
        ByteBuffer slice = buffer.slice();
        System.out.println("slice.capacity() = " + slice.capacity());
        System.out.println("slice.position() = " + slice.position());
        System.out.println("slice.limit() = " + slice.limit());

        // 改变子缓冲区的内容
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b *= 10;
            slice.put(i, b);
        }

        while (slice.remaining() > 0) {
            System.out.println(slice.get());
        }

        System.out.println("================================================");

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.remaining() > 0) {
            System.out.println(buffer.get());
        }

    }
}
