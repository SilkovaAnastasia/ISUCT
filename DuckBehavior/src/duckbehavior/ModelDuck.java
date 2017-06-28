package duckbehavior;

public class ModelDuck extends DuckBehavior {

    public ModelDuck() {
        flybehavior = new FlyNoWay();
        quackbehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm the model duck *sadface* \n");
    }
}
