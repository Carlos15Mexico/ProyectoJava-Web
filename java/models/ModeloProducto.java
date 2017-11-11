package models;

import classes.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModeloProducto extends Conexion{
     
    public ArrayList<Producto> getAllProductos(){//regrese todos los productos
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;//resultado de la consulta
        try {
            String sql = "call selectProductos()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                productos.add(new Producto(rs.getInt("id_producto"), rs.getString("nombre"), rs.getDouble("precio"),rs.getInt("piezas"),rs.getString("provedor")));
            }
        } catch (Exception e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return productos;        
    }
    
    public Producto getProducto(int id){
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "call selectProducto(?)";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){//guardando los productos en el arraylist
                producto = new Producto(s.getInt("id_producto"), rs.getString("nombre"), rs.getDouble("precio"),rs.getInt("piezas"),rs.getString("provedor"));
            }
        } catch (Exception e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return producto;   
    }
}