/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noveena;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sachindra
 */
public class RentItemInteface extends javax.swing.JFrame {
    
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        AddItems additem = new AddItems();
        ReturnItem returnItem = new ReturnItem();
        EditRentingDetails editRent = new EditRentingDetails(); 
       
        
   
    public RentItemInteface() {
        try {
            this.setUndecorated(true);
            this.setAlwaysOnTop(false);
            this.setResizable(false);
            this.setVisible(true);
        
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
            int xsize=(int) tk.getScreenSize().getWidth();
            int ysize=(int) tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        

           
        } catch (Exception e) {
        }
        
        con =DBconnect.connect();
        tableRefresh();
        
                
    }
    
         
    public void tableLoad(String text){
        
        try {
            String sql = "SELECT ItemID,ItemName,Make,Model,Deposit,RentCharge,Availability From rentitem WHERE ItemName LIKE '%"+text+"%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void tableRefresh(){
        
        try {
            String sql = "SELECT * FROM rentitem ORDER BY ItemID";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void clear(){
        
        txtAddress.setText(null);
        txtContact.setText(null);
        txtItemID.setText(null);
        txtNIC.setText(null);
        txtName.setText(null);
        txtSearchItem.setText(null);
        date.setCalendar(null);
        
    }
    
    public void clearTable(){
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel(); 
            model.setRowCount(0);
        }
    
    public void clearLabels(){
        lblErr1.setText(null);
        lblErr2.setText(null);
        lblErr3.setText(null);
        lblErr4.setText(null);
        lblErr6.setText(null);
        lblErr7.setText(null);
        
        
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

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNIC = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtItemID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtSearchItem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnReturnItem = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnEditRent = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        lblErr1 = new javax.swing.JLabel();
        lblErr2 = new javax.swing.JLabel();
        lblErr3 = new javax.swing.JLabel();
        lblErr4 = new javax.swing.JLabel();
        lblErr6 = new javax.swing.JLabel();
        lblErr7 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel3.setText("Customer Name :");

        txtName.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
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

        txtContact.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactFocusLost(evt);
            }
        });

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

        txtItemID.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtItemID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtItemIDFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Item ID :");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Address :");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Contact No :");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("NIC No :");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Return Date :");

        jTable1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Make", "Model", "Deposit", "Rent Charge", "Avalability"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("Item Name :");

        txtSearchItem.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/file_add (2).png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReturnItem.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReturnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/file_return.png"))); // NOI18N
        btnReturnItem.setText("Return Item");
        btnReturnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnItemActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/file_sync.png"))); // NOI18N
        jButton4.setText("Add/Update Items");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnEditRent.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEditRent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/file_edit (1).png"))); // NOI18N
        btnEditRent.setText("Edit Renting Details ");
        btnEditRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRentActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/eraser-128.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel12.setText("AddRenting Details");

        lblErr1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblErr1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblErr1KeyReleased(evt);
            }
        });

        lblErr2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblErr2FocusLost(evt);
            }
        });
        lblErr2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblErr2KeyTyped(evt);
            }
        });

        date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFocusLost(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3)
                        .addGap(51, 51, 51)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel8)
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180)
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addComponent(txtSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(lblErr2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErr3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErr4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtItemID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblErr6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(731, 731, 731)
                        .addComponent(btnReturnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(86, 86, 86)
                                .addComponent(btnClear))
                            .addComponent(lblErr7, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(btnEditRent, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtSearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(lblErr2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel4)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(lblErr3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(lblErr4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblErr6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(lblErr7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditRent, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        title.setBackground(new java.awt.Color(102, 102, 102));
        title.setAlignmentX(0.0F);
        title.setAlignmentY(0.0F);

        jLabel1.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rent Items Management System");

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/126001-matte-white-square-icon-symbols-shapes-minimize (Custom).png"))); // NOI18N
        minimizeButton.setToolTipText("minimize");
        minimizeButton.setBorder(null);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setPreferredSize(new java.awt.Dimension(30, 30));
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/close-icon-16 (Custom).png"))); // NOI18N
        exitButton.setToolTipText("exit");
        exitButton.setPreferredSize(new java.awt.Dimension(30, 30));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noveena/noveena_logo (Mobile) (Custom) (Custom).png"))); // NOI18N

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(512, 512, 512)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(titleLayout.createSequentialGroup()
                .addGroup(titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(titleLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButtonActionPerformed
        this.setState(RentItemInteface.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonActionPerformed

    private void txtNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNICActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnEditRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRentActionPerformed
               
        editRent.setVisible(true);
    }//GEN-LAST:event_btnEditRentActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        lblErr7.setText(null);
        
        String Name = txtName.getText();
        String NIC = txtNIC.getText();
        String ContactNo = txtContact.getText();
        String Address = txtAddress.getText();
        String ItemID = txtItemID.getText();
        String Date =null;
        
        if (date.getDate()!=null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date = dateFormat.format(date.getDate());
        }
        
        String rentc;
        String payment;
        int GetRentID=0;
        
        
        
        if (date.getDate()==null) {
            lblErr7.setText("Date not Selected");
        }
        else if (!Validation.ValidFutureDate(Date)) {
           JOptionPane.showMessageDialog(null,"Invalid Date","Error",JOptionPane.ERROR_MESSAGE); 
        }
        
        
        else if ( Name.isEmpty() || NIC.isEmpty() || ContactNo.isEmpty() || Address.isEmpty() || ItemID.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Fields Cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
            
            
        }
        else if (!ItemAvailability(ItemID)) {
            JOptionPane.showMessageDialog(null,"Item is Not Available","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if (!Validation.ValidFutureDate(Date)) {
            JOptionPane.showMessageDialog(null,"Invalid Date","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        else if (Validation.ValidName(Name) && Validation.ValidNic(NIC) && Validation.ValidContactNo(ContactNo) && Validation.ValidAddress(Address) && Validation.ValidFutureDate(Date) && ValidItemID(ItemID)) {
            try {
            String query2 = "SELECT RentCharge FROM rentitem WHERE ItemID ='"+ItemID+"'";
            ps = con.prepareStatement(query2);
            rs=ps.executeQuery();
            
                while(rs.next()){
                    rentc = rs.getString("RentCharge");
                    String query1 = "INSERT INTO RENT (name,NIC,ContactNo,Address,ItemID,RentDate,ReturnDate,Payment,Returned) VALUES ('"+Name+"', '"+NIC+"', '"+ContactNo+"', '"+Address+"', '"+ItemID+"', CURDATE(), '"+Date+"',(DATEDIFF('"+Date+"',CURDATE()))*"+rentc+",0)";

                    ps = con.prepareStatement(query1);
                    ps.execute();
                                    String query3 = "SELECT RentID FROM Rent WHERE RentID = @@IDENTITY";
                                    ps = con.prepareStatement(query3);
                                    rs = ps.executeQuery();
                                    while (rs.next()) {                        
                                            GetRentID = Integer.parseInt(rs.getString(1));
                                            break;
                                    }
                                    
                    
                                            String query4 = "UPDATE rentitem SET Availability = 'Not Available'  WHERE ItemID ='"+ItemID+"' ";    
                                            ps = con.prepareStatement(query4);
                                            ps.execute();
                    
                    int x = JOptionPane.showConfirmDialog(null,"Succesfully Added Press Yes to Genererate Agreement");
                    if (x==0) {
//                        ViewIReport.RentalAgreement(GetRentID);
                    }
                    else
                       JOptionPane.showMessageDialog(null,"Rent ID : "+GetRentID,"Success",JOptionPane.ERROR_MESSAGE); 
                    btnClearActionPerformed(evt);
                    
                    
                }    
            } catch (Exception e) {
            System.out.println(e);
                System.out.println("sda");
            }
          
        }
        else
            JOptionPane.showMessageDialog(null,"Fields cannot be Empty Or Invalid Entry","Error",JOptionPane.ERROR_MESSAGE);
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        String ItemName = txtSearchItem.getText();
        tableLoad(ItemName);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnReturnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnItemActionPerformed
        returnItem.setVisible(true);
        additem.dispose();
        editRent.dispose();
    }//GEN-LAST:event_btnReturnItemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        additem.setVisible(true);
        returnItem.dispose();
        editRent.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        returnItem.dispose();
        additem.dispose();
        editRent.dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
        tableRefresh();
        clearLabels();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        
        
    }//GEN-LAST:event_txtNameKeyTyped

    private void lblErr1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblErr1KeyReleased
        
    }//GEN-LAST:event_lblErr1KeyReleased

    private void lblErr1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblErr1KeyPressed
            
    }//GEN-LAST:event_lblErr1KeyPressed

    private void lblErr2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblErr2KeyTyped
        
        
    }//GEN-LAST:event_lblErr2KeyTyped

    private void lblErr2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblErr2FocusLost
        
    }//GEN-LAST:event_lblErr2FocusLost

    private void txtNICFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNICFocusLost
        String NIC = txtNIC.getText();
        
        if (Validation.ValidNic(NIC) || NIC.isEmpty()) {
            lblErr2.setText("");
        }
        else{
            lblErr2.setText("*Invalid");
        }
        
    }//GEN-LAST:event_txtNICFocusLost

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String Name = txtName.getText();
        
       
        
            if (Validation.ValidName(Name) || Name.isEmpty()) {
            lblErr1.setText("");
            }
            else
            lblErr1.setText("*Invalid");
        
    }//GEN-LAST:event_txtNameFocusLost

    private void txtContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusLost
        String ContactNo = txtContact.getText();
        
        if (Validation.ValidContactNo(ContactNo) || ContactNo.isEmpty()) {
            lblErr3.setText("");
        }
        else
            lblErr3.setText("*Invalid");
    }//GEN-LAST:event_txtContactFocusLost

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        String Address = txtAddress.getText();
        
        if (Validation.ValidAddress(Address) || Address.isEmpty()) {
            lblErr4.setText("");
        }
        else
            lblErr4.setText("*Invalid");
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtItemIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtItemIDFocusLost
        String ItemID = txtItemID.getText();
        
        if (ValidItemID(ItemID) || ItemID.isEmpty()) {
            lblErr6.setText("");
        }
        else
            lblErr6.setText("*Invalid");
        
        
    }//GEN-LAST:event_txtItemIDFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        mainInterface mainI = new mainInterface();
//        mainI.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFocusLost
//        String RENTDate = null;
//        if (date.getDate()!=null) {
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            RENTDate = dateFormat.format(date.getDate());
//        }
//        
//        if (!Validation.ValidPastDate(RENTDate)) {
//            
//        }
//        else{
//            lblErr7.setText("Invalid date");
//        }
    }//GEN-LAST:event_dateFocusLost

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
            java.util.logging.Logger.getLogger(RentItemInteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentItemInteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentItemInteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentItemInteface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentItemInteface().setVisible(true);
            }
        });
        
        
        
//         Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
//                timeLabel.setText(time);
//            }
//        }, 0, 1000);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEditRent;
    private javax.swing.JButton btnReturnItem;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblErr1;
    private javax.swing.JLabel lblErr2;
    private javax.swing.JLabel lblErr3;
    private javax.swing.JLabel lblErr4;
    private javax.swing.JLabel lblErr6;
    private javax.swing.JLabel lblErr7;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JPanel title;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearchItem;
    // End of variables declaration//GEN-END:variables
}
