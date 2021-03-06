/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JobGradeDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.JobGrade;

/**
 *
 * @author Toshiba
 */
public class JobGradeController implements ControllerInterface {

    public JobGradeDAO jgdao;

    public JobGradeController() {
        this.jgdao = new JobGradeDAO();
    }

    @Override
    public boolean insert(Object obj) {
        JobGrade jg = (JobGrade) obj;
        return jgdao.insert(jg);
    }

    public boolean insert(String gradeLevel, int lowSal, int higSal) {
        JobGrade grade = new JobGrade(gradeLevel, lowSal, higSal);
        return jgdao.insert(grade);
    }
    
     public boolean update(String gradeLevel, int lowSal, int higSal) {
        JobGrade grade = new JobGrade(gradeLevel, lowSal, higSal);
        return jgdao.update(grade);
    }

    @Override
    public boolean update(Object obj) {
        JobGrade jg = (JobGrade) obj;
        return jgdao.update(jg);
    }

    @Override
    public boolean delete(String id) {
        return jgdao.delete(id);
    }

    @Override
    public List<Object> search(String category, String cari) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getByGradeLevel(String gl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void bindingALL(JTable table, String[] header) {
        bindingTables(table, header, jgdao.getAllData());
    }

    public void bindingSearch(JTable table, String[] header, String category, String cari) {
        bindingTables(table, header, jgdao.searchAll(category, cari));
    }

    private void bindingTables(JTable table, String[] header, List<JobGrade> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (JobGrade data : datas) {
            Object[] data1 = {
                data.getGradeLevel(),
                data.getLowestSalary(),
                data.getHighestSalary()

            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
    
    
}
