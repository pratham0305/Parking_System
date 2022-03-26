/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GenerateBill.java
 *
 * 
 */
package ParkingSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PJ
 */
public class GenerateBill extends javax.swing.JFrame {

    String username,vehicleNumber,currentTime,currentDate,vehicleType,floorNumber,slotNumber,depDate,depTime, tokenNumber, currenttimemilis1,currenttimemilis2;

    public GenerateBill(String username, String vehicleNumber, String currentTime, String currentDate, String vehicleType, String floorNumber, String slotNumber, String depDate, String depTime, String tokenNumber) {
        this.username = username;
        this.vehicleNumber = vehicleNumber;
        this.currentTime = currentTime;
        this.currentDate = currentDate;
        this.vehicleType = vehicleType;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.depDate = depDate;
        this.depTime = depTime;
        this.tokenNumber=tokenNumber;
        initComponents();
        message.setVisible(false);
        String status="";
        String query="select currenttimemilis,status from tokengenerator where tokenid='"+tokenNumber+"'";
        ResultSet rs;
        try 
        {
            rs = DBConnector.getStatement().executeQuery(query);
            while(rs.next())
            {
                currenttimemilis1=rs.getString(1);
                status = rs.getString(2);
                currenttimemilis2=String.valueOf(System.currentTimeMillis());
            }    
            if(status.equalsIgnoreCase("active"))
            {
                String query2="update parking.status set status='free' where slotNumber='"+slotNumber+"'";
                String query3="update parking.tokengenerator set status='inactive' where tokenid='"+tokenNumber+"'";
                
                int i=DBConnector.getStatement().executeUpdate(query2);
                int j=DBConnector.getStatement().executeUpdate(query3);
                
                if(i>0 && j>0)
                {
                    System.out.println("Record updated");
                }
                else
                {
                    System.out.println("not Updated");
                }
                long time1=Long.parseLong(currenttimemilis1);
                long time2=Long.parseLong(currenttimemilis2);

                long time3=time2-time1;
                time3=time3/3600000+1;
                long cost=time3*25;

                cName.setText(username);
                vn.setText(vehicleNumber);
                amount.setText(String.valueOf(cost));
            }
            else
            {
                message.setVisible(true);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
    /** Creates new form GenerateBill */
    
    public GenerateBill() {
        initComponents();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Customer Name:");

        cName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cName.setForeground(new java.awt.Color(0, 0, 204));
        cName.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("vehicle Number:");

        vn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vn.setForeground(new java.awt.Color(0, 0, 204));
        vn.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Total Amount:");

        amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amount.setForeground(new java.awt.Color(0, 0, 204));
        amount.setText("jLabel4");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setText("Go back to Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        message.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        message.setText("This Record is Inactive now");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(58, 58, 58))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(amount)
                                .addComponent(vn)
                                .addComponent(cName)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(message)
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Exitform().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GenerateBill().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JLabel cName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel message;
    private javax.swing.JLabel vn;
    // End of variables declaration//GEN-END:variables
}
