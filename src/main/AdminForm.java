/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import org.mariadb.jdbc.client.result.ResultSetMetaData;

/**
 *
 * @author aulia
 */
public class AdminForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminForm
     */
    public AdminForm() {
        JOptionPane.showMessageDialog(null, "Silahkan Login Terlebih Dahulu");
        Main main = new Main();
        main.show();
        dispose();
//        initComponents();
//        limitInput();
//        roundedButton();
//        newIcon();
//        updateTableMobil();
//        showAkunUser();
    }
    String username;
    AdminForm(String username) {
        initComponents();
        limitInput();
        roundedButton();
        newIcon();
        updateTableMobil();
        showAkunUser();
        this.username = username;
        usernameField.setText(this.username);
    }
     public static String md5Java(String input)
    {
        try {
            
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    private void kosongkanForm() {
        
    }
    private void showAkunUser() {
        String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            
            String SQL = "SELECT * FROM users";
            
            stmt = connection.createStatement();
            
            ResultSet res;
            res = stmt.executeQuery(SQL);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("ID");
            model.addColumn("Username");
            model.addColumn("Password");
            model.addColumn("Nama");
            model.addColumn("Role");
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]
                {
                    no++,res.getString(1) ,res.getString(2), res.getString(3),res.getString(4),res.getString(5)
                });
            }
            userTable.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void updateTableMobil() {
        String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            
            String SQL = "SELECT * FROM mobil";
            
            stmt = connection.createStatement();
            
            ResultSet res;
            res = stmt.executeQuery(SQL);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("ID");
            model.addColumn("Plat");
            model.addColumn("Nama");
            model.addColumn("Warna Cat");
            model.addColumn("Biaya");
            model.addColumn("Status");
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]
                    {
                    no++,res.getString(1),res.getString(2), res.getString(3),res.getString(4),res.getString(5),res.getString(6)  
                    });
            }
            jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void newIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_car.png")));
    }
    private void roundedButton() {
//        logoutButton.setBorder(new RoundedBorder(20));
//        registerButton.setBorder(new RoundedBorder(20));
    }
    private void limitInput() {
        platField.setDocument(new JTextFieldLimit(9));
        catField.setDocument(new JTextFieldLimit(45));
        namaField.setDocument(new JTextFieldLimit(45));
//        passwordField.setDocument(new JTextFieldLimit(45));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        dataTransaksi = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        catField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        tersediaButton = new javax.swing.JRadioButton();
        tidakTersediaButton = new javax.swing.JRadioButton();
        tambahButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ubahButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        biayaField = new javax.swing.JTextField();
        hapusButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        platField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        transaksiTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        adminButton = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        pelangganButton = new javax.swing.JRadioButton();
        registrasiButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rental Mobil");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Form");

        dataTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTransaksiMouseClicked(evt);
            }
        });

        jLabel2.setText("Plat");

        jLabel3.setText("Nama Mobil");

        idField.setEnabled(false);

        jLabel4.setText("Warna Cat");

        jLabel5.setText("Status");

        buttonGroup1.add(tersediaButton);
        tersediaButton.setText("Tersedia");

        buttonGroup1.add(tidakTersediaButton);
        tidakTersediaButton.setText("Tidak Tersedia");

        tambahButton.setText("Tambah");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID", "Plat", "Nama", "Warna Cat", "Biaya", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        ubahButton.setText("Ubah");
        ubahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Biaya");

        biayaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayaFieldActionPerformed(evt);
            }
        });

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(110, 110, 110)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(55, 55, 55)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(catField)
                                .addComponent(namaField)
                                .addComponent(tersediaButton)
                                .addComponent(tidakTersediaButton)
                                .addComponent(biayaField)
                                .addComponent(platField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tambahButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addGap(28, 28, 28)
                            .addComponent(ubahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(hapusButton, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))))
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(platField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(catField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(biayaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tersediaButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tidakTersediaButton)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahButton)
                            .addComponent(ubahButton)
                            .addComponent(hapusButton))
                        .addGap(18, 18, 18)
                        .addComponent(clearButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataTransaksi.addTab("Data Mobil", jPanel1);

        transaksiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        transaksiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(transaksiTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataTransaksi.addTab("Data Transaksi", jPanel2);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(userTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        dataTransaksi.addTab("Akun User", jPanel3);

        jLabel8.setText("Username");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel9.setText("Password");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel11.setText("Nama");

        buttonGroup2.add(adminButton);
        adminButton.setText("Admin");

        jLabel10.setText("Role");

        buttonGroup2.add(pelangganButton);
        pelangganButton.setText("Pelanggan");

        registrasiButton.setText("Register");
        registrasiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrasiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(357, 357, 357)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pelangganButton)
                                    .addComponent(adminButton))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(registrasiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(5, 5, 5)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminButton)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(pelangganButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(registrasiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dataTransaksi.addTab("Tambah Akun", jPanel4);

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        usernameField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addGap(24, 24, 24))
            .addComponent(dataTransaksi, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(logoutButton)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dataTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Berhasil Logout");
        dispose();
        Main main = new Main();
        main.show();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        idField.setText("");
        platField.setText("");
        catField.setText("");
        namaField.setText("");
        biayaField.setText("");
        tersediaButton.setSelected(true);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
        String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            String plat = platField.getText();
            String nama = namaField.getText();
            String cat = catField.getText();
            String biaya = biayaField.getText();
            String status;
            if(tersediaButton.isSelected()) {
                status = "Tersedia";
            }
            else
                status = "Tidak Tersedia";
            
            String SQL = "INSERT INTO mobil VALUES(NULL,'"+plat+"','"+nama+"','"+cat+"','"+biaya+"','"+status+"' )";
            
            stmt = connection.createStatement();
            
            int rs = stmt.executeUpdate(SQL);
            
            if(rs>0)
            {
                JOptionPane.showMessageDialog(null, "Insert Berhasil");
                idField.setText("");
                platField.setText("");
                catField.setText("");
                namaField.setText("");
                biayaField.setText("");
                tersediaButton.setSelected(true);
                updateTableMobil();
            }
            else
                JOptionPane.showMessageDialog(null, "Insert Gagal");
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void dataTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTransaksiMouseClicked
        // TODO add your handling code here:
                String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            
            String SQL = "SELECT * FROM transaksi";
            
            stmt = connection.createStatement();
            
            ResultSet res;
            res = stmt.executeQuery(SQL);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Kode Transaksi");
            model.addColumn("Plat");
            model.addColumn("Username Pelanggan");
            model.addColumn("Lama Rental");
            model.addColumn("Biaya");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Jenis Transaksi");
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]
                    {
                    no++,res.getString(2), res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7), res.getString(8)    
                    });
            }
            transaksiTable.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_dataTransaksiMouseClicked

    private void transaksiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiTableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_transaksiTableMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        String selection = jTable1.getModel().getValueAt(row, 1).toString();
        String conn =
        "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";

        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            String SQL = "select * from mobil where id = '"+selection+"' ";

            stmt = connection.createStatement();
            ResultSet res;
            res = stmt.executeQuery(SQL);
            if(res.next()) {
                idField.setText(res.getString("id"));
                platField.setText(res.getString("plat"));
                namaField.setText(res.getString("nama"));
                catField.setText(res.getString("cat"));
                biayaField.setText(res.getString("biaya"));
                String status = res.getString("status");
                if(status.equals("Tersedia")) {
                    tersediaButton.setSelected(true);
                }
                else {
                    tidakTersediaButton.setSelected(true);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void ubahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtonActionPerformed
        // TODO add your handling code here:
        String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            String id = idField.getText();
            String plat = platField.getText();
            String nama = namaField.getText();
            String cat = catField.getText();
            String biaya = biayaField.getText();
            String status;
            if(tersediaButton.isSelected()) {
                status = "Tersedia";
            }
            else
                status = "Tidak Tersedia";
            
//            String SQL = "INSERT INTO mobil VALUES(NULL,'"+plat+"','"+nama+"','"+cat+"','"+biaya+"','"+status+"' )";
            String SQL = "UPDATE mobil set plat = '"+plat+"',nama = '"+nama+"',cat = '"+cat+"',biaya = '"+biaya+"',status = '"+status+"' WHERE id = '"+id+"' ";
            stmt = connection.createStatement();
            
            int rs = stmt.executeUpdate(SQL);
            
            if(rs>0)
            {
                JOptionPane.showMessageDialog(null, "Update Berhasil");
                idField.setText("");
                platField.setText("");
                catField.setText("");
                namaField.setText("");
                biayaField.setText("");
                tersediaButton.setSelected(true);
                updateTableMobil();
            }
            else
                JOptionPane.showMessageDialog(null, "Update Gagal");
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ubahButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        // TODO add your handling code here:
          String conn = 
        "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = 
            (Connection) DriverManager.getConnection(conn);  
            Statement stmt;
            ResultSet rs;
            String plat = platField.getText();
            String SQL = "delete from mobil where plat = '"+plat+"'";
            
            stmt = connection.createStatement();
            int rs_num = stmt.executeUpdate(SQL);
            
            if(rs_num>0)   //ketemu
            {
               JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
               updateTableMobil();
            }
            else            //tidak ketemu
            {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void biayaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biayaFieldActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void registrasiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrasiButtonActionPerformed
        // TODO add your handling code here
        String conn = "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";

        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);

            Statement stmt;

            String user = txtUsername.getText();
            String pass = md5Java(txtPassword.getText());
            String nama = txtNama.getText();
            String role;
            if(adminButton.isSelected()){
                role = "Admin";
            }
            else {
                role = "Pelanggan";
            }

            String SQL = "INSERT INTO users VALUES(NULL,'"+user+"','"+pass+"','"+nama+"','"+role+"')";
            stmt = connection.createStatement();
            int rs = stmt.executeUpdate(SQL);

            if(rs>0)
            {
                JOptionPane.showMessageDialog(null, "Register Berhasil");
                txtUsername.setText("");
                txtPassword.setText("");
                txtNama.setText("");
                adminButton.setSelected(true);
            }
            else
            JOptionPane.showMessageDialog(null, "Register Gagal");

        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registrasiButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        FlatNordIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminButton;
    private javax.swing.JTextField biayaField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField catField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTabbedPane dataTransaksi;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField namaField;
    private javax.swing.JRadioButton pelangganButton;
    private javax.swing.JTextField platField;
    private javax.swing.JButton registrasiButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JRadioButton tersediaButton;
    private javax.swing.JRadioButton tidakTersediaButton;
    private javax.swing.JTable transaksiTable;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JButton ubahButton;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}



