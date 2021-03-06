package extralesson1;

public class Fish {
    private int size;
    private String name;
    public boolean isFreshWater;

    public Fish(int size, String name, boolean waterType){
        this.size=size;
        this.name=name;
        isFreshWater=waterType;
    }

    public double calculateSizeInInches(){
        return size/2.54;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

}
