package com.fd.question03;

import java.io.*;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/29 0029 下午 19:49
 */
public class Demo {
    private static final String DIY = "D:\\temp\\test\\DIYExcexption.java";
    private static final String FILE = "D:\\temp\\test\\FileDescTest01.java";
    private static final String TEST = "D:\\temp\\test\\Test.java";
    private static final String RESULT = "D:\\temp\\test\\Result.java";

    public static void main(String[] args) throws IOException {
        File diyFile = new File(DIY);
        File descFile = new File(FILE);
        File testFile = new File(TEST);
        File res = new File(RESULT);

        File[] files = {diyFile, descFile, testFile};
        final String javaEndWith = ".java";
        if (diyFile.getName().endsWith(javaEndWith) && descFile.getName().endsWith(javaEndWith) && testFile.getName().endsWith(javaEndWith)) {
            BufferedWriter bufferedWriter;
            BufferedReader bufferedReader = null;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(res)));
            for (File file : files) {
                FileInputStream fis = new FileInputStream(file);
                bufferedReader = new BufferedReader(new InputStreamReader(fis));
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    bufferedWriter.append(temp);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                fis.close();
            }

            bufferedWriter.close();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            System.out.println("成功!");
        } else {
            System.out.println("包含非java文件!");
        }
    }
}
