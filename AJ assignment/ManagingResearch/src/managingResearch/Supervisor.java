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
public class Supervisor {
    private String initial;
    private Integer superVisorCount;

    public Supervisor(String initial, Integer superVisorCount) {
        this.initial = initial;
        this.superVisorCount = superVisorCount;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public Integer getSuperVisorCount() {
        return superVisorCount;
    }

    public void setSuperVisorCount(Integer superVisorCount) {
        this.superVisorCount = superVisorCount;
    }
    
    
}
