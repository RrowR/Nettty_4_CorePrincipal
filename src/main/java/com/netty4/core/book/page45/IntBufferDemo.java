package com.netty4.core.book.page45;

import java.nio.IntBuffer;

/**
 * @Author Rrow
 * @Date 2023/10/29 15:40
 * Description:
 */
public class IntBufferDemo {
    public static void main(String[] args) {
        // 分配int缓冲区
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); i++) {
            int j = 2 * (i + 1);
            // 将数据写到这个缓冲区，当前位置递增
            buffer.put(j);
        }
        // 重设缓冲区，将限制位置设置到当前位置，然后将当前位置设置为0
        buffer.flip();
        while (buffer.hasRemaining()) {
            int j = buffer.get();
            System.out.println("j = " + j);
        }
    }
}
