package homeWork18;

public class Doctor {

    private String name;
    private String lastName;
    private Position position;

    public Doctor(String name, String lastName, Position position) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }
    public void printDocInfo(){
        System.out.println(name+ " "+ lastName+ " -"+position);
    }
}
