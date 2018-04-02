/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import latihanojdbc.Koneksi;
import model.JobGrade;

/**
 *
 * @author Toshiba
 */
public class JobGradeDAO {

    public Connection kon;

    public JobGradeDAO() {
        this.kon = new Koneksi().getKoneksi();
    }

    /**
     * Fungsi untuk melihat semua data JobGrades
     *
     * @return List semua data JobGrade
     */

    public List<JobGrade> getAllData() {
//        List<JobGrade> datas = new ArrayList<>();
//        try {
//            PreparedStatement pst = kon.prepareStatement("select * from HR.JOB_GRADES");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
////            JobGrade jd = new JobGrade();
//                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"), rs.getInt("highest_sal"));
////            jd.setGradeLevel(rs.getString("grade_level"));
////            jd.setLowestSalary(rs.getInt("lowest_sal"));
////            jd.setHighestSalary(rs.getInt("higest_sal"));
//                datas.add(jd);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return datas;
          return getData("");

    }
    public JobGrade getByGradeLevel(String gradeLevel){
        return getData("where grade_level = '"+gradeLevel+"'").get(0);
    }
    /**
     * Fungsi untuk mencari semua data JobGrades sesuai dengan parameter yang
     * dimasukkan atau diinputkan
     *
     * @return List semua data JobGrade
     */
    public List<JobGrade> searchAll(String category, String cari){
//        List<JobGrade> datas = new ArrayList<>();
//        try {
//            PreparedStatement pst = kon.prepareStatement("select * from HR.JOB_GRADES"
//                    + " where grade_level like '%" + cari + "%'"
//                    + " or lowest_sal like '%" + cari + "%'"
//                    + " or highest_sal like '%" + cari + "%'");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"), rs.getInt("highest_sal"));
//                datas.add(jd);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return datas;
          return getData("where "+category+" like '%"+cari+"%'");

    }
    
    
      public List<JobGrade> getData(String query) {
          List<JobGrade> datas = new ArrayList<>();
        try {
            PreparedStatement pst = kon.prepareStatement("select * from JOB_GRADES "+query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"), rs.getInt("highest_sal"));
                datas.add(jd);

            }
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
      }
    
      public boolean insert(JobGrade jobGrade){
        try {
            PreparedStatement pst = kon.prepareStatement("insert into JOB_GRADES values(?,?,?)");
            pst.setString(1, jobGrade.getGradeLevel());
            pst.setInt(2, jobGrade.getLowestSalary());
            pst.setInt(3, jobGrade.getHighestSalary());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return false;
      }
    
        public boolean update(JobGrade jobGrade){
        try {
            PreparedStatement pst = kon.prepareStatement("update JOB_GRADES set lowest_sal=?, highest_sal=?"
                    + " where grade_level=?");
            pst.setString(3, jobGrade.getGradeLevel());
            pst.setInt(1, jobGrade.getLowestSalary());
            pst.setInt(2, jobGrade.getHighestSalary());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return false;
      }
        
        public boolean delete(String gradeLevel){
        try {
            PreparedStatement pst = kon.prepareStatement("delete from JOB_GRADES where grade_level=?");
            pst.setString(1, gradeLevel);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return false;
      }
}
