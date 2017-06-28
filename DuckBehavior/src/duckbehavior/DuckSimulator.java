package duckbehavior;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckBehavior mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        mallard.display();

        DuckBehavior model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
        model.performQuack();
        model.display();
    }
}
