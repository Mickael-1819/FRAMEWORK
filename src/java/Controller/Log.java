/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import model.Utilitaire;

/**
 *
 * @author gaiden
 */
public class Log extends HttpServlet{
    
@Override
public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException{
res.setContentType("text/html");
PrintWriter pwriter=res.getWriter();
pwriter.print("<html>");
pwriter.print("<body>");
pwriter.print("<h2>URL MAPPING  Servlet </h2>");
String show = Utilitaire.getURLWithContextPath((HttpServletRequest) req);
pwriter.print(show);
pwriter.print("</body>");
pwriter.print("</html>");
}
}
