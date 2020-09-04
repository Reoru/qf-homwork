package com.fd.question02;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/29 0029 下午 17:28
 */
public class Demo {
    private static final HashMap<String, Integer> COMMANDS_MAP = new HashMap<>();
    private static final String SEPARATOR = File.separator;
    private static final String ROOT_PATH = "D:" + SEPARATOR + "temp" + SEPARATOR;
    private static final String COMMAND_ERROR = "-[语法错误] ";
    private static final String OPREATION = "-[操作结果] ";
    private static int count = 0;


    static {
        COMMANDS_MAP.put("mkdir", 2);
        COMMANDS_MAP.put("delete", 2);
        COMMANDS_MAP.put("ls", 2);
        COMMANDS_MAP.put("copyto", 3);
        COMMANDS_MAP.put("newFile", 2);
        COMMANDS_MAP.put("getFile", 3);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("``````````Shell\n-请输入命令：");
            String[] commands = resolve(input.nextLine());
            String s = toDo(commands);
            System.out.println(s);
        }
    }

    private static String toDo(String[] commands) {
        //拿出命令，后续需要该值进行内置命令的判断
        String command = commands[0];
        if (!(COMMANDS_MAP.containsKey(command) && COMMANDS_MAP.get(command) == commands.length)) {
            return COMMAND_ERROR + "无效操作!";
        }

        //如果输入的目录包含根目录，则视为语法错误
        if (commands[1].contains(ROOT_PATH)) {
            return COMMAND_ERROR + "输入的路径中包含了根目录！请输入相对路径!";
        }

        switch (command) {
            case "mkdir":
                return mkFile(commands[1]);
            case "delete":
                return rmFile(commands[1]);
            case "ls":
                return lsFile(commands[1]);
            case "newFile":
                return createFile(commands[1]);
            case "copyto":
                return copyFile(commands[1], commands[2]);
            default:
                return COMMAND_ERROR + "无效操作!";
        }
    }

    private static String createFile(String fileName) {
        if (fileName.startsWith("\\")) {
            return OPREATION + "请检查语法!";
        }
        try {
            new File(ROOT_PATH + fileName).createNewFile();
            return OPREATION + "创建成功!";
        } catch (IOException e) {
            return OPREATION + "创建失败!请检查路径是否存在!";
        }
    }

    private static String copyFile(String fileName, String copyName) {
        if (copyName.contains("/")) {
            return OPREATION + "复制失败!请检查路径或语法!";
        }
        String copyName2 = ROOT_PATH + copyName;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fileName);
            fos = new FileOutputStream(copyName2);
            byte[] bytes = new byte[1024 * 1024];
            int temp;
            while ((temp = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, temp);
            }

            return OPREATION + "复制成功!";
        } catch (IOException e) {
            e.getStackTrace();
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
        return OPREATION + "复制失败!请检查路径或语法!";
    }

    private static String[] resolve(String command) {
        return command.split(" ");
    }

    private static String mkFile(String dirName) {
        return OPREATION + (new File(ROOT_PATH + dirName).mkdir() ? "创建目录成功!" : "创建失败!");
    }

    private static String rmFile(String dirName) {
        return OPREATION + (new File(ROOT_PATH + dirName).delete() ? "删除成功!" : "删除失败!");
    }

    private static String lsFile(String command) {
        if ("/".equals(command)) {
            listFile(new File(ROOT_PATH));
            return "";
        }
        return COMMAND_ERROR + "请检查命令语法!";
    }

    private static void listFile(File f) {
        File[] fileArr = f.listFiles();
        if (fileArr == null) {
            //如果该处文件不可访问,会出现空指针异常,在读取盘符根目录时,一般会出现空指针,要预防
            return;
        }
        if (fileArr.length == 0) {
            //判断如果目录为空时,count计数自减,减小缩进
            count--;
            return;
        }
        for (int i = 0; i < fileArr.length; i++) {
            //打印缩进
            for (int j = 0; j < count; j++) {
                System.out.print("\t");
            }
            //打印文件名字
            if (fileArr[i].isFile()) {
                File file = fileArr[i];
                System.out.println("[文件]" + file.getName() + "   [size]" + file.length() + "   [可读]" + file.canRead());
            }
            //判断,当达到文件的结尾并且最后一个不是文件夹的时候,count自减
            if (i == fileArr.length - 1 && !fileArr[i].isDirectory()) {
                count--;
            }
            if (fileArr[i].isDirectory()) {
                //如果是文件夹,count自加,扩大缩进
                System.out.println("[目录]" + fileArr[i].getName());
                count++;
                listFile(fileArr[i]);
            }
        }
    }
}
