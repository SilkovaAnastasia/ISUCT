package dailyadviceclient;

import java.io.Serializable;
import java.util.ArrayList;

public class Config implements Serializable{
    
    private double a;
    private double b;
    private double xn;
    private double xk;
    private double dx;
    ArrayList<Double> result;
    
    public ArrayList<Double> getResult() {
        return result;
    }

    public void setResult(ArrayList<Double> result) {
            this.result = result;
    }
    
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getXn() {
        return xn;
    }

    public void setXn(double xn) {
        this.xn = xn;
    }

    public double getXk() {
        return xk;
    }

    public void setXk(double xk) {
        this.xk = xk;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }
}
