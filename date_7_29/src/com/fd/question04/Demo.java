package com.fd.question04;

import java.io.*;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/29 0029 下午 20:06
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        int count = 1;
        int curr = 0;
        String root = "D:\\temp\\t1.txt";
        File file = new File(root);
        long length = file.length();
        // 分割临界点
        long temp = length / 5;
        System.out.println(temp);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            File tempFile = new File(root.substring(0, root.lastIndexOf(".")) + count + root.substring(root.lastIndexOf(".")));
            int temps;
            fos = new FileOutputStream(tempFile);
            while ((temps = fis.read()) != -1) {
                fos.write(temps);
                if (curr % temp == 0) {
                    fos = new FileOutputStream(new File(root.substring(0, root.lastIndexOf(".")) + count + root.substring(root.lastIndexOf("."))));
                    count++;
                    fos.close();
                }
                curr++;
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("成功");
    }
}
