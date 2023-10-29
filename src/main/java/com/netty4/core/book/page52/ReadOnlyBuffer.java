package com.netty4.core.book.page52;

import java.nio.ByteBuffer;

/**
 * @Author Rrow
 * @Date 2023/10/29 21:32
 * Description: 只读缓冲区
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(((byte) i));  // 添加的过程中 position会累加
        }
        buffer.flip();    // 调用 flip 来将 position置为0 limit置为position的位置
        System.out.println("buffer.position() = " + buffer.position());

        // 创建和源缓冲区一样的只读缓冲区
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println("readOnlyBuffer.position() = " + readOnlyBuffer.position());
        System.out.println("readOnlyBuffer.limit() = " + readOnlyBuffer.limit());
        System.out.println("readOnlyBuffer.capacity() = " + readOnlyBuffer.capacity());


        while (readOnlyBuffer.remaining() > 0) {
            System.out.println(readOnlyBuffer.get());
        }

    }
}
