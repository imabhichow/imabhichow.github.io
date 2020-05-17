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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/Backup"})
public class Backup extends HttpServlet implements SingleThreadModel {
    private static final String USERNAME1 = "root";
    private static final String PASSWORD1 = "root"; 
    private static final String CONN1 = "jdbc:mysql://localhost:3306/";
    private final ReentrantLock lock = new ReentrantLock();    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InterruptedException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ,ClassNotFoundException, SQLException, InterruptedException {
        if(lock.isHeldByCurrentThread())
            lock.unlock();
        lock.lock();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Class.forName("com.mysql.jdbc.Driver"); 
        Class.forName("org.postgresql.Driver"); 
        Connection con1;
        RequestDispatcher r;
        r = request.getRequestDispatcher("B");
        r.forward(request, response);
        int interval = 1;
        if(!(request.getParameter("interval")==null||request.getParameter("interval").equals("null")))
            interval = Integer.parseInt(request.getParameter("interval"));
        int size = 3;
        if(!(request.getParameter("size")==null||request.getParameter("size").equals("null")))
            size = Integer.parseInt(request.getParameter("size"));
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con1=DriverManager.getConnection(CONN1,USERNAME1,PASSWORD1);                           //Establishing connection with MySQL
        Statement createst = con1.createStatement();
        createst.execute("insert into parent.schedule values('"+request.getParameter("Backupname")+"','"+request.getParameter("interval")+"','"+request.getParameter("size")+"')");
        //createst.execute("  drop database backups");
        
        createst.execute(" create database if not exists "+request.getParameter("Backupname"));
        System.out.println("Interval:"+interval+" --"+request.getParameter("interval")+"-----Size: "+ size+"--"+request.getParameter("size"));
        for(int i=0;i<size;i++){
        
            String time=new Timestamp( new java.util.Date().getTime()).toString().replaceAll("[ :'.-]", "_");
            createst.executeUpdate(" create table "+request.getParameter("Backupname")+".backup"+time+i+" as (select * from parent.profile)");
            TimeUnit.MINUTES.sleep(interval);
        
        }
        con1.close();
        int i=0;
        while(true){
            
            System.out.println("BACKUP ---- "+i++ );
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con1=DriverManager.getConnection(CONN1,USERNAME1,PASSWORD1);     
        
        //
            Statement s = con1.createStatement();
            s.execute("use "+request.getParameter("Backupname"));
            ResultSet backups = s.executeQuery("show tables");
            if(backups.next()){
                Statement m = con1.createStatement();
                m.execute("drop table "+backups.getString(1));
                System.out.println("Table succesfully dropped");
                String time=new Timestamp( new java.util.Date().getTime()).toString().replaceAll("[ :'.-]", "_");
                m.execute(" create table if not exists parent.profile(profilename varchar(30),host varchar(30), port int, data varchar(30))");
                m.executeUpdate(" create table "+request.getParameter("Backupname")+".backup"+time+" as (select * from parent.profile)");
                TimeUnit.MINUTES.sleep(interval);
        }
        con1.close();


        System.out.println("This won't be executed");
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
            Backup b = new Backup();
            b.init();
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException | InterruptedException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
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
            Backup b = new Backup();
            b.init();
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException | InterruptedException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
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
