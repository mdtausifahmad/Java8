package javageneral.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

    public static void main(String[] args) {

        Set<Student> set = new TreeSet<>();

        Student s  = new Student();
        set.add(s);

        System.out.println(set);
    }

}

class  Student implements Comparable<Student>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
