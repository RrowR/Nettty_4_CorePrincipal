package com.netty4.core.book.page46;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Rrow
 * @Date 2023/10/29 16:22
 * Description:
 */
public class BufferDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("1.txt");
        // 创建文件操作管道
        FileChannel channel = fis.getChannel();
        // 分配一个长度为10的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化", buffer);
        // 读取缓冲区
        channel.read(buffer);
        // 准备操作之前，先锁定操作范围
        buffer.flip();
        output("调用flip",buffer);

        // 判断是否有可度数据
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
        }
        output("调用get", buffer);

        buffer.clear();
        output("调用clear()", buffer);
        // 最后关闭管道
        channel.close();
    }

    private static void output(String step, ByteBuffer buffer) {
        System.out.println("step = " + step);
        System.out.print("capacity :" + buffer.capacity() + ", ");
        System.out.print("position: " + buffer.position() + ", ");
        System.out.println("limit " + buffer.limit());
        System.out.println();
    }
}
