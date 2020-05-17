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
@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
"  background-color: #ccc;\n" +
"  overflow: hidden;\n" +
"  border: 0.5px solid #ccc;\n" +
"\n" +
"}\n" +
"\n" +
"/* Style the buttons inside the tab */\n" +
".tab button {\n" +
"\n" +
"  float: left;\n" +
"  background-color: #ccc;\n" +
" \n" +
"  border: 0.5px #ccc;\n" +
"  outline: none;\n" +
"  cursor: pointer;\n" +
"  padding: 14px 16px;\n" +
"  transition: 0.3s;\n" +
"  font-size: 17px;\n" +
"}\n" +
"\n" +
"/* Change background color of buttons on hover */\n" +
".tab button:hover {\n" +
"  background-color: inherit;\n" +
" \n" +
"}\n" +
"\n" +
"/* Create an active/current tablink class */\n" +
".tab button.active {\n" +
"  background-color: inherit;\n" +
"  \n" +
"}\n" +
"\n" +
"/* Style the tab content */\n" +
".tabcontent {\n" +
"  display: none;\n" +
"  padding: 6px 12px;\n" +
" \n" +
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
"body {\n" +
"    background-image: url(\"IRONMAN.jpg\");\n" +
"     \n" +
"    margin: 0;\n" +
"    width: 100%;\n" +
"    background-position: align;\n" +
"    background-repeat: repeat;\n" +
"    background-size: auto;\n" +
"}\n" +
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
"<body >\n" +
"\n" +
"    <div class=\"body\">\n" +
"<div class=\"tab\" >\n" +
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
"<div class=\"top\">\n" +
"    <h1></h1>\n" +
"</div>\n" +
"</div>\n" +
"\n" +
"</body>\n" +
"\n" +
"\n" +
"\n" +
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
