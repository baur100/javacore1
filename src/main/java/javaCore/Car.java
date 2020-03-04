package javaCore;

public class Car {
    public String color;
    public Brand brand;
    public String model;

   public void beep(){
       System.out.println("beep");
   }
   public void lights(){
       System.out.println("lights on");
   }

   public void printCarInfo(){
       System.out.println(model + color);
   }
}
