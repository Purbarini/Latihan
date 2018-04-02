/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanojdbc;

import dao.JobGradeDAO;
import java.util.List;
import model.JobGrade;

/**
 *
 * @author Toshiba
 */
public class LatihanOJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(new Koneksi().getKoneksi());
//        System.out.println(new JobGradeDAO().getAllData().size());

        List<JobGrade> datas = new JobGradeDAO().searchAll("lowest_sal", "1000");
        datas.forEach(x -> System.out.println(x.getGradeLevel() + " mempunyai gaji tertinggi : "
                + x.getHighestSalary() + " dan gaji terendah " + x.getLowestSalary()));
        System.out.println("");
        datas = new JobGradeDAO().getAllData();
//        JobGrade jg = new JobGradeDAO().getByGradeLevel("A");
//        System.out.println(jg.getLowestSalary());
//        System.out.println("");
        JobGrade in = new JobGrade();
        in.setGradeLevel("H");
        in.setHighestSalary(9000);
        in.setLowestSalary(1500);
        System.out.println(new JobGradeDAO().insert(in));
//        System.out.println("");
//        JobGrade up = new JobGrade("H", 9000, 1500);
//        System.out.println(new JobGradeDAO().update(up));
//        System.out.println("");
//        JobGradeDAO del = new JobGradeDAO();
//        System.out.println(del.delete("A"));
        
     //        for (int i = 0; i < datas.size(); i++) {
//            System.out.println(datas.get(i).getGradeLevel() + " mempunyai gaji tertinggi :"
//                    + datas.get(i).getHighestSalary());
//
//        }
//        System.out.println("");
//        System.out.println("dengan for each/forex");
//        datas.forEach(x -> System.out.println(x.getGradeLevel() + " mempunyai gaji tertinggi : "
//                + x.getHighestSalary()));
//        System.out.println("");
//        System.out.println("dengan fore");
//        for (JobGrade data : datas) {
//            System.out.println(data.getGradeLevel() + " mempunyai gaji tertinggi :"
//                    + data.getHighestSalary());
//        }
//
//        System.out.println("--------------------------------");
//        System.out.println("");
//        List<JobGrade> cr = new JobGradeDAO().searchAll("14999");
//        for (int i = 0; i < cr.size(); i++) {
//            System.out.println(cr.get(i).getGradeLevel() + " mempunyai gaji tertinggi :"
//                    + cr.get(i).getHighestSalary());
//        }
    }
}
