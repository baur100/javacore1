import org.ietf.jgss.GSSCredential;

public class CellPhone {
    private String brand;
    private String model;
    private double screenSize;

    private String chip;

    public CellPhone(){

    }

    public CellPhone(String brand, String model, double screenSize){
        this.brand=brand;
        this.model=model;
        this.screenSize=screenSize;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenSize(double screenSize) {
        if(screenSize<=2){
            this.screenSize=4;
            System.out.println("wrong screen size");
        }
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
