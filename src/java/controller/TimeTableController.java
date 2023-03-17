/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.LecturerDBContext;
import dal.TimeSlotDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Session;
import model.TimeSlot;
import model.User;
import util.DateTimeHelper;

/**
 *
 * @author sonnt
 */
public class TimeTableController extends HttpServlet {

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
        String lid = request.getParameter("lid");
        Date from = Date.valueOf(request.getParameter("from"));
        Date to = Date.valueOf(request.getParameter("to"));
        ArrayList<Date> dates = DateTimeHelper.getListDates(from, to);
        TimeSlotDBContext dbSlot = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = dbSlot.all();
        LecturerDBContext lecDb = new LecturerDBContext();
        ArrayList<Session> sessions = lecDb.getSessions(lid);

        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("sessions", sessions);
        System.out.println(sessions.size());
        request.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lid = request.getParameter("lecturer");
//        Date from = Date.valueOf(request.getParameter("from"));
//        Date to = Date.valueOf(request.getParameter("to"));
    if(lid == null){
        User u = (User)request.getSession().getAttribute("user");
        lid = u.getId();
    }
        Date from, to;
        String year = request.getParameter("year");
        String fromandto = request.getParameter("week");
        if (fromandto == null) {
            from = Date.valueOf("2023-03-06");
            year = from.toString().substring(0,4);
            to = Date.valueOf("2023-03-12");
        } else {
            String[] x = fromandto.split(" ");
            String fromString = year + "-" + x[0];
            String toString = year + "-" + x[1];
            from = Date.valueOf(fromString);
            to = Date.valueOf(toString);
        }
        ArrayList<Date> dates = DateTimeHelper.getListDates(from, to);
        TimeSlotDBContext dbSlot = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = dbSlot.all();
        LecturerDBContext lecDb = new LecturerDBContext();
        ArrayList<Session> sessions = lecDb.getSessions(lid);

        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("sessions", sessions);
        request.setAttribute("lecturer", lid);
        request.setAttribute("year", year);
        request.setAttribute("fromandto", fromandto);
        System.out.println(sessions.size());
        request.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(request, response);
    }
}
