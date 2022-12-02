/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author aulia
 */
public class PelangganForm extends javax.swing.JFrame {

    /**
     * Creates new form PelangganForm
     */
    public PelangganForm() {
        JOptionPane.showMessageDialog(null, "Silahkan Login Terlebih Dahulu");
        Main main = new Main();
        main.show();
        dispose();
//        initComponents();
//        limitInput();
//        roundedButton();
//        newIcon();
//        updateTableMobil();
    }
    String username;
    PelangganForm(String username) {
        initComponents();
        limitInput();
        roundedButton();
        newIcon();
        updateTableMobil();
        this.username = username;
        usernameField.setText(username);
    }
    
    
    private void tabelPengembalian() {
        String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
//            String SQL = "SELECT * FROM transaksi where username_pelanggan = '"+this.username+"' ";
            String SQL = "SELECT * FROM transaksi where username_pelanggan = '"+this.username+"' ORDER BY id DESC LIMIT 1 ";
            stmt = connection.createStatement();
            
            ResultSet res;
            res = stmt.executeQuery(SQL);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Kode Transaksi");
            model.addColumn("Plat");
            model.addColumn("Lama Rental");
            model.addColumn("Biaya");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Jenis Transaksi");
            int no = 1;
            while (res.next()) {
                if(res.getString(8).equals("Perentalan")) {
                model.addRow(new Object[]
                    {
                    no++,res.getString(2), res.getString(3),res.getString(5),res.getString(6),res.getString(7),res.getString(8)  
                    });
                }
                
            }
            jTable2.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearPengembalian() {
       platPengembalianField.setText("");
       kodePengembalianField.setText("");
    }
    
    
    
    private void clearTransaksi() {
        String plat = platField.getText();
        String kodeTransaksi = kodeTransaksiField.getText();
        String username = usernameField.getText();
        String lamaRental = lamaRentalField.getText();
        String biaya = biayaField.getText();
        platField.setText("");
        kodeTransaksiField.setText("");
//        usernameField.setText("");
        lamaRentalField.setText("");
        biayaField.setText("");
        totalBayarField.setText("");
    }
    
    private void updateTableMobil() {
        String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            
            String SQL = "SELECT * FROM mobil where status = 'Tersedia'";
            
            stmt = connection.createStatement();
            
            ResultSet res;
            res = stmt.executeQuery(SQL);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Plat");
            model.addColumn("Nama");
            model.addColumn("Warna Cat");
            model.addColumn("Biaya");
            model.addColumn("Status");
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]
                    {
                    no++,res.getString(2), res.getString(3),res.getString(4),res.getString(5),res.getString(6)  
                    });
            }
            jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String generateKodeTransaksi() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        
        return generatedString;
    }
    private void newIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_car.png")));
    }
    private void roundedButton() {
//        loginButton.setBorder(new RoundedBorder(20));
//        registerButton.setBorder(new RoundedBorder(20));
    }
    private void limitInput() {
//        usernameField.setDocument(new JTextFieldLimit(45));
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

        jLabel1 = new javax.swing.JLabel();
        riwayatTransaksiPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        platField = new javax.swing.JTextField();
        kodeTransaksiField = new javax.swing.JTextField();
        totalBayarField = new javax.swing.JTextField();
        hitungTotalBayarButton = new javax.swing.JButton();
        rentalButton = new javax.swing.JButton();
        lamaRentalField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        biayaField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        kembalikanMobilButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        kodePengembalianField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        platPengembalianField = new javax.swing.JTextField();
        logoutButton = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rental Mobil");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rental Mobil");

        riwayatTransaksiPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayatTransaksiPaneMouseClicked(evt);
            }
        });

        jLabel2.setText("Kode Transaksi");

        jLabel3.setText("Plat");

        jLabel5.setText("Biaya");

        jLabel6.setText("Lama Rental (Total Bulan)");

        kodeTransaksiField.setEnabled(false);
        kodeTransaksiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeTransaksiFieldActionPerformed(evt);
            }
        });

        totalBayarField.setEnabled(false);

        hitungTotalBayarButton.setText("Hitung Total Bayar");
        hitungTotalBayarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungTotalBayarButtonActionPerformed(evt);
            }
        });

        rentalButton.setText("Rental");
        rentalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalButtonActionPerformed(evt);
            }
        });

        lamaRentalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamaRentalFieldActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Plat", "Nama", "Warna Cat", "Biaya", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Nama");
        }

        jLabel7.setText("Total Bayar");

        biayaField.setEnabled(false);

        jLabel8.setText("Rp");

        jLabel9.setText("Rp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(hitungTotalBayarButton))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kodeTransaksiField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lamaRentalField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(platField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(biayaField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalBayarField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(rentalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(platField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lamaRentalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kodeTransaksiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(biayaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(totalBayarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hitungTotalBayarButton)
                            .addComponent(rentalButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        riwayatTransaksiPane.addTab("Rental Mobil", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        kembalikanMobilButton.setText("Kembalikan Mobil");
        kembalikanMobilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalikanMobilButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Kode Transaksi");

        kodePengembalianField.setEnabled(false);

        jLabel10.setText("Plat");

        platPengembalianField.setEnabled(false);
        platPengembalianField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platPengembalianFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(platPengembalianField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(kodePengembalianField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(kembalikanMobilButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kodePengembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(platPengembalianField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(kembalikanMobilButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        riwayatTransaksiPane.addTab("Form Pengembalian", jPanel2);

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        usernameField.setEnabled(false);
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(riwayatTransaksiPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(logoutButton)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(riwayatTransaksiPane))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        String selection = jTable1.getModel().getValueAt(row, 1).toString();
        String conn =
        "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";

        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            String SQL = "select * from mobil where plat = '"+selection+"' ";

            stmt = connection.createStatement();
            ResultSet res;
            res = stmt.executeQuery(SQL);

            if(res.next()) {
                platField.setText(res.getString("plat"));
                biayaField.setText(res.getString("biaya"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void rentalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalButtonActionPerformed
        // TODO add your handling code here:
        String conn =
        "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";

        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String tgl_transaksi = formatter.format(date);
            String plat = platField.getText();
            String kodeTransaksi = kodeTransaksiField.getText();
            String username = usernameField.getText();
            String lamaRental = lamaRentalField.getText();
            String biaya = biayaField.getText();
            String jenis_transaksi = "Perentalan";

            String SQL = "INSERT INTO transaksi VALUES(NULL,'"+kodeTransaksi+"','"+plat+"','"+username+"','"+lamaRental+"','"+biaya+"','"+tgl_transaksi+"', '"+jenis_transaksi+"')";

            stmt = connection.createStatement();

            int rs = stmt.executeUpdate(SQL);

            if(rs>0)
            {
                JOptionPane.showMessageDialog(null, "Berhasil Merental");
                clearTransaksi();
                updateTableMobil();
            }
            else
            JOptionPane.showMessageDialog(null, "Gagal Merental");

        } catch (SQLException ex) {
            Logger.getLogger(PelangganForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rentalButtonActionPerformed

    private void hitungTotalBayarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungTotalBayarButtonActionPerformed
        // TODO add your handling code here:
        String kodeTransaksi = generateKodeTransaksi();
        kodeTransaksiField.setText(kodeTransaksi);
        int lamaRental;
        if(lamaRentalField.getText().equals("")) {
            lamaRentalField.setText("0");
            lamaRental = 0;
        }
        else {
            lamaRental = Integer.parseInt(lamaRentalField.getText());
        }
        int biaya = Integer.parseInt(biayaField.getText());
        int totalBayar = biaya * lamaRental;
        String convertTotal = String.valueOf(totalBayar);
        totalBayarField.setText(convertTotal);
    }//GEN-LAST:event_hitungTotalBayarButtonActionPerformed

    private void kodeTransaksiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeTransaksiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeTransaksiFieldActionPerformed

    private void riwayatTransaksiPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayatTransaksiPaneMouseClicked
        // TODO add your handling code here:
        String conn =
                "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";
        
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            String SQL = "SELECT * FROM transaksi where username_pelanggan = '"+this.username+"' ORDER BY id DESC LIMIT 1 ";
            
            stmt = connection.createStatement();
            
            ResultSet res;
            res = stmt.executeQuery(SQL);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Kode Transaksi");
            model.addColumn("Plat");
            model.addColumn("Lama Rental");
            model.addColumn("Biaya");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Jenis Transaksi");
            int no = 1;
            while (res.next()) {
                if(res.getString(8).equals("Perentalan")) {
                    
                model.addRow(new Object[]
                    {
                    no++,res.getString(2), res.getString(3),res.getString(5),res.getString(6),res.getString(7),res.getString(8)  
                    });
                }
            }
            jTable2.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_riwayatTransaksiPaneMouseClicked

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Berhasil Logout");
        dispose();
        this.username = null;
        Main main = new Main();
        main.show();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed
    String kodePengembalian;
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        kodePengembalian = generateKodeTransaksi();
        int row = jTable2.getSelectedRow();
        String selection = jTable2.getModel().getValueAt(row, 1).toString();
        String conn =
        "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";

        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            String SQL = "select * from transaksi where kode_transaksi = '"+selection+"' ";

            stmt = connection.createStatement();
            ResultSet res;
            res = stmt.executeQuery(SQL);
            if(res.next()) {
                platPengembalianField.setText(res.getString("plat"));
                kodePengembalianField.setText(kodePengembalian);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void platPengembalianFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platPengembalianFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platPengembalianFieldActionPerformed

    private void kembalikanMobilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalikanMobilButtonActionPerformed
        // TODO add your handling code here:
         String conn =
        "jdbc:mariadb://127.0.0.1:3306/rental_mobil?user=root&password=";

        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            Statement stmt;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String tgl_transaksi = formatter.format(date);
            String plat = platPengembalianField.getText();
            String kodeTransaksi = kodePengembalian;
            String username = usernameField.getText();
            String lamaRental = "0";
            String biaya = "0";
            String jenis_transaksi = "Pengembalian";

            String SQL = "INSERT INTO transaksi VALUES(NULL,'"+kodeTransaksi+"','"+plat+"','"+username+"','"+lamaRental+"','"+biaya+"','"+tgl_transaksi+"','"+jenis_transaksi+"')";
            
            stmt = connection.createStatement();

            int rs = stmt.executeUpdate(SQL);

            if(rs>0)
            {
                SQL = "UPDATE mobil set status = 'Tersedia' WHERE plat = '"+plat+"' ";
                stmt = connection.createStatement();
                rs = stmt.executeUpdate(SQL);
                JOptionPane.showMessageDialog(null, "Berhasil Mengembalikan Mobil");
                clearPengembalian();
                updateTableMobil();
                tabelPengembalian();
            }
            else
            JOptionPane.showMessageDialog(null, "Gagal Mengembalikan Mobil");

        } catch (SQLException ex) {
            Logger.getLogger(PelangganForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kembalikanMobilButtonActionPerformed

    private void lamaRentalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamaRentalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lamaRentalFieldActionPerformed
    
//    String tanggalTransaksi;
//    public void tanggal() {
//        if(jDateChooser1.getDate() != null) {
//            String pattern = "yyyy-MM-dd";
//            SimpleDateFormat format = new SimpleDateFormat(pattern);
//            tanggalTransaksi = String.valueOf(format.format(jDateChooser1.getDate()));
//        }
//    }
    
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
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        FlatNordIJTheme.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PelangganForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField biayaField;
    private javax.swing.JButton hitungTotalBayarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton kembalikanMobilButton;
    private javax.swing.JTextField kodePengembalianField;
    private javax.swing.JTextField kodeTransaksiField;
    private javax.swing.JTextField lamaRentalField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField platField;
    private javax.swing.JTextField platPengembalianField;
    private javax.swing.JButton rentalButton;
    private javax.swing.JTabbedPane riwayatTransaksiPane;
    private javax.swing.JTextField totalBayarField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
