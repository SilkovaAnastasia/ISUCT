package dailyadviceclient;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Calc_wia_Serv extends javax.swing.JFrame {
    
//im = ImageIO.read(new File("C:\\Users\\Анастасия\\Downloads\\Новая папка\\cliparting\\BG\\kEl58c5iLc4.jpg"));

    public Calc_wia_Serv() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ok = new javax.swing.JButton();
        xn = new javax.swing.JTextField();
        xk = new javax.swing.JTextField();
        dx = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        textField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ok.setBackground(new java.awt.Color(204, 255, 204));
        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        xn.setText("0.08");
        xn.setToolTipText("xn");
        xn.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        xk.setText("1.08");
        xk.setToolTipText("xk");

        dx.setText("0.2");
        dx.setToolTipText("dx");

        a.setText("2.0");
        a.setToolTipText("a");

        b.setText("1.1");
        b.setToolTipText("b");

        textField.setColumns(20);
        textField.setRows(5);
        jScrollPane3.setViewportView(textField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(xk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dx, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(151, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(156, 156, 156))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        CalcF calc = new CalcF();
        Config con = new Config();
        con.setA(Double.parseDouble(a.getText()));
        con.setB(Double.parseDouble(b.getText()));
        con.setXn(Double.parseDouble(xn.getText()));
        con.setXk( Double.parseDouble(xk.getText()));
        con.setDx(Double.parseDouble(dx.getText()));

        go();
    }
    
    public void go() {
        try {            
            Socket clientSocket = new Socket("127.0.0.1", 1818); 
            
            Config con = new Config();
            con.setA(2.0);
            con.setB(1.1);
            con.setXn(0.08);
            con.setXk(1.08);
            con.setDx(0.2);
            
            ObjectOutputStream oOut = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream oIn = new ObjectInputStream(clientSocket.getInputStream());
            oOut.writeObject(con);
            
            Config conf = (Config) oIn.readObject();
            textField.append(conf.getResult().toString());
            
            oOut.close();
            oIn.close();
        } catch(Exception ex) {
            ex.printStackTrace(); 
        }
    }//GEN-LAST:event_okActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calc_wia_Serv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JTextField dx;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton ok;
    private javax.swing.JTextArea textField;
    private javax.swing.JTextField xk;
    private javax.swing.JTextField xn;
    // End of variables declaration//GEN-END:variables
}
