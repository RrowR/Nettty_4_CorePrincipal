package com.netty4.core.book.page50;

import java.nio.ByteBuffer;

/**
 * @Author Rrow
 * @Date 2023/10/29 20:27
 * Description:
 */
public class BufferWrap {
    public void myMethod() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        byte array[] = new byte[10];
        // 自己手动来包装缓冲对象，本质还是一个直接数组
        ByteBuffer byteBuffer = ByteBuffer.wrap(array);

    }
}
