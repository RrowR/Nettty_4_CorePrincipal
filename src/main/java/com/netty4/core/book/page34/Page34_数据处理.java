package com.netty4.core.book.page34;

import java.io.*;

/**
 * @author: Rrow
 * @date: 2023/10/22 17:54
 * Description:
 */
public class Page34_数据处理 {
    public static void main(String[] args) throws IOException {
        // 文件输入流
        FileInputStream inputStream = new FileInputStream("D:\\IDECodeProject\\filetest\\info.txt");
        // 文件输入字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 缓冲字符流
        BufferedReader reader = new BufferedReader(inputStreamReader);
        for (int i = 0; i < 4; i++) {
            // 读取下一行数据
            String readLine = reader.readLine();
            System.out.println(readLine);
        }
    }
}
