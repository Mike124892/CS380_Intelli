/**
 * Wolf class that extends Animal
 */
public class Wolf extends Animal{
    Wolf (String name){
        super(name);
    }
    @Override
    public void sound(){
        System.out.println("GRRRRRRR!");
    }
    @Override
    public void play(){
        System.out.println("Blows piggy's houses down.");
    }
    @Override
    public void eat(){
        System.out.println("I eat piggies.");
    }
}
