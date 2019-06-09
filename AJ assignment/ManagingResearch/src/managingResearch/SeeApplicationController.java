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
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


 
public class SeeApplicationController implements Initializable {
   private final String DB_USERNAME = "shakur999";
   private final String DB_PASSWORD = "1234";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "managingResearch";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;
    
  
    @FXML
    private TableView<StudentApply> resultTable;
    private ObservableList<StudentApply>resultList;
   
    @FXML
    private AnchorPane seeApplication;
    @FXML
    private TableColumn<StudentApply, Number> idColumn;
    @FXML
    private TableColumn<StudentApply, String> topicColumn;
    @FXML
    private TableColumn<StudentApply, String> groupMemColoumn;
    @FXML
    private TextField sIdField;
    @FXML
    private Label notification;

    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        query();
   }   
    
    public void query()
        {ArrayList<tpass>tpassList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement();
                String query = "select * from temptpass;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    String tin = resultSet.getString("tin");
                   tpass t = new tpass(tin);
                   tpassList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        String tp = tpassList.get(0).getTinitial();
            
            ArrayList<StudentApply>ApplyList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement(); 
                String query = "select * from studentapply where supervisor='"+tp+"';";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String topic = resultSet.getString("topic");
                    String groupMem = resultSet.getString("groupmembers");
                    String status = resultSet.getString("status");
                    StudentApply applies = new StudentApply(id,topic,groupMem, status);
                    if(applies.getStatus().equals("null"))
                    { ApplyList.add(applies);}
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
            
    
    
        resultList=FXCollections.observableArrayList();
        resultList.addAll(ApplyList);
        resultTable.setItems(resultList);
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getStudentId()));
        topicColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getResearchTopic()));
        groupMemColoumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGroupMembers()));}
        
        
    @FXML
    private void handleHomeActionButton(ActionEvent event) throws IOException {
        ArrayList<tpass>tpassList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement();
                String query = "select * from temptpass;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    String tin = resultSet.getString("tin");
                   tpass t = new tpass(tin);
                   tpassList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        String tp = tpassList.get(0).getTinitial();
        if(tp.equals("SM"))
        {AnchorPane pane =FXMLLoader.load(getClass().getResource("chairmanPanel.fxml"));
                         seeApplication.getChildren().setAll(pane);}
        else                 
        {AnchorPane pane =FXMLLoader.load(getClass().getResource("teacherPanel.fxml"));
                         seeApplication.getChildren().setAll(pane);}
    }

    @FXML
    private void handleEndorseButtonAction(ActionEvent event) {
        ArrayList<tpass>tpassList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement();
                String query = "select * from temptpass;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    String tin = resultSet.getString("tin");
                   tpass t = new tpass(tin);
                   tpassList.add(t);
                    }
                }catch(SQLException sqle){
                System.err.println("sqle");}
        String tp = tpassList.get(0).getTinitial();
            
            ArrayList<StudentApply>ApplyList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement(); 
                String query = "select * from studentapply where supervisor='"+tp+"' and status='"+"ok"+"';";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String topic = resultSet.getString("topic");
                    String groupMem = resultSet.getString("groupmembers");
                    String status = resultSet.getString("status");
                    StudentApply applies = new StudentApply(id,topic,groupMem, status);                    
                    ApplyList.add(applies);}
                    
                }catch(SQLException sqle){
                System.err.println("sqle");}
        
        
        if(ApplyList.size()<7)
               { Integer id = Integer.parseInt(sIdField.getText());
        String query = "update studentapply set status ='"+"ok"+"' where id = "+id+";";
        try{
            Connection connection = DriverManager.getConnection 
                     (DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);}
        catch(SQLException sqle){
            System.err.println(sqle);
    }
        sIdField.clear();
        query();
        notification.setText("Successfully endorsed!");}
        
        else
            notification.setText("You can not supervise more than 7 team.");
   }
    @FXML
    private void handleRejectButtonAction(ActionEvent event) {
        Integer id = Integer.parseInt(sIdField.getText());
        String query = "update studentapply set status ='"+"not"+"' where id = "+id+";";
        try{
            Connection connection = DriverManager.getConnection 
                     (DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);}
        catch(SQLException sqle){
            System.err.println(sqle);
    }
        sIdField.clear();
        query();
        notification.setText("Successfully rejected!");
    }
    
    
}
