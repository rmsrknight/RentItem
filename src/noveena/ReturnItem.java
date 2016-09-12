/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noveena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sachindra
 */
public class ReturnItem extends javax.swing.JFrame {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
    
    
    
    public ReturnItem() {
        initComponents();
        this.setAlwaysOnTop(false);
        this.setLocationRelativeTo(null);
        
        btnGenarateInvoice.setEnabled(false);
        btnadd.setEnabled(false);
        con = DBconnect.connect();
    }

    
    public void generateDetails(String RentID){
        try {
            String sql = "SELECT * From Rent WHERE RentID ='"+RentID+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            while(rs.next()){
                txtArea.setText("\tCustomer Agreement Details"+"\n\t----------------------------------------"
                +"\n\nRent ID \t: "+rs.getString("RentID")+"\nName  \t: "+rs.getString("Name")+"\nNIC  \t: "+rs.getString("NIC")+"\nContact No\t: "+rs.getString("ContactNo")
                +"\nAddress   \t: "+rs.getString("Address")+"\nItem ID  \t: "+rs.getString("ItemID")
                +"\nRent Date  \t: "+rs.getString("RentDate")+"\nReturn Date  \t: "+rs.getString("ReturnDate")+"\nPayment  \t: "+rs.getString("Payment"));
                
                
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void Clear(){
        
        txtArea.setText(null);
        txtExtraCharge.setText(null);
        txtRentID.setText(null);
    }
    
    public boolean ValidRentID(String RentID){
        
        try {
                String sql = "SELECT RentID From Rent WHERE RentID ='"+RentID+"'"; 
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                    while (rs.next()) {  
                                if(RentID.equals(rs.getString("RentID"))){
                                    return true;
                                    
                                }
                    }
        } catch (Exception e) {
        }
        return false;            
    }
    
    public boolean Returned(String RentID){
        int returned;
        try {
                String sql = "SELECT Returned From Rent WHERE RentID ='"+RentID+"'"; 
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                    while (rs.next()) {  
                                returned=Integer.parseInt(rs.getString("Returned"));
                                if(returned==1){
                                    return true;
                                    
                                }
                    }
        } catch (Exception e) {
        }
        return false;            
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        txtRentID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGenarateInvoice = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        title3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        minimizeButton3 = new javax.swing.JButton();
        exitButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnadd = new javax.swing.JButton();
        txtExtraCharge = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnSearch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtRentID.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Rent ID");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Extra Charges");

        btnGenarateInvoice.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnGenarateInvoice.setText("Generate Invoice");
        btnGenarateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenarateInvoiceActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel3.setText("Return Item");

        title3.setBackground(new java.awt.Color(102, 102, 102));
        title3.setAlignmentX(0.0F);
        title3.setAlignmentY(0.0F);

        jLabel7.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rent Items Management System");

        minimizeButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/126001-matte-white-square-icon-symbols-shapes-minimize (Custom).png"))); // NOI18N
        minimizeButton3.setToolTipText("minimize");
        minimizeButton3.setBorder(null);
        minimizeButton3.setBorderPainted(false);
        minimizeButton3.setFocusPainted(false);
        minimizeButton3.setPreferredSize(new java.awt.Dimension(30, 30));
        minimizeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButton3ActionPerformed(evt);
            }
        });

        exitButton3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        exitButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/close-icon-16 (Custom).png"))); // NOI18N
        exitButton3.setToolTipText("exit");
        exitButton3.setPreferredSize(new java.awt.Dimension(30, 30));
        exitButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton3ActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/noveena_logo (Mobile) (Custom) (Custom).png"))); // NOI18N

