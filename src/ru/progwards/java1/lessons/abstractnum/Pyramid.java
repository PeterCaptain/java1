package ru.progwards.java1.lessons.abstractnum;

public class Pyramid extends Figure3D {
    public Pyramid(Number segment) {
        super(segment);
    }

    @Override
    public Number volume() {
        Number divider1 = new IntNumber(3);
        Number divider2 = new DoubleNumber(3);
        if (segment.getClass() == IntNumber.class) {
            return segment.mul(segment.mul(segment)).div(divider1);
        }
        return segment.mul(segment.mul(segment)).div(divider2);
    }

    @Override
    public String toString() {
        return "Фигура \"Пирамида\"\nоснованиe       - квадрат\nдлина стороны   - " + segment + "\nвысота пирамиды - " + segment;
    }
}
