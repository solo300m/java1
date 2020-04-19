package Sergey.Ekkel;

import java.util.Comparator;
import java.util.TreeSet;
class Pr{
    public static void main(String[] args) {
        TreeSet<User> main = User.createSet();
        System.out.println(main);
    }
}
//13 модуль задача 3
public class User {
    public Integer id;
    public String name;

    User (Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'';
    }

    public static TreeSet<User> createSet(){
        Comparator<User> comp = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.id,o1.id);
            }
        };
        TreeSet<User> userSet = new TreeSet<User>(comp);

        return userSet;
    }
}
