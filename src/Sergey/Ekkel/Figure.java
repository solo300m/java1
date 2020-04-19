package Sergey.Ekkel;

class Pro{
    public static void main(String[] args) {
        Figure fig = new Square(12);
        Figure fig1 = new Round(5);
        Figure fig2 = null;
        System.out.println(fig.figDetect(fig));
        System.out.println(fig1.figDetect(fig1));
        System.out.println(fig1.figDetect(fig2));
    }

}

// модуль 13 задание 2
class Figure {
    String figDetect(Figure fig){
        if(fig!=null) {
            String figure = fig.getClass().getSimpleName();
            switch (figure) {
                case ("Square"): {
                    Square f = (Square) fig;
                    return "Сторона квадрата " + f.getSide();
                }
                case ("Round"): {
                    Round r = (Round) fig;
                    return "Диаметр круга " + r.getDiameter();
                }
                default:
                    return "Неизвестная фигура";
            }
        }else
            return "Неизвестная фигура";

    }
}

class Square extends Figure {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }
}

class Round extends Figure {
    private double diameter;
    public Round(double diameter) {
        this.diameter = diameter;
    }
    public double getDiameter() {
        return diameter;
    }
}