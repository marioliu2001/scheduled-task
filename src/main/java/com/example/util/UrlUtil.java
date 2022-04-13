package com.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Description TODO
 * @Date 2022/4/13 12:57
 * @Version 1.0
 */
public class UrlUtil {
    public static String send(String url){
        /**
         * 向指定URL发送GET方法请求
         */
        String result = null;
        BufferedReader in = null;

        try {
            //定义url地址
            URL realUrl = new URL(url);

            //打开URL之间的连接
            URLConnection connection = realUrl.openConnection();

            //设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            //建立实际的链接
            connection.connect();

            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            result = in.readLine();
        } catch (Exception e){
            System.out.println("发送get请求出现异常");
            e.printStackTrace();
        }finally {
            //判断关闭流
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
