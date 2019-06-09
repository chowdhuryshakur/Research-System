/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managingResearch;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class NotificationController implements Initializable {
private final String DB_USERNAME = "shakur999";
   private final String DB_PASSWORD = "1234";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "managingresearch";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;
   
   @FXML
   private AnchorPane notification;
    @FXML
    private Label setNotification;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
            ArrayList<spass>passList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement();
                String query = "select * from tempspass;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    int sid = resultSet.getInt("sid");
                    String pass = resultSet.getString("pass");
                    spass s = new spass(sid,pass);
                    passList.add(s);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
                
              int t=passList.get(0).getSid(); 
                
        
        ArrayList<StudentApply>applyList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement();
                String query = "select * from studentapply where id="+t+";";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    String chairmanstatus = resultSet.getString("chairmanstatus");
                   StudentApply s = new StudentApply(chairmanstatus);
                   applyList.add(s);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
             
       String n =applyList.get(0).getStatus();
         
         if(n.equals("null"))
          {setNotification.setText("Your application is pending");
          }
       
       
         else if(n.equals("ok"))
          {setNotification.setText("Your application has approved");
            }
          
        
          
          else if(n.equals("not"))
                   setNotification.setText("Your application has not approved");
                   
            }    

    
        
    @FXML
    private void handleLogOutAction(ActionEvent event) throws IOException {
        String query = "delete from tempspass;";
        try{
            Connection connection = DriverManager.getConnection 
                     (DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);}
        catch(SQLException sqle){
            System.err.println(sqle);
        }
          AnchorPane pane =FXMLLoader.load(getClass().getResource("loginPanel.fxml"));
                        notification.getChildren().setAll(pane);
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getResource("stdentPanel.fxml"));
                         notification.getChildren().setAll(pane);
    }
    
}
