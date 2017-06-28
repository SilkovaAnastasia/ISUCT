package duckbehavior;

public abstract class DuckBehavior {

    FlyBehavior flybehavior;
    QuackBehavior quackbehavior;

    public DuckBehavior() {
    }

    public abstract void display();

    public void performFly() {
        flybehavior.fly();
    }

    public void performQuack() {
        quackbehavior.quack();
    }

    public void swim() {
        System.out.println("We're swiming");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flybehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackbehavior = qb;
    }

}
