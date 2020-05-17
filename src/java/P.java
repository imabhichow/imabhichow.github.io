/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/P"})
public class P extends HttpServlet {
    
    private static final String USERNAME1 = "root";
    private static final String PASSWORD1 = "root"; 
    private static final String CONN1 = "jdbc:mysql://localhost:3306/parent";
    

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.jdbc.Driver"); 
        Class.forName("org.postgresql.Driver"); 
        Connection con1;
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con1=DriverManager.getConnection(CONN1,USERNAME1,PASSWORD1);                           //Establishing connection with MySQL
        Statement createst = con1.createStatement(); 
        createst.execute(" create table if not exists profile(profilename varchar(30),host varchar(30),port int(30),data varchar(30)); ");
        ResultSet table = createst.executeQuery("select * from parent.profile");
        
            /* TODO output your page here. You may use following sample code. */
            out.println("");
            out.println("");
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
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
".split {\n" +
"  height: 90%;\n" +
"  width: 50%;\n" +
"  position: fixed;\n" +
"  z-index: 1;\n" +
"  top: 1;\n" +
"  overflow-x: hidden;\n" +
"  padding-top: 20px;\n" +
"}\n" +
"\n" +
"/* Control the left side */\n"  +
".left {\n" +
"  left: 0;\n" +
"  background-color: wheat;\n" +
"}\n" +
".topright {\n" +
"            right: 10%;\n" +
"            top: 10%;\n" +
"             background-color: yellow;\n" +
"        }\n" +

"/* Control the right side */\n" +
".right {\n" +
"  right: 0;\n" +
"  background-color: wheat;\n" +
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
"\n" +
"body {\n" +
"     \n" +
"    margin: 0;\n" +
"    width: 100%;\n" +
"    background-position: align;\n" +
"    background-repeat: repeat;\n" +
"    background-size: auto;\n" +
"}"+ 
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
"</head>\n" +
"\n" +
"<div class=\"tab\" background-image=\"IRONMAN.jpg\">\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"Home\")'>Home</button>\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"P\")'>Profile</button>\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"B\")'>Backup</button>\n" +
"  <button class=\"tablinks\" onclick='window.location.replace(\"R\")'>Restore</button>\n" +
"</div>\n" +
"\n" +
"    \n" +
"    \n" +
"    \n" +
"<!-- Tab content -->\n" +
"\n" +
"    <div class=\"split left\">\n" +
"        <div class=\"centered\" >\n" +
"    <frameset>\n" +
"        <frame backgound-image=\"IRONMAN.jpg\">\n"+ 
"<div class=\"tab\">\n" +
"        <button class=\"tablinks\" onclick=\"openCity(event,'create')\">+ Create Profile</button>\n" +
"            </div>\n" +
"            <div id=\"create\" class=\"tabcontent\">" +
"        <h2>Profile View</h2>\n" +
"        \n" +
"        <form action=\"Profile\" style=\"border:2px solid #ccc\" method=\"post\">\n" +
"            <div class=\"container\">\n" +
"                <h1>Create Profile</h1>\n" +
"                    <p>Please fill in this form to create a profile.</p>\n" +
"                <hr>\n" +
"                <table>\n" +
"                    <tr>\n" +
"                        <td>   <label for=\"profile\"><b>Profile Name</b></label></td> \n" +
"                        <td><input type=\"text\" placeholder=\"Enter Profile Name\" name=\"profile\" required></td> \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"host\"><b>Server Host</b></label></td> \n" +
"                        <td><input type=\"text\" placeholder=\"Host Name\" name=\"host\" required></td> \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"port\"><b>Server Port</b></label></td> \n" +
"                        <td><input type=\"text\" placeholder=\"Port\" name=\"port\" required></td> \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"database\"><b>Database</b></label></td> \n" +
"                        <td><input type=\"text\" placeholder=\"Database\" name=\"database\" required></td> \n" +
"                    </tr>         \n" +
"                </table>\n" +
"            <div class=\"clearfix\">\n" +
"                <button type=\"button\" onclick='window.location.replace(\"P\")' class=\"cancelbtn\">Cancel</button>\n" +
"                <button type=\"submit\" class=\"signupbtn\">Create Profile</button>\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"       </div>     \n" +
"    \n" +
"    </frame>\n" +
"    </frameset>\n" +
"    </div>\n" +
"    </div>\n" +
"    <div class=\"split right\">\n"
                    + "<div class=\"top right\">\n");

                out.println("<tr>");
                //out.println("<td>"+tables.getString(1)+"</td>");
                out.println("<td><div class=\"dropdown\"><button class=\"dropbtn\">Delete Profile</button><div class=\"dropdown-content\">");
                Statement st2=con1.createStatement();
                ResultSet profiles =st2.executeQuery("select * from parent.profile");
                out.println("<a href=\"Del?pro=all"
                                  + "\">"
                                  + "All Profiles"
                                  + "</a>");
                while(profiles.next()){
                          String mod = "<a href=\"Del?pro="
                                  + profiles.getString(1)
                                  + "\">"
                                  + profiles.getString(1)
                                  + "</a>";
                          //System.out.println(mod);
                          out.println(mod);  
                }         
                out.println("</div></div></td></tr>");
            
            
            
            out.println( "</div>" +
"        <div class=\"centered\">\n" +
"            <frameset>\n" +
"                <frame>\n"+"                    <div><h1><b>Profiles List</b></h1></div>\n" );
            //Table View Printing
            out.println();
            out.println("<table border='1'><tr><td><b>Profile</b></td><td><b>Host</b></td><td><b>Port</b></td><td><b>Database</b></td></tr>");
        while (table.next()) {
             out.println("<tr>");
                for (int i = 1; i <= table.getMetaData().getColumnCount(); i++)
                    out.println("<td>"+table.getObject(i)+"</td>");
             out.println("</tr>");     
                
        }
        out.println("</table>");
            
            out.println(
"                </frame>\n" +
"            </frameset>\n" +
"        </div>\n" +
"    </div>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"<script>\n" +
"function openCity(evt, cityName) {\n" +
"  var i, tabcontent, tablinks;\n" +
"  tabcontent = document.getElementsByClassName(\"tabcontent\");\n" +
"  for (i = 0; i < tabcontent.length; i++) {\n" +
"    tabcontent[i].style.display = \"none\";\n" +
"  }\n" +
"  tablinks = document.getElementsByClassName(\"tablinks\");\n" +
"  for (i = 0; i < tablinks.length; i++) {\n" +
"    tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n" +
"  }\n" +
"  document.getElementById(cityName).style.display = \"block\";\n" +
"  evt.currentTarget.className += \" active\";\n" +
"}\n" +
"</script>\n" +
"   \n" +
"\n" +
"</html> \n" +
"");
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
            Logger.getLogger(P.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(P.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(P.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(P.class.getName()).log(Level.SEVERE, null, ex);
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
