/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Toshiba
 */
public class JobGrade {
    private String gradeLevel;
    private int lowestSalary;
    private int highestSalary;

    public JobGrade(String gradeLevel, int lowestSalary, int highestSalary) {
        this.gradeLevel = gradeLevel;
        this.lowestSalary = lowestSalary;
        this.highestSalary = highestSalary;
    }

    public JobGrade() {
    }
    
    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public int getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(int lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public int getHighestSalary() {
        return highestSalary;
    }

    public void setHighestSalary(int highestSalary) {
        this.highestSalary = highestSalary;
    }
    
    
}
