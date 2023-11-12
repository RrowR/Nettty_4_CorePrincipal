package com.netty4.core.book.page53;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Rrow
 * @Date 2023/11/12 18:50
 * Description: 直接缓冲区  allocateDirect
 */
public class DirectBuffer {
    public static void main(String[] args) throws IOException {
        String file = "./1.txt";
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel inChannel = fileInputStream.getChannel();

        String outPutFile = String.format("./1copy.txt");
        // 文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(outPutFile);
        // 文件输出流中获取channel
        FileChannel coutChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            buffer.clear();
            int read = inChannel.read(buffer);

            if (read == -1) {
                break;
            }

            buffer.flip();
            // 通过channel写出到文件
            coutChannel.write(buffer);


        }


    }
}
