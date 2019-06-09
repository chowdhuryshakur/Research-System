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
public class tpass {
    private String tinitial;
    private String pass;

    public tpass(String tinitial, String pass) {
        this.tinitial = tinitial;
        this.pass = pass;
    }

    public tpass(String tinitial) {
        this.tinitial = tinitial;
    }

    
    public String getTinitial() {
        return tinitial;
    }

    public String getPass() {
        return pass;
    }
    
    
    
}
