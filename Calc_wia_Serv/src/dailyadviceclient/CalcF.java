package dailyadviceclient;

import java.util.ArrayList;

public class CalcF {
    
    

    public static void main(String[] args) {
        //y(0.2, 1.1, 2.0);
    }
    
    public double y(double x, double b, double a) {
            double y =(Math.log(a)*Math.abs(b*b - x*x))/(Math.pow(Math.abs(x*x - a*a),(1/5)));
            return y;
    }
    
    public ArrayList<Double> f(double xn, double xk, double dx, double a, double b) {
        ArrayList<Double> y = new ArrayList<Double>();
        for (double x=xn; x<xk; x+=dx) {
            y.add(y(x, a, b));
        }
        return y;
    }
        
    public ArrayList<Double> z(ArrayList<Double> x, double a, double b) {
        ArrayList<Double> y = new ArrayList<Double>();
        for(double i: x) {
        y.add(y(i, a, b));
        }
        return y;
    }
}