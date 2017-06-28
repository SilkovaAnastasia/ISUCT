package duckbehavior;

public class MallardDuck extends DuckBehavior {

    public MallardDuck() {
        quackbehavior = new Quack();
        flybehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm the real Mallard Duck! \n");
    }
}
