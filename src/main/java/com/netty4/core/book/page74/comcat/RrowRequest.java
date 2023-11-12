package com.netty4.core.book.page74.comcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Rrow
 * @Date 2023/11/12 20:10
 * Description:
 */
public class RrowRequest {
    private String method;
    private String url;

    public RrowRequest(InputStream in) {
        try {
            String content = "";
            byte[] buff = new byte[1024];
            int len = 0;
            if ((len = in.read(buff)) > 0) {
                content = new String(buff, 0, len);
            }
            String line = content.split("\\n")[0];
            String[] arr = line.split("\\s");

            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }
}
