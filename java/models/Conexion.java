package models;

import java.sql.*;

public class Conexion {
    private String hostname = "localhost";
    private String port = "5432";
    private String database = "PrebeHermanos";
    private String username = "postgres";
    private String password = "Joule7";
    private String classname = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://"+hostname+":"+port+"/"+database;
    private Connection conn;

    public Conexion() {
        try {
            Class.forName(classname);
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }
}
