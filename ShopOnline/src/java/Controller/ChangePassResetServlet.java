/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.RegistrationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ChangePassResetServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            // Lấy tham số 'linkCreationTime' 
            long linkCreationTime = Long.parseLong(request.getParameter("linkCreationTime"));
            // Kiểm tra thời gian hết hạn của liên kết (2 s)
            long expirationTime = linkCreationTime + (20 * 1000); // 20 s
            // Lấy thời gian hiện tại
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis <= expirationTime) {
                RegistrationDAO dao = new RegistrationDAO();
                String email = request.getParameter("txtmail");
                String password = request.getParameter("pass");
                String rePass = request.getParameter("rePass");
                if (!password.equals(rePass)) {
                    request.setAttribute("mess", "Mật khẩu phải giống nhau !! ");
                    request.getRequestDispatcher("ChangeResetPass.jsp").forward(request, response);
                } else {
                    dao.changePass(email, password);
                    request.setAttribute("mess", "Đặt lại  mật khẩu thành công  !! ");
                    request.getRequestDispatcher("ChangeResetPass.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Liên kết đã hết hạn. Vui lòng yêu cầu đặt lại mật khẩu mới.");
                request.getRequestDispatcher("ErrorPage1.jsp").forward(request, response);
            }
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
        response.sendRedirect("ChangeResetPass.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(ChangePassResetServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePassResetServlet.class.getName()).log(Level.SEVERE, null, ex);
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
