package Sergey.Ekkel;
class Program{
    public static void main(String[] args) {
        System.out.println(Person.Child1.hello());
        Person p1 = new Person();
        Person.Child2 p_ch = p1.new Child2();
        System.out.println(p_ch.hello());
    }
}


public class Person {
        private String name;
        private int age;
        private String country;
        public Person(){
            country = "RU";
        }
        public Person(String name, int age){
            this();
            this.name = name;
            this.age = age;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getCountry(){
            return country;
        }

        public static class Child1{
            public static String hello(){
                return "привет";
            }
        }
        public class Child2{
            public String hello(){
                return "servus";
            }
        }
    }

