/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.RegistrationDAO;
import Model.RegistrationDTO;
import Model.SendMail;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.mail.MessagingException;

/**
 *
 * @author ADMIN
 */
public class SignUpController extends HttpServlet {

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
            throws ServletException, IOException, MessagingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String account = request.getParameter("acc");
        String password = request.getParameter("pass");
        String rePass = request.getParameter("repass");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        SendMail sm = new SendMail();
        RegistrationDTO user = new RegistrationDTO(account);

        String emailPattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        boolean isEmailValid = Pattern.matches(emailPattern, account);

        if (!isEmailValid) {
            request.setAttribute("mess", "Invalid email format !! Ex : example@example.com ");
            request.getRequestDispatcher("signUP.jsp").forward(request, response);
        } else if (!password.equals(rePass)) {
            request.setAttribute("mess", "Nhập lại mật khẩu không giống nhau");
            request.getRequestDispatcher("signUP.jsp").forward(request, response);
        } else if (password.length() < 6) {
            request.setAttribute("mess", "Password must be at least 6 characters long");
            request.getRequestDispatcher("signUP.jsp").forward(request, response);
        } else if (!phone.matches("[0-9]*")) {
            request.setAttribute("mess", "Your Mobile Invalid");
            request.getRequestDispatcher("signUP.jsp").forward(request, response);
        } else {
            RegistrationDAO dao = new RegistrationDAO();
            boolean test = sm.sendEmailRegister(account);
            if (dao.checkAcountExist(account)) {
                request.setAttribute("mess", "Email exist !!!");
                request.getRequestDispatcher("signUP.jsp").forward(request, response);
            } else {
                if (test) {
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", account);
                    session.setAttribute("pass", password);
                    session.setAttribute("fullName", fullname);
                    session.setAttribute("phone", phone);
                    session.setAttribute("address", address);

                    request.setAttribute("mess", "Check your mail!! ");
                    request.getRequestDispatcher("signUP.jsp").forward(request, response);

                } else {
                    //  logger.log(Level.SEVERE, "Email sending failed.");
                    request.setAttribute("mess", "Khong tim thay gmail!! ");
                    request.getRequestDispatcher("signUP.jsp").forward(request, response);
                }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (MessagingException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
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
