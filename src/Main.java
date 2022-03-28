
class TriangleBase {
    private final int sideA;
    private final int sideB;
    private final int sideC;

    TriangleBase(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public static boolean isValid(int sideA, int sideB, int sideC) {
        return sideA + sideB > sideC &&
                sideA + sideC > sideB &&
                sideB + sideC > sideA;
    }
}

class Main {

    public static void main(String[] args) {

        boolean isValid = TriangleBase.isValid(2, 2, 2);
        if (isValid) {
            TriangleBase triangle = new TriangleBase(1, 2, 3);
            System.out.println("Triangle has been created.");
        }

        Option option = new Option("Some description", true);
        option = new Option(option, false);

        Circle circle = new Circle(7);
        System.out.println("Perimeter of circle is: " + circle.getPerimeter());
        System.out.println("Area of circle is: " + circle.getArea());

        Rectangle rectangle = new Rectangle(5, 6);
        System.out.println("Perimeter of rectangle is: " + rectangle.getPerimeter());
        System.out.println("Area of rectangle is: " + rectangle.getArea());

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Perimeter of triangle is: " + triangle.getPerimeter());
        System.out.println("Area of triangle is: " + triangle.getArea());

        System.out.println();

        Figure[] figures = new Figure[3];
        figures[0] = new Circle(7);
        figures[1] = new Rectangle(5, 6);
        figures[2] = new Triangle(3, 4, 5);

        for (Figure figure: figures) {
            System.out.println(figure.toString());
        }

        System.out.println("\nFactory here:");

        Figure[] figure1 = new Figure[3];
        FigureFactory figureFactory = new FigureFactory();
        figure1[0] = figureFactory.create(7);
        figure1[1] = figureFactory.create(5, 6);
        figure1[2] = figureFactory.create(3, 4, 5);

        for (Figure figure: figure1) {
            System.out.println(figure.toString());
        }

        print("\nFactory 2 here:");

        FigureFactory figureFactory2 = new FigureFactory();
        print(
                figureFactory2.create(7),
                figureFactory2.create(5, 6),
                figureFactory2.create(3, 4, 5)
        );
    }

    private static void print(Figure... figures) {
        for (Figure figure: figures) {
            print(figure.toString());
        }
    }

    private static void print(String text) {
        System.out.println(text);
    }
}



class Option {

    private final String description;
    private final boolean isChosen;

    public Option(String description, boolean isChosen) {
        this.description = description;
        this.isChosen = isChosen;
    }

    public Option(Option old, boolean isChosen) {
        this.description = old.description;
        this.isChosen = isChosen;
    }
}