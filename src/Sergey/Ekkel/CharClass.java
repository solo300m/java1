package Sergey.Ekkel;

public class CharClass {
    public static void main(String[] args) {
        /*CharMy ch = new CharMy('А');
        String cI = ch.charInt(ch.simbol);
        char iC = ch.intChar(0);
        System.out.println(cI);
        System.out.println(iC);*/
        String a = "999";
        System.out.println(a);

    }
    static class CharMy{
        public char simbol;

        public CharMy(){};
        public CharMy(char a){
            this.simbol = a;
        }

        public String charInt(char a){
            return Character.toString(a);
        }
        public char intChar(int a){
            return Character.forDigit(a,10);
        }
    }
}
