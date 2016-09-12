/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noveena;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sachindra
 */
public class EditRentingDetails extends javax.swing.JFrame {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
    
    public EditRentingDetails() {
        
        this.setAlwaysOnTop(false);
        initComponents();
        this.setLocationRelativeTo(null);
        ButtonGroup bg1 = new ButtonGroup( );
        bg1.add(radioNIC);
        bg1.add(radioItemID);
        bg1.add(radioRentId);
        
        con =DBconnect.connect();
        txtRentId.setEditable(false);
        tableRefresh();
    }

    
    public void tableLoad(String text, String selection){
        
        try {
            String sql = "SELECT Name,NIC,ContactNo,Address,ItemID,RentDate,ReturnDate,RentID,Payment From Rent WHERE "+selection+" ='"+text+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        }
        
    }  
    public void tableRefresh(){
        
        try {
            String sql = "SELECT Name,NIC,ContactNo,Address,ItemID,RentDate,ReturnDate,RentID,Payment From Rent ORDER BY RentID";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        }
        
    }
    
    public void clear(){
        
        txtAddress.setText(null);
        txtContactNo.setText(null);
        txtItemId.setText(null);
        txtNIC.setText(null);
        txtName.setText(null);
        txtRentId.setText(null);
        txtSearch.setText(null);
        ButtonGroup bg1 = new ButtonGroup( );
        bg1.add(radioNIC);
        bg1.add(radioItemID);
        bg1.add(radioRentId);
        bg1.clearSelection();
        ReturnDate.setDate(null);
        RentDate.setDate(null);
        
        
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel(); 
        model.setRowCount(0);
        
    }
    
    public void clearLabels(){
        
        lblErr2.setText(null);
        lblErr3.setText(null);
        lblErr4.setText(null);
        lblErr5.setText(null);
        lblErr6.setText(null);
        lblErr7.setText(null);
        lblErr8.setText(null);
        lblErr9.setText(null);
        
    }
    
    public boolean ValidItemID( String ItemID){
        
        try {
                String sql = "SELECT ItemID From rentitem WHERE ItemID ='"+ItemID+"'"; 
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                    while (rs.next()) {  
                                if(ItemID.equals(rs.getString("ItemID"))){
                                    return true;
                                    
                                }
                    }
        } catch (Exception e) {
        }
        return false;            
    }
    
