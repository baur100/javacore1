package hw18;


import java.util.ArrayList;

public class Doctor {
    private String name;
    private String lastName;
    private Position position;

    public Doctor(String name, String lastName, Position position) {
        this.name = name;
        this.lastName = lastName;
        this.position=position;
    }

public void printDoctorInfo(){
    System.out.println(name+ ", "+lastName+ ", " +position);

    }
}