        javax.swing.GroupLayout title3Layout = new javax.swing.GroupLayout(title3);
        title3.setLayout(title3Layout);
        title3Layout.setHorizontalGroup(
            title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(278, 278, 278)
                .addComponent(minimizeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        title3Layout.setVerticalGroup(
            title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(14, 14, 14))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(title3Layout.createSequentialGroup()
                .addGroup(title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(title3Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnadd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(jLabel2)
                    .addGap(37, 37, 37)
                    .addComponent(txtExtraCharge)
                    .addGap(18, 18, 18)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(132, 132, 132)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(54, 54, 54)
                            .addComponent(txtRentID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(btnClear))
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(btnGenarateInvoice))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRentID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExtraCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnGenarateInvoice)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButton3ActionPerformed
        this.setState(RentItemInteface.ICONIFIED);
    }//GEN-LAST:event_minimizeButton3ActionPerformed

    private void exitButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButton3ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String RentID= txtRentID.getText();
        String ItemID="";
        int RentTimePeriod=0;                //Rented time period that the customer has given
        int RentedDuration=0;                  //Rented time period until the day customer returns the item
        float newPayment=0;
        
        if (!ValidRentID(RentID)) {
            txtArea.setText("Invalid RentID");
        }
        else{
                if (Returned(RentID)) {
                    txtArea.setText("Item Already Returned");
                }
                else{
                    try {   
                                    String sql = "SELECT * From Rent WHERE RentID ='"+RentID+"'";
                                    ps = con.prepareStatement(sql);
                                    rs = ps.executeQuery();


                                    while (rs.next()) {
                                        ItemID=rs.getString("ItemID");
                                        String sql1 = "SELECT (DATEDIFF('"+rs.getString("ReturnDate")+"','"+rs.getString("RentDate")+"')) From Rent WHERE RentID ='"+RentID+"'";
                                        String sql2 = "SELECT (DATEDIFF(CURDATE(),'"+rs.getString("RentDate")+"')) From Rent WHERE RentID ='"+RentID+"'";
                                        ps = con.prepareStatement(sql1);
                                        rs = ps.executeQuery();
                                        ps = con.prepareStatement(sql2);
                                        rs1 = ps.executeQuery();
                                                    while (rs.next()) {                        
                                                        RentTimePeriod= Integer.parseInt(rs.getString(1));                                    
                                                    }
                                                    while (rs1.next()) {                        
                                                        RentedDuration = Integer.parseInt(rs1.getString(1));      
                                                    }
                                    }
                            } catch (Exception e) {
                            }

                                if (RentedDuration==RentTimePeriod) {

                                }
                                else if (RentedDuration==0) {                                                       //If the item is returned on the same day its rented
                                     try {   
                                                    String sql3 = "SELECT * From rentitem WHERE ItemID ='"+ItemID+"'";
                                                    ps = con.prepareStatement(sql3);
                                                    rs = ps.executeQuery();

                                                        while (rs.next()) {                         
                                                                    newPayment=(Float.parseFloat(rs.getString("RentCharge")))*1;
                                                        }

                                                    String sql4 = "UPDATE Rent SET Payment ='"+newPayment+"' WHERE RentID ='"+RentID+"'";
                                                    ps = con.prepareStatement(sql4);
                                                    ps.execute();   


                                    } catch (Exception e) {
                                         System.out.println(e);
                                    }
                                }
                                else {
                                     try {   
                                                    String sql3 = "SELECT * From rentitem WHERE ItemID ='"+ItemID+"'";
                                                    ps = con.prepareStatement(sql3);
                                                    rs = ps.executeQuery();

                                                        while (rs.next()) {                         
                                                                    newPayment=(Float.parseFloat(rs.getString("RentCharge")))*RentedDuration;
                                                        }

                                                    String sql4 = "UPDATE Rent SET Payment ='"+newPayment+"', ReturnDate = CURDATE()  WHERE RentID ='"+RentID+"'";
                                                    ps = con.prepareStatement(sql4);
                                                    ps.execute(); 
                                    } catch (Exception e) {
                                         System.out.println(e);
                                    }
                                }
                            generateDetails(RentID);
                            btnGenarateInvoice.setEnabled(true);
                            btnadd.setEnabled(true);
                }
                                
        }
        
        
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnGenarateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenarateInvoiceActionPerformed
        Integer RentID = Integer.parseInt(txtRentID.getText());
        ViewIReport.Invoice(RentID);
        String ItemID="";
        try {
            String sql1 = "SELECT ItemID FROM Rent WHERE RentID ="+RentID+"";
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                ItemID=rs.getString("ItemID");
            }
            

        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        try {
            String sql2 = "UPDATE rentitem SET Availability = 'Available'  WHERE ItemID ="+ItemID+"";
            ps = con.prepareStatement(sql2);
            ps.execute();
            

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String sql2 = "UPDATE Rent SET Returned = 1  WHERE RentID ="+RentID+"";
            ps = con.prepareStatement(sql2);
            ps.execute();
            

        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }//GEN-LAST:event_btnGenarateInvoiceActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed

        btnSearch.setEnabled(false);
        txtRentID.setEditable(false);

        String RentID = txtRentID.getText();
        float ExtraCharge = Float.parseFloat(txtExtraCharge.getText()) ;

        try {
            String sql = "UPDATE Rent SET Payment = Payment + "+ExtraCharge+" WHERE RentID ="+RentID+"";
            ps = con.prepareStatement(sql);
            ps.execute();
            

        } catch (Exception e) {
            System.out.println(e);
        }

        generateDetails(RentID);
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        Clear();
        btnGenarateInvoice.setEnabled(false);
        txtRentID.setEditable(true);
        btnSearch.setEnabled(true);
        btnadd.setEnabled(false);
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenarateInvoice;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton exitButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton minimizeButton3;
    private javax.swing.JPanel title3;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtExtraCharge;
    private javax.swing.JTextField txtRentID;
    // End of variables declaration//GEN-END:variables
}
