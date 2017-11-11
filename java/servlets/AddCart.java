package servlets;

import classes.Articulo;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddCart extends HttpServlet {
    
    //agregando producto
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        
        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
        
        boolean flag = false;        
        if(articulos.size() > 0){
            for(Articulo a : articulos){
                if(idproducto == a.getIdProducto()){
                    a.setCantidad(a.getCantidad() + cantidad);
                    flag = true;
                    break;
                }
            }
        }
        
        if(!flag){
            articulos.add(new Articulo(idproducto, cantidad));
        }
        
        sesion.setAttribute("carrito", articulos);  
        
        response.sendRedirect("cart.jsp");   
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