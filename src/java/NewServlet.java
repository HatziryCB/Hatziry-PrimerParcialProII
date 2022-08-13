/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import JavaClass.Libros;
import JavaClass.RegistroLibro;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Hatziry Chacón
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    Libros libros;
    RegistroLibro registroLibro;
    Libros[] vector;

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
        try ( PrintWriter out = response.getWriter()) {
            libros = new Libros(
                    Integer.parseInt(request.getParameter("codigo")),
                    request.getParameter("nombre"),
                    request.getParameter("tapa"),
                    request.getParameter("editorial"),
                    Integer.parseInt(request.getParameter("año")));

            if (registroLibro == null) {
                registroLibro = new RegistroLibro();
            }
            registroLibro.almacenar(libros);
            vector = registroLibro.mostrar();
            int iterador = 0;

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>"
                    + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n");
            out.println("<title>Registro Libro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-expand-lg navbar navbar-dark bg-dark\">\n"
                    + "                <a class=\"navbar-brand\" href=\"#\">\n"
                    + "                    <img src=\"https://icon-library.com/images/home-icon-png/home-icon-png-28.jpg\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n"
                    + "                    Home\n"
                    + "                </a>\n"
                    + "                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "                    <span class=\"navbar-toggler-icon\"></span>\n"
                    + "                </button>\n"
                    + "\n"
                    + "                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                    + "                    <ul class=\"navbar-nav mr-auto\">\n"
                    + "                        <li class=\"nav-item active\">\n"
                    + "                            <a class=\"nav-link\" href=\"#\">Link1 <span class=\"sr-only\">(current)</span></a>\n"
                    + "                        </li>\n"
                    + "                        <li class=\"nav-item active\">\n"
                    + "                            <a class=\"nav-link\" href=\"#\">Link2</a>\n"
                    + "                        </li>\n"
                    + "                        <li class=\"nav-item active dropdown\">\n"
                    + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n"
                    + "                                Categorías\n"
                    + "                            </a>\n"
                    + "                            <div class=\"dropdown-menu\">\n"
                    + "                                <a class=\"dropdown-item\" href=\"#\">Action</a>\n"
                    + "                                <a class=\"dropdown-item\" href=\"#\">Another action</a>\n"
                    + "                                <div class=\"dropdown-divider\"></div>\n"
                    + "                                <a class=\"dropdown-item\" href=\"#\">Something else here</a>\n"
                    + "                            </div>\n"
                    + "                        </li>\n"
                    + "                        <li class=\"nav-item active\">\n"
                    + "                            <a class=\"nav-link disabled\">Link3</a>\n"
                    + "                        </li>\n"
                    + "                    </ul>\n"
                    + "                    <form class=\"form-inline my-2 my-lg-0\">\n"
                    + "                        <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Busqueda\" aria-label=\"Search\">\n"
                    + "                        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Buscar</button>\n"
                    + "                    </form>\n"
                    + "                </div>\n"
                    + "            </nav>");
            out.println("<div class=\"mx-auto mt-5\" style=\"width: 600px;\">\n");
            out.println("<div class=\"shadow-lg p-3 mb-5 bg-white rounded\">"
                    + "<h4 class=\"display-4 mt-5 mx-5\">Datos de Usuario</h4>"
                    + "<dl class=\"row my-5 mx-5\">\n"
                    + "  <dt class=\"col-sm-3\">Nombre </dt>\n"
                    + "  <dd class=\"col-sm-9\"> " + libros.getNombre() + "</dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3\">Código</dt>\n"
                    + "  <dd class=\"col-sm-9\">\n"
                    + "    <p>" + libros.getCodigo() + "</p>\n"
                    + "  </dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3\">Tipo de tapa</dt>\n"
                    + "  <dd class=\"col-sm-9\">" + libros.getTapa() + "</dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3 text-truncate\">Editorial</dt>\n"
                    + "  <dd class=\"col-sm-9\">" + libros.getEditorial() + "</dd>\n"
                    + "\n"
                    + "<dt class=\"col-sm-3\">Año</dt>\n"
                    + "  <dd class=\"col-sm-9\">" + libros.getAño() + "</dd>\n"
                    + "<a class=\"btn btn-primary\" href=\"index.html\" role=\"button\">Registrar otro cliente</a>"
                    + "</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
