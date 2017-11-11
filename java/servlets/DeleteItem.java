package servlets;

import classes.Articulo;
import classes.Producto;
import controllers.ControladorProducto;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DeleteItem extends HttpServlet {

    //borrarando item
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        
        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
        
        if(articulos != null){
            for(Articulo a : articulos){                
                if(a.getIdProducto() == idproducto){
                    articulos.remove(a);
                    break;
                }
            }
        }
        
        double total = 0;
        ControladorProducto cp = new ControladorProducto();
        for(Articulo a : articulos){                
            Producto producto = cp.getProducto(a.getIdProducto());
            total += a.getCantidad() * producto.getPrecio();            
        }
        
        response.getWriter().print(Math.round(total * 100.0) /100.0);  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}