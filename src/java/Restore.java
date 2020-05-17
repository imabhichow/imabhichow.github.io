/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/Restore"})
public class Restore extends HttpServlet {
    private static final String USERNAME1 = "root";
    private static final String PASSWORD1 = "root"; 
    private static final String CONN1 = "jdbc:mysql://localhost:3306/";
 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,  ClassNotFoundException, SQLException  {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
        Class.forName("com.mysql.jdbc.Driver"); 
        Class.forName("org.postgresql.Driver"); 
        Connection con1;
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con1=DriverManager.getConnection(CONN1+request.getParameter("db"),USERNAME1,PASSWORD1);       
        System.out.println(request.getParameter("tab")+"</b>---</b>"+request.getParameter("pro"));//Establishing connection with MySQL
        // Statement 
        Statement st1 = con1.createStatement();
        String tv="select * from "+request.getParameter("tab");
        System.out.println("<br>select * from "+request.getParameter("tab"));
        ResultSet tabview = st1.executeQuery(tv);
        List<String> columns = new ArrayList<>();
        for (int i = 1; i <= tabview.getMetaData().getColumnCount(); i++)
            columns.add(tabview.getMetaData().getColumnName(i));
        Statement s2 = con1.createStatement();
        String mod = " ";
        //out.println("<br>"+s2.toString());
        //out.println(request.getParameter("pro"));
           if(request.getParameter("pro").equals("all")){
                       
           while(tabview.next()){
                mod = " INSERT INTO PARENT.PROFILE VALUES('";
                out.print("1111111---"+tabview.getObject(1));
                for (int i = 1; i <= tabview.getMetaData().getColumnCount(); i++)
                {
                    if(i>1)
                        mod+="','";
                    mod+= tabview.getString(i);
                    
                }    
                mod+="')";
                out.println("<b>"+mod+"</b>");
                s2.execute(mod); 

                }
           }
           else{
                        mod = " INSERT INTO PARENT.PROFILE VALUES('";
           while(tabview.next()){
                out.print("1111111---"+tabview.getObject(1));
                if(tabview.getString(1).equalsIgnoreCase(request.getParameter("pro")))
                {
                for (int i = 1; i <= tabview.getMetaData().getColumnCount(); i++)
                {
                    if(i>1)
                        mod+="','";
                    mod+= tabview.getString(i);
                    
                }    
                mod+="')";
                out.println("<b>"+mod+"</b>");
                s2.execute(mod); 

                break;
                }
           }
           }

          if(con1!=null)
            con1.close();
                        

       response.sendRedirect("R");

            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Restore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Restore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Restore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Restore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
