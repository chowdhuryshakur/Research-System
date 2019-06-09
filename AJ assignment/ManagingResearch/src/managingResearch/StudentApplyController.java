/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managingResearch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author User
 */
public class StudentApplyController implements Initializable {
     private final String DB_USERNAME = "shakur999";
   private final String DB_PASSWORD = "1234";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "managingresearch";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;

    @FXML
    private AnchorPane takenCourse;
    @FXML
    private TextField idField;
    @FXML
    private TextField topicField;
    @FXML
    private TextField memIdField;
    @FXML
    private TextField supInitialField;
    @FXML
    private Label notification;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
private void insertResearchApply(StudentApply apply){
        int id = apply.getStudentId();
        String topic = apply.getResearchTopic();
        String groupmembers = apply.getGroupMembers();
        String supervisor = apply.getSupervisor();
        String status = apply.getStatus();
        String chairmanstatus = apply.getChairmanStatus();
        
       String query = "insert into studentapply values("+id+",'"+topic+"','"+groupmembers+"','"+supervisor+"','"+status+"','"+chairmanstatus+"');";
        try{
            Connection connection = DriverManager.getConnection 
                     (DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);}
        catch(SQLException sqle){
            System.err.println(sqle);
        }
    }
    @FXML
    private boolean handleApplyButtonAction(ActionEvent event) {
    int studentId = Integer.parseInt(idField.getText());
    String topic = topicField.getText();
    String groupmembers = memIdField.getText();
    String supervisor = supInitialField.getText();
    String status = "null";
    String chairmanstatus = "null";
       
        
         ArrayList<StudentApply>applyList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement();
                String query = "select * from studentapply;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    int sid = resultSet.getInt("id");
                   StudentApply s = new StudentApply(sid);
                   applyList.add(s);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        
        
        for(int i=0; i<applyList.size();i++)
        {   if(studentId==applyList.get(i).getStudentId())
                   {notification.setText("You have already applied.");
                   return false;
                   }
                   }
         
        StudentApply applies = new StudentApply(studentId, topic, groupmembers,supervisor,status,chairmanstatus );
        insertResearchApply(applies);
        notification.setText("Successfully saved");
        
        idField.clear();
        topicField.clear();
        memIdField.clear();
        supInitialField.clear();
         
        return false;
        
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
                        takenCourse.getChildren().setAll(pane);
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getResource("stdentPanel.fxml"));
                         takenCourse.getChildren().setAll(pane);
    }
    
}