    public boolean ItemAvailability(String ItemID){
        
        try {
                String sql = "SELECT Availability From rentitem WHERE ItemID ='"+ItemID+"'"; 
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                    while (rs.next()) {  
                                if(rs.getString("Availability").equals("Available")){
                                    return true;
                                    
                                }
                    }
        } catch (Exception e) {
        }
        return false;            
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioNIC = new javax.swing.JRadioButton();
        radioItemID = new javax.swing.JRadioButton();
        radioRentId = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtItemId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        txtNIC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        title3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        minimizeButton3 = new javax.swing.JButton();
        exitButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRentId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        lblErr2 = new javax.swing.JLabel();
        lblErr3 = new javax.swing.JLabel();
        lblErr4 = new javax.swing.JLabel();
        lblErr5 = new javax.swing.JLabel();
        lblErr6 = new javax.swing.JLabel();
        lblErr7 = new javax.swing.JLabel();
        lblErr8 = new javax.swing.JLabel();
        lblErr9 = new javax.swing.JLabel();
        btnAgeementGen = new javax.swing.JButton();
        ReturnDate = new com.toedter.calendar.JDateChooser();
        RentDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setUndecorated(true);

        radioNIC.setText("NIC No.");
        radioNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNICActionPerformed(evt);
            }
        });

        radioItemID.setText("Item ID");
        radioItemID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioItemIDActionPerformed(evt);
            }
        });

        radioRentId.setText("Rent ID");

        txtSearch.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NIC", "ContactNo", "Address", "ItemID", "RentDate", "ReturnDate", "RentID", "Payment"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Item ID :");

        txtItemId.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtItemId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtItemIdFocusLost(evt);
            }
        });
        txtItemId.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtItemIdPropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Address :");

        txtAddress.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Contact No :");

        txtContactNo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtContactNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactNoFocusLost(evt);
            }
        });

        txtNIC.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNIC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNICFocusLost(evt);
            }
        });
        txtNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNICActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("NIC No :");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Customer Name :");

        txtName.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel8.setText("Edit Renting Details");

        title3.setBackground(new java.awt.Color(102, 102, 102));
        title3.setAlignmentX(0.0F);
        title3.setAlignmentY(0.0F);

        jLabel9.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rent Items Management System");

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
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(404, 404, 404)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        title3Layout.setVerticalGroup(
            title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title3Layout.createSequentialGroup()
                .addGroup(title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(title3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, title3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(14, 14, 14))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("Return Date :");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setText("Rent ID :");

        txtRentId.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtRentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRentIdActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setText("Rent Date :");

        btnUpdate.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAgeementGen.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAgeementGen.setText("Generate Renting Agreement");
        btnAgeementGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgeementGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(877, 877, 877)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRentId, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(radioNIC)
                        .addGap(40, 40, 40)
                        .addComponent(radioItemID)
                        .addGap(46, 46, 46)
                        .addComponent(radioRentId)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblErr9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(btnSearch)
                        .addGap(252, 252, 252)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblErr2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErr3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErr4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErr5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(btnAgeementGen)
                        .addGap(361, 361, 361)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblErr6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1037, 1037, 1037)
                        .addComponent(lblErr7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(877, 877, 877)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(RentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1040, 1040, 1040)
                        .addComponent(lblErr8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(914, 914, 914)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtRentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(radioNIC))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(radioItemID))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(radioRentId))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lblErr9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearch)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblErr2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblErr3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblErr4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblErr5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnAgeementGen, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblErr6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(lblErr7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(RentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(lblErr8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNICActionPerformed

    private void radioItemIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioItemIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioItemIDActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNICActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
        tableRefresh();
        clearLabels();
    }//GEN-LAST:event_btnClearActionPerformed

    private void minimizeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButton3ActionPerformed
        this.setState(RentItemInteface.ICONIFIED);
    }//GEN-LAST:event_minimizeButton3ActionPerformed

    private void exitButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        
        int row= jTable1.getSelectedRow();
        
        String RentID = jTable1.getValueAt(row, 7).toString();
        String CusName = jTable1.getValueAt(row, 0).toString();
        String NIC = jTable1.getValueAt(row, 1).toString();
        String ContactNo = jTable1.getValueAt(row, 2).toString();
        String Address = jTable1.getValueAt(row, 3).toString();
        String ItemId = jTable1.getValueAt(row, 4).toString();
        String ReturnDate = jTable1.getValueAt(row, 6).toString();
        String RentDate = jTable1.getValueAt(row, 5).toString();
        
        
        
        
        txtRentId.setText(RentID);
        txtName.setText(CusName);
        txtNIC.setText(NIC);
        txtContactNo.setText(ContactNo);
        txtAddress.setText(Address);
        txtItemId.setText(ItemId);
        try {
            java.util.Date RETURNdate = new SimpleDateFormat("yyyy-MM-dd").parse(ReturnDate);
            java.util.Date RENTdate = new SimpleDateFormat("yyyy-MM-dd").parse(RentDate);
            this.ReturnDate.setDate(RETURNdate);
            this.RentDate.setDate(RENTdate);
        } catch (Exception e) {
            System.out.println();
        }
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtRentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRentIdActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        clearTable();
        lblErr9.setText(null);
        String Search = txtSearch.getText();
        if (radioItemID.isSelected() || radioRentId.isSelected() || radioNIC.isSelected()) {
                    if (radioNIC.isSelected()) {
                        if (Validation.ValidNic(Search)) {
                            tableLoad(Search,"NIC");
                        }
                        else{
                            lblErr9.setText("*Invalid NIC");
                        }
                    }
                    else if(radioItemID.isSelected()){
                        if (ValidItemID(Search)) {
                            tableLoad(Search,"ItemID");
                        }
                        else{
                            lblErr9.setText("*Invalid ItemID");
                        }
                        
                    }
                    else if(radioRentId.isSelected()){
                        if (ValidRentID(Search)) {
                            tableLoad(Search,"RentID");
                        }
                        else{
                            
                            lblErr9.setText("*Invalid RentID");
                        }
                        
                    }
                    
                    
                          
        }
        else{
            JOptionPane.showMessageDialog(null,"No Option Selected","Error",JOptionPane.ERROR_MESSAGE);
                     
        }
            
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        lblErr7.setText(null);
        lblErr8.setText(null);
        int row= jTable1.getSelectedRow();
        
        String InitialItemID = jTable1.getValueAt(row, 4).toString();
        
        String RentID = txtRentId.getText();
        String Name = txtName.getText();
        String NIC = txtNIC.getText();
        String ContactNo = txtContactNo.getText();
        String Address = txtAddress.getText();
        String ItemID = txtItemId.getText();
        String RENTDate= "";
        String RETURNDate ="";
        if (RentDate.getDate()!=null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            RENTDate = dateFormat.format(RentDate.getDate());
        }
        if (ReturnDate.getDate()!=null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            RETURNDate = dateFormat.format(ReturnDate.getDate());
        }
        
        
        
        
        
        
        try {
            String sql2 = "UPDATE rentitem SET Availability = 'Available'  WHERE ItemID ="+InitialItemID+"";
            ps = con.prepareStatement(sql2);
            System.out.println("sdas");
            ps.execute();
            

        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        if (Name.isEmpty() || NIC.isEmpty() || ContactNo.isEmpty() || Address.isEmpty() || ItemID.isEmpty() || RentDate.getDate()==null || ReturnDate.getDate()==null ) {
            JOptionPane.showMessageDialog(null,"Fields Cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
                    if (!Validation.ValidFutureDate(RETURNDate)) {
                        lblErr7.setText("Invalid Date");
                    }
                    if (!Validation.ValidPastDate(RENTDate)) {
                        lblErr8.setText("Invalid Date");
                    }
                    else if (!ItemAvailability(ItemID)) {
                        JOptionPane.showMessageDialog(null,"Item Is Not Available","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if (Validation.ValidName(Name) && Validation.ValidNic(NIC) && Validation.ValidContactNo(ContactNo) && Validation.ValidAddress(Address) && ValidItemID(ItemID) && Validation.ValidFutureDate(RETURNDate) && Validation.ValidPastDate(RENTDate)) {
                            try {

                                    String query1 = "UPDATE Rent SET name = '"+Name+"', NIC = '"+NIC+"', ContactNo = '"+ContactNo+"',Address = '"+Address+"',ItemID = '"+ItemID+"', RentDate = '"+RENTDate+"', ReturnDate = '"+RETURNDate+"'  WHERE RentID ='"+RentID+"' ";

                                    ps = con.prepareStatement(query1);
                                    ps.execute();
                                    JOptionPane.showMessageDialog(null,"Successfully Added","Success",JOptionPane.INFORMATION_MESSAGE);
                                    this.btnClearActionPerformed(evt);

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                                try {
                                    String sql2 = "UPDATE rentitem SET Availability = 'Not Available'  WHERE ItemID ="+ItemID+"";
                                    ps = con.prepareStatement(sql2);
                                    ps.execute();


                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"One or More Fields Are Invalid","Error",JOptionPane.ERROR_MESSAGE);
                    }
        }
        
        
        
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        int row= jTable1.getSelectedRow();
        String RentID = jTable1.getValueAt(row, 7).toString();
        
        try {
                String query2 = "DELETE FROM Rent WHERE RentID ='"+RentID+"'";
                ps = con.prepareStatement(query2);
                ps.execute();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        clear();
        tableRefresh();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String Name = txtName.getText();
        
        if (Name.isEmpty()) {
            lblErr2.setText("*Invalid");
        }
        else {
            if (Validation.ValidName(Name)) {
            lblErr2.setText("");
        }
            else
            lblErr2.setText("*Invalid");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtNICFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNICFocusLost
        String NIC = txtNIC.getText();
        
        if (Validation.ValidNic(NIC)) {
            lblErr3.setText("");
        }
        else{
            lblErr3.setText("*Invalid");
        }
    }//GEN-LAST:event_txtNICFocusLost

    private void txtContactNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactNoFocusLost
        String ContactNo = txtContactNo.getText();
        
        if (Validation.ValidContactNo(ContactNo)) {
            lblErr4.setText("");
        }
        else
            lblErr4.setText("*Invalid");
    }//GEN-LAST:event_txtContactNoFocusLost

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        String Address = txtAddress.getText();
        
        if (Validation.ValidAddress(Address)) {
            lblErr5.setText("");
        }
        else
            lblErr5.setText("*Invalid");
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtItemIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtItemIdFocusLost
        String ItemID = txtItemId.getText();
        
        if (ValidItemID(ItemID)) {
                lblErr6.setText(""); 
        }
        else
            lblErr6.setText("*Invalid");
    }//GEN-LAST:event_txtItemIdFocusLost

    private void txtItemIdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtItemIdPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemIdPropertyChange

    private void btnAgeementGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgeementGenActionPerformed
        int row= jTable1.getSelectedRow();
       
        
        if (row==-1) {
            JOptionPane.showMessageDialog(null,"Select a row first","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            int RentID = Integer.parseInt(jTable1.getValueAt(row, 7).toString());
            ViewIReport.RentalAgreement(RentID);
        }
        
    }//GEN-LAST:event_btnAgeementGenActionPerformed

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
            java.util.logging.Logger.getLogger(EditRentingDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRentingDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRentingDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRentingDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditRentingDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser RentDate;
    private com.toedter.calendar.JDateChooser ReturnDate;
    private javax.swing.JButton btnAgeementGen;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton exitButton3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblErr2;
    private javax.swing.JLabel lblErr3;
    private javax.swing.JLabel lblErr4;
    private javax.swing.JLabel lblErr5;
    private javax.swing.JLabel lblErr6;
    private javax.swing.JLabel lblErr7;
    private javax.swing.JLabel lblErr8;
    private javax.swing.JLabel lblErr9;
    private javax.swing.JButton minimizeButton3;
    private javax.swing.JRadioButton radioItemID;
    private javax.swing.JRadioButton radioNIC;
    private javax.swing.JRadioButton radioRentId;
    private javax.swing.JPanel title3;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtItemId;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRentId;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
