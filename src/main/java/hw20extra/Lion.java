package hw20extra;

public class Lion extends Carnivores {
    private Area areaoflLife;
    public boolean havelegs;

    public Lion(Area areaoflLife, boolean havelegs) {
        this.areaoflLife = areaoflLife;
        this.havelegs = havelegs;
    }

    public Area getAreaoflLife() {
        return areaoflLife;
    }

    @Override
    public void needOxigen() {
        System.out.println("I need Oxigen and i can breath!!!");
    }

    @Override
    public void myMeals() {
        System.out.println("i love frech meals");
    }

    @Override
    public void iCanMove() {
        System.out.println(" i can run realy fast");

    }
    public void king(){
        System.out.println("I am a king of the animals");
    }
    public void printInfo(){
        System.out.println("i live in "+ areaoflLife+" and i have legs - "+havelegs);
    }
}
