/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/Dummy"})
public class Dummy extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
"/* Control the left side */\n" +
".left {\n" +
"  left: 0;\n" +
"  background-color: graytext;\n" +
"}\n" +
"\n" +
"/* Control the right side */\n" +
".right {\n" +
"  right: 0;\n" +
"  background-color: whitesmoke;\n" +
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
"</style>\n" +
"</head>\n" +
"\n" +
"<div class=\"tab\">\n" +
"  <button class=\"tablinks\" onclick=\"openCity(event, 'Profile')\">Profile</button>\n" +
"  <button class=\"tablinks\" onclick=\"openCity(event, 'Backup')\">Backup</button>\n" +
"  <button class=\"tablinks\" onclick=\"openCity(event, 'Restore')\">Restore</button>\n" +
"</div>\n" +
"\n" +
"    \n" +
"    \n" +
"    \n" +
"<!-- Tab content -->\n" +
"<div id=\"Profile\" class=\"tabcontent\">\n" +
"    <div class=\"split left\">\n" +
"        <div class=\"centered\" >\n" +
"    <frameset>\n" +
"        <frame>\n" +
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
"                <button type=\"button\" class=\"cancelbtn\">Cancel</button>\n" +
"                <button type=\"submit\" class=\"signupbtn\">Create Profile</button>\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"            \n" +
"    \n" +
"    </frame>\n" +
"    </frameset>\n" +
"    </div>\n" +
"    </div>\n" +
"    <div class=\"split right\">\n" +
"        <div class=\"centered\">\n" +
"            <frameset>\n" +
"                <frame>\n" +
"                    <div>Table Profile</div>\n" +
"                </frame>\n" +
"            </frameset>\n" +
"        </div>\n" +
"    </div>\n" +
"</div>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"<div id=\"Backup\" class=\"tabcontent\">\n" +
"    <div class=\"split left\">\n" +
"        <div class=\"centered\" >\n" +
"    <frameset>\n" +
"        <frame>\n" +
"        <h2>Backup Config View</h2>\n" +
"        \n" +
"        <form action=\"Backup\" style=\"border:2px solid #ccc\" method=\"post\">\n" +
"            <div class=\"container\">\n" +
"                <h1>Create Backup Schedule</h1>\n" +
"                    <p>Please fill in this form to create a schedule.</p>\n" +
"                <hr>\n" +
"                <table>\n" +
"                    <tr>\n" +
"                        <td>   <label for=\"Backupname\"><b>Backup Schedule</b></label></td> \n" +
"                        <td><input type=\"text\" placeholder=\"Enter Schedule Name\" name=\"Backupname\" required></td> \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"Interval\"><b>Server Host</b></label></td> \n" +
"                        <td><input type=\"text\" placeholder=\"Frequency limit(in mins)\" name=\"Interval\" required></td> \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"size\"><b>Server Port</b></label></td> \n" +
"                        <td><input type=\"text\" placeholder=\"Backups Limit\" name=\"size\" required></td> \n" +
"                    </tr>         \n" +
"                </table>\n" +
"            <div class=\"clearfix\">\n" +
"                <button type=\"button\" class=\"cancelbtn\">Cancel</button>\n" +
"                <button type=\"submit\" class=\"signupbtn\">Create Profile</button>\n" +
"            </div>\n" +
"        </div>\n" +
"        </form>\n" +
"            \n" +
"    \n" +
"    </frame>\n" +
"    </frameset>\n" +
"    </div>\n" +
"    </div>\n" +
"    <div class=\"split right\">\n" +
"        <div class=\"centered\">\n" +
"            <frameset>\n" +
"                <frame>\n" +
"                    <div>Table Backups</div>\n" +
"                </frame>\n" +
"            </frameset>\n" +
"        </div>\n" +
"    </div>  \n" +
"</div>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"<div id=\"Restore\" class=\"tabcontent\">\n" +
"  \n" +
"</div>\n" +
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
        processRequest(request, response);
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
        processRequest(request, response);
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
