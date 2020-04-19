package Sergey.Ekkel;

class Programm {
    public static void main(String[] args) {
        Point2D p2 = new Point2D(2, 3);
        Point3D p3 = new Point3D(5,6,7);
        System.out.println(p2);
        System.out.println(p3);
    }
}
    public class Point2D {
        private int x;
        private int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public String toString() {
            String a = x + ", " + y;
            return a;
        }
    }

    class Point3D extends Point2D {
        private int z;
        public Point3D(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        public String toString() {
            String a = super.getX()+", "+super.getY()+", " + z;
            return a;
        }
    }
