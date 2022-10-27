package mx.edu.utez.examenunitwo.utils;

import java.sql.*;

public class MySQLConnection {
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conexion = MySQLConnection.getConnection();
        if (conexion != null) {
            System.out.println("Correcta conexión");
        } else {
            System.out.println("Conexión no realizada");
        }
    }

    public void close (Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
