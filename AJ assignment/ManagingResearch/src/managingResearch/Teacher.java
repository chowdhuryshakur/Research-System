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
public class Teacher {
    private String initial;
    private String name;
    private String status;

    public Teacher(String initial, String name, String status) {
        this.initial = initial;
        this.name = name;
        this.status = status;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    

   
    
    
}
