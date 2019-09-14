public class CellPhone {

    private String brand;
    private String model;
    private double screenSize;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getScreenSize() {
        if (screenSize<=2){
            this.screenSize=4;
            System.out.println("wrong screen size");
        return screenSize;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

}
}