package javaCore;

public class Work {

    public static void main(String[]args){


    Car ivansCar = new Car();

    int[]c = new int[10];
    ivansCar.beep();
    ivansCar.lights();

Car bmw = new Car();

bmw.color = "Pink";
bmw.model = "X5";

bmw.lights();
bmw.printCarInfo();

    }
}
