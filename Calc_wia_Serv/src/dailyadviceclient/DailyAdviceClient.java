package dailyadviceclient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DailyAdviceClient {
    
    public void go() {
        try {            
            Socket clientSocket = new Socket("127.0.0.1", 1818); 
            
            Config con = new Config();
            con.setA(2.0);
            con.setB(1.1);
            con.setXn(0.08);
            con.setXk(1.08);
            con.setDx(0.2);
            
            System.out.println("Have it on client: \r\n" + "A = " + con.getA() + "\r\n" + "B = " + con.getB() + "\r\n" + "Xn = " + con.getXn() + "\r\n" + "Xk = " + con.getXk() + "\r\n" + "Dx = " + con.getDx() + "\r\n");
            
            ObjectOutputStream oOut = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream oIn = new ObjectInputStream(clientSocket.getInputStream());
            oOut.writeObject(con);
            
            Config conf = (Config) oIn.readObject();
            System.out.println("Got it from server: \r\n" + conf.getResult());
            
            oOut.close();
            oIn.close();
        } catch(Exception ex) {
            ex.printStackTrace(); 
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
    
}
