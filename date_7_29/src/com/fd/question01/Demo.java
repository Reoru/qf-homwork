package com.fd.question01;

import java.io.*;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/29 0029 上午 11:00
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        final String filePath = "D:\\test.zip";
        final String copyPath = "D:\\test01.zip";
        System.out.println(copyOfStream(filePath, copyPath));
        System.out.println("=================分割线==================");
        System.out.println(copyOfReader(filePath, copyPath));
    }

    private static String copyOfStream(String filePath, String copyPath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(copyPath);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] bytes = new byte[1024 * 1024 * 200];
        int temp;
        long start = System.currentTimeMillis();
        while ((temp = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, temp);
        }
        String time = "stream所耗时间：" + (System.currentTimeMillis() - start);

        fis.close();
        fos.close();
        bis.close();
        bos.close();

        return time;
    }


    private static String copyOfReader(String filePath, String copyPath) throws IOException {
        FileReader fis = new FileReader(filePath);
        FileWriter fos = new FileWriter(copyPath);
        BufferedReader bis = new BufferedReader(fis);
        BufferedWriter bos = new BufferedWriter(fos);
        char[] bytes = new char[1024 * 1024 * 200];
        int temp;
        long start = System.currentTimeMillis();
        while ((temp = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, temp);
        }
        String time = "reader所耗时间：" + (System.currentTimeMillis() - start);

        fis.close();
        fos.close();
        bis.close();
        bos.close();

        return time;
    }
}
