package hw20extra;

public interface Vertebrates extends Animals {

    default void needOxigeen(){
        System.out.println("I am a vertebrat animal");
    }

    default void nervouseSystem(){
        System.out.println("I have a spinal cord ");
    }
    void howIMove();
}
