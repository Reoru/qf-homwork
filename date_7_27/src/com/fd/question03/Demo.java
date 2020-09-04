package com.fd.question03;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/27 0027 下午 19:18
 */
public class Demo {
    public static void main(String[] args) {

        final String className = "fd";
        // 构建五个student对象
        Student student1 = new Student().new StudentBuilder().setName("a").setClassName(className).setScore(60).build();
        Student student7 = new Student().new StudentBuilder().setName("a").setClassName(className).setScore(60).build();
        Student student2 = new Student().new StudentBuilder().setName("b").setClassName(className).setScore(65).build();
        Student student3 = new Student().new StudentBuilder().setName("c").setClassName(className).setScore(70).build();
        Student student4 = new Student().new StudentBuilder().setName("d").setClassName(className).setScore(75).build();
        Student student5 = new Student().new StudentBuilder().setName("e").setClassName(className).setScore(80).build();

        List<Student> list = new LinkedList<>();
        list.add(isContains(student1, list));
        list.add(isContains(student2, list));
        list.add(isContains(student3, list));
        list.add(isContains(student4, list));
        list.add(isContains(student5, list));
        list.add(isContains(student7, list));

        for (Student student : list) {
            System.out.println(student);
        }
    }
    private static Student isContains(Student student, List<Student> students) {
        if (students.contains(student)) {
            students.remove(student);
        }
        return student;
    }
}
