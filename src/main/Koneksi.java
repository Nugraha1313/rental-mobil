/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author aulia
 */
public class Koneksi {
    public static void connectDB() {
        String conn ="jdbc:mariadb://127.0.0.1:3306/pemvisreg?user=root&password=";
        try {
            Connection connection = (Connection) DriverManager.getConnection(conn);
            System.out.print("Berhasil");
        }
        catch (SQLException ex) {
            System.out.print(ex);
        }
    }
}
