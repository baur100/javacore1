package Homew10;

public class Work {
    public static void main(String[] args){

        Monitor samsung = new Monitor ("samsung", new int[]{-3,-2,-1,1,2,3,4,5}, 2.19);

        Monitor lg = new Monitor();
        lg.setName("carbon");
        lg.setBrightness();(new int[]{-2,-3,-2,-1,0,2,5,3,1});
        lg.setDiagonal(32.5);

        lg.printClass();
       samsung.printClass();

       Box gift = new Box("Rosa","Cardboard", 10, new int[]{1,2,8,5,9,3});

        Box lilia = new Box();
        lilia.setModel("White");
        lilia.setMaterial("Cartboard");
        lilia.setVolume(3);
        lilia.setVolume(new int[]{2,4,6,1});

        gift.printClass();
        lilia.printClass();

        Shoes sandals= new Shoes("Sandals", new int[]{8,6}, "Red");

        Shoes sneakers = new Shoes();
        sneakers.setName("Nike");
        sneakers.setSize();(new int[]{8,6});
        sneakers.setMaterial("Leather");

        sneakers.printClass();
        sandals.printClass();





    }

}

