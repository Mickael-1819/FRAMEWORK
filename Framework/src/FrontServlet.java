package etu1819.framework.servlet;

import etu1819.framework.Mapping;
import etu1819.framework.ModelView;
import etu1819.utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

public class FrontServlet extends HttpServlet {

    HashMap<String, Mapping> mappingUrls;   // liste des methodes annotees avec leurs classes
                                            // <l'annotation et le Mapping correspondant>
    String context;

    public void init() throws ServletException {
        try {
            this.context = this.getInitParameter("context");
            String p = "";
            this.mappingUrls = Utils.getUrlsAnnotedMethods(Utils.getClasses(null, p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            PrintWriter out = res.getWriter();
            
            out.println("BIENVENUE");
            String url = req.getRequestURL().toString();
            String slug = Utils.getPathFromURL(url, this.context);
            out.println("URL: " + url);
            out.println("slug: " + slug);

            for (Map.Entry<String, Mapping> entry : this.mappingUrls.entrySet()) {
                out.println("Annotation: " + entry.getKey() + "\tMethode : " + entry.getValue().getMethod() + "\tClasse: " + entry.getValue().getClassName());
            }

            Mapping map = this.mappingUrls.get(slug);
            if (map == null)
                out.println("Annotation inconnue");
            else {
                ModelView mv = Utils.getModelView(map);
                System.out.println("VUE:" + mv.getView());
                RequestDispatcher dispat = req.getRequestDispatcher(mv.getView());
                dispat.forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }
}

