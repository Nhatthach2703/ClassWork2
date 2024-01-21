/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xuan Vinh
 */
public class StudentServlet2 extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet2 at " + request.getContextPath() + "</h1>");
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
    private List<Student> studentList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        if (studentList == null) {
            studentList = new ArrayList<>();
        }
        int numberOfStudents = Integer.parseInt(request.getParameter("numberOfStudents"));

        for (int i = 1; i <= numberOfStudents; i++) {
            String randomName = getRandomName();
            Date randomBirthDate = getRandomBirthDate();
            Student student = new Student(i, randomName, i % 2 == 0, randomBirthDate);
            studentList.add(student);
        }
        request.setAttribute("data", studentList);
        request.getRequestDispatcher("student2.jsp").forward(request, response);
        studentList.clear();
    }
    private String getRandomName() {
        Random random = new Random();
        StringBuilder randomName = new StringBuilder();
        int nameLength = 6; // Độ dài tên ngẫu nhiên

        for (int i = 0; i < nameLength; i++) {
            char randomChar = (char) ('a' + random.nextInt(26));
            randomName.append(randomChar);
        }

        return randomName.toString();
    }

    private Date getRandomBirthDate() {
        Random random = new Random();
        long millisInDay = 24 * 60 * 60 * 1000;
        long randomMillis = random.nextLong() % (365 * millisInDay); // Ngày sinh ngẫu nhiên trong vòng một năm
        return new Date(System.currentTimeMillis() - randomMillis);
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
