package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out=res.getWriter();
        String metodoHttp=req.getMethod();
        String uri=req.getRequestURI();
        out.print("<html><head><title>Resultado servlet</title></head><body><h1>Datos</h1>");
        out.print("Metodo HTTP: "+metodoHttp+"<br>");
        out.print("URI solicitada: "+uri+"<br>");
        Enumeration cabeceras=req.getHeaderNames();
        String nombreCabecera;
        while(cabeceras.hasMoreElements()){
            nombreCabecera=cabeceras.nextElement().toString();
            out.print("<b>"+nombreCabecera+": </b>"+req.getHeader(nombreCabecera)+"<br>");
        }
        out.print("</body></html>");
        out.close();
    }
}