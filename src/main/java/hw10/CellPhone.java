package hw10;

public class CellPhone {
    private String brand;
    private String model;
    private double screenSize;
    private String ship;


    public CellPhone(){

    }

    public CellPhone(String brand, String model, double screenSize){
        this.brand=brand;
        this.model=model;
        this.screenSize=screenSize;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setModel(String model){
        this.model=model;
    }
    public void setScreenSize(double screenSize){
        if(this.screenSize<=2){
            screenSize=4;
            System.out.println("wrong screen size");
        }
        this.screenSize=screenSize;
    }
    public double getScreenSize(int i){ return screenSize;}

    public String getBrand(){return brand;}

    public String getModel(){return model;}


}