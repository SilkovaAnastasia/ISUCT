package dailyadviceclient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    
    public void go() {
        
        try {
            ServerSocket serverSocket = new ServerSocket(1818);
            
            while(true) {
                Socket socket = serverSocket.accept();
                
                ObjectOutputStream oOut = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream oIn = new ObjectInputStream(socket.getInputStream());
                Config con = (Config) oIn.readObject();
                System.out.println("Got it from client: \r\n" + "A = " + con.getA() + "\r\n" + "B = " + con.getB() + "\r\n" + "Xn = " + con.getXn() + "\r\n" + "Xk = " + con.getXk() + "\r\n" + "Dx = " + con.getDx() + "\r\n");
                
                CalcF calc = new CalcF();
                con.setResult(calc.f(con.getXn(), con.getXk(), con.getDx(), con.getA(), con.getB()));
                oOut.writeObject(con);
                oOut.close();
                oIn.close();
            }
        } catch(Exception ex) {
            ex.printStackTrace(); 
        }
    }
    
    public static void main(String[] args) {
        DailyAdviceServer serv = new DailyAdviceServer();
        serv.go();
    }
}
