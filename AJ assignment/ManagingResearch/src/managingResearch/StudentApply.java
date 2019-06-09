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
public class StudentApply {
    private int studentId;
    private String researchTopic;
    private String groupMembers;
    private String supervisor;        
    private String status;
    private String chairmanStatus;

    public StudentApply(int studentId, String researchTopic, String groupMembers, String supervisor, String status, String chairmanStatus) {
        this.studentId = studentId;
        this.researchTopic = researchTopic;
        this.groupMembers = groupMembers;
        this.supervisor = supervisor;
        this.status = status;
        this.chairmanStatus = chairmanStatus;
    }

    public String getChairmanStatus() {
        return chairmanStatus;
    }

    public StudentApply(int studentId) {
        this.studentId = studentId;
    }

    public StudentApply(String status) {
        this.status = status;
    }

    public StudentApply(int studentId, String researchTopic, String groupMembers, String status) {
        this.studentId = studentId;
        this.researchTopic = researchTopic;
        this.groupMembers = groupMembers;
        this.status = status;
    }
    
    



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public String getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(String groupMembers) {
        this.groupMembers = groupMembers;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return "StudentApply{" + "status=" + status + '}';
    }
    
    
    
    
}

