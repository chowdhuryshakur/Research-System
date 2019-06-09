/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managingResearch;

/**
 *
 * @author User
 */
public class RegStudent {
    private int studentId;
    private String semesterId;

    public RegStudent(int studentId, String semesterId) {
        this.studentId = studentId;
        this.semesterId = semesterId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }
    

   
    
    
}
