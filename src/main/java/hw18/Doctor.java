package hw18;

public class Doctor {
    private String name;
    private String lastName;
    private Position position;

    public Doctor(String name, String lastName, Position position) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String getLastName() {
        return lastName;
    }

    public void getDoctor(){
        System.out.println(name+" "+lastName+" "+position);
    }
}