package duckbehavior;

public class RubberDuck extends DuckBehavior {

    public RubberDuck() {
        quackbehavior = new QuackNoWay();
        flybehavior = new FlyNoWay();

    }

    public void display() {
        System.out.println("I'm rubber duck, I can't fly");

    }
}
