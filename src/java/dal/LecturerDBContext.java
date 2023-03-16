/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendancne;
import model.Course;
import model.Group;
import model.Instructor;
import model.Room;
import model.Session;
import model.TimeSlot;
import util.DateTimeHelper;

/**
 *
 * @author sonnt
 */
public class LecturerDBContext extends DBContext<Instructor> {

    public ArrayList<Attendancne> getSessions(String lid) {
        String sql = "";
        
        ArrayList<Attendancne> sessions = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, lid);
            rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setId(rs.getInt("sessionid"));
                s.setDate(rs.getDate("date"));
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("slotId"));
                t.setSlot(rs.getInt("slotNumber"));
                t.setStart(rs.getTime("startTime"));
                t.setEnd(rs.getTime("endTime"));
                s.setSlot(t);
                Instructor i = new Instructor();
                i.setId(rs.getString("lecturerId"));
                i.setName(rs.getString("instructorName"));
                s.setLecturer(i);
                Group g = new Group();
                g.setId(rs.getInt("groupId"));
                g.setName(rs.getString("groupName"));
                Course c = new Course();
                c.setId(rs.getString("courseId"));
                c.setName(rs.getString("courseName"));
                g.setCourses(c);
                s.setGroup(g);
                Room r = new Room();
                r.setId(rs.getString("roomId"));
                s.setRoom(r);
                if (rs.getString("sessionName") == null ) {
                    s.setName("Take Attend");
                } else if (rs.getString("sessionName") != null) {
                    s.setName(rs.getString("sessionName"));
                }
                sessions.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(sessions.size());
        return sessions;
    }

    @Override
    public void insert(Instructor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Instructor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Instructor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Instructor get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Instructor> all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
