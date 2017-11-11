package classes;

public class Producto {
    
    private int id;
    private String nombre;
    private double precio;
    private int piezas;
    private String provedor;

    public Producto(int id, String nombre, double precio, int piezas, String provedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.piezas = piezas;
    }

    public Producto() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }
}