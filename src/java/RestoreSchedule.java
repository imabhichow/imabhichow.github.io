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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/Res"})
public class RestoreSchedule extends HttpServlet {
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
        try (PrintWriter out = response.getWriter()) {
        Class.forName("com.mysql.jdbc.Driver"); 
        Class.forName("org.postgresql.Driver"); 
        Connection con1;
        //CONN1+=request.getParameter("tab");
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con1=DriverManager.getConnection(CONN1+request.getParameter("tab"),USERNAME1,PASSWORD1);        
       // out.println("Connection Established");//Establishing connection with MySQL
    
           
            out.println("");
            out.println("<html>\n" +
"<head>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<style>\n" +
"body {font-family: Arial;}\n" +
"\n" +
"/* Style the tab */\n" +
".tab {\n" +
"  overflow: hidden;\n" +
"  border: 1px solid #ccc;\n" +
"  background-color: #f1f1f1;\n" +
"}\n" +
"\n" +
"/* Style the buttons inside the tab */\n" +
".tab button {\n" +
"  background-color: inherit;\n" +
"  float: left;\n" +
"  border: none;\n" +
"  outline: none;\n" +
"  cursor: pointer;\n" +
"  padding: 14px 16px;\n" +
"  transition: 0.3s;\n" +
"  font-size: 17px;\n" +
"}\n" +
"\n" +
"/* Change background color of buttons on hover */\n" +
".tab button:hover {\n" +
"  background-color: #ddd;\n" +
"}\n" +
"\n" +
"/* Create an active/current tablink class */\n" +
".tab button.active {\n" +
"  background-color: #ccc;\n" +
"}\n" +
"\n" +
"/* Style the tab content */\n" +
".tabcontent {\n" +
"  display: none;\n" +
"  padding: 6px 12px;\n" +
"  border: 1px solid #ccc;\n" +
"  border-top: none;\n" +
"}\n" +
"\n" +
"/* If you want the content centered horizontally and vertically */\n" +
".centered {\n" +
"  position: absolute;\n" +
"  top: 50%;\n" +
"  left: 50%;\n" +
"  transform: translate(-50%, -50%);\n" +
"  text-align: center;\n" +
"}\n" +
"\n" +
"\n" +
"/* Style the image inside the centered container, if needed */\n" +
".centered img {\n" +
"  width: 150px;\n" +
"  border-radius: 50%;\n" +
"}\n" +
".dropbtn {\n" +
"  background-color: #4CAF50;\n" +
"  color: white;\n" +
"  padding: 16px;\n" +
"  font-size: 16px;\n" +
"  border: none;\n" +
"}\n" +
"\n" +
".dropdown {\n" +
"  position: relative;\n" +
"  display: inline-block;\n" +
"}\n" +
"\n" +
".dropdown-content {\n" +
"  display: none;\n" +
"  position: absolute;\n" +
"  background-color: #f1f1f1;\n" +
"  min-width: 160px;\n" +
"  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n" +
"  z-index: 1;\n" +
"}\n" +
"\n" +
".dropdown-content a {\n" +
"  color: black;\n" +
"  padding: 12px 16px;\n" +
"  text-decoration: none;\n" +
"  display: block;\n" +
"}\n" +
"\n" +
".dropdown-content a:hover {background-color: #ddd;}\n" +
"\n" +
".dropdown:hover .dropdown-content {display: block;}\n" +
"\n" +
".dropdown:hover .dropbtn {background-color: #3e8e41;}\n" +
"body {\n" +
"     \n" +
"    margin: 0;\n" +
"    width: 100%;\n" +
"    background-position: align;\n" +
"    background-repeat: repeat;\n" +
"    background-size: auto;\n" +
"}"+
"</style>\n" +
"</head>");
            out.println("<body> \n" +
"<div class=\"tab\">\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"Home\")'>Home</button>\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"P\")'>Profile</button>\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"B\")'>Backup</button>\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"R\")'>Restore</button>\n" +
"</div>\n" +
"    <frameset>\n" +
"        <frame>\n" +
"            <table border=\"1\">\n" +
"                <tr> \n" +
"                    <td><b> BACKUPS in <h2>"
                    + request.getParameter("tab")
                    + "</h2> SCHEDULE          </b></td>\n" +
"                    <td><b>Select Profile         </b></td>\n" +
"                </tr>");
            //Tables 
            Statement st1=con1.createStatement();
            ResultSet tables = st1.executeQuery("show tables");
            while(tables.next()){
                out.println("<tr>");
                out.println("<td>"+tables.getString(1)+"</td>");
                out.println("<td><div class=\"dropdown\"><button class=\"dropbtn\">Profiles list</button><div class=\"dropdown-content\">");
                Statement st2=con1.createStatement();
                ResultSet profiles =st2.executeQuery("select * from "+tables.getString(1));
                out.println("<a href=\"Restore?pro=all"

                                  + "&tab="
                                  + tables.getString(1)
                                  + "&db="
                                  + request.getParameter("tab")
                                  + "\">"
                                  + "All Profiles"
                                  + "</a>");
                while(profiles.next()){
                          String mod = "<a href=\"Restore?pro="
                                  + profiles.getString(1)
                                  + "&tab="
                                  + tables.getString(1)
                                  + "&db="
                                  + request.getParameter("tab")
                                  + "\">"
                                  + profiles.getString(1)
                                  + "</a>";
                          //System.out.println(mod);
                          out.println(mod);  
                }         
                out.println("</div></div></td></tr>");
            }
            

            out.println("");
            out.println("");
            //Continution
            out.println("\n" +
"            </table>\n" +
"        <frame>\n" +
"    </frameset>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"<script>\n" +
"\n" +
"</script>\n" +
"</body>   \n" +
"\n" +
"</html> ");
            out.println("");
               if(con1!=null)
            con1.close();
            
   
    }
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
            Logger.getLogger(R.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(R.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(R.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(R.class.getName()).log(Level.SEVERE, null, ex);
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
