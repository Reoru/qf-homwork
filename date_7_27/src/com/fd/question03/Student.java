package com.fd.question03;

import java.util.Objects;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/27 0027 下午 19:13
 */
public class Student {
    private String name;
    private String className;
    private Integer score;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    class StudentBuilder {
        private Student student;

        {
            student = new Student();
        }

        public StudentBuilder setName(String name) {
            student.setName(name);
            return this;
        }

        public StudentBuilder setClassName(String className) {
            student.setClassName(className);
            return this;
        }

        public StudentBuilder setScore(Integer score) {
            student.setScore(score);
            return this;
        }

        public Student build() {
            return this.student;
        }
    }
}
