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


 
public class seeNonERTeacherController implements Initializable {
   private final String DB_USERNAME = "shakur999";
   private final String DB_PASSWORD = "1234";
   private final String DB_HOSTNAME = "localhost";
   private final String DB_DBNAME = "managingResearch";
   private final String DB_URL = "jdbc:mysql://"+DB_HOSTNAME+"/"+DB_DBNAME;
    
  
    @FXML
    private TableView<StudentApply> resultTable;
    private ObservableList<StudentApply>resultList;
   
    @FXML
    private AnchorPane seeNonERSupervisor;
    @FXML
    private TableColumn<StudentApply, Number> idColumn;
    @FXML
    private TableColumn<StudentApply, String> topicColumn;
    @FXML
    private TableColumn<StudentApply, String> teacherInitialColoumn;
    

    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        query();
   }   
    
    public void query(){         
            ArrayList<StudentApply>ApplyList = new ArrayList<>();
            try{
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement(); 
                String query = "select * from studentapply where status= '"+"null"+"';";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String topic = resultSet.getString("topic");
                    String groupMembers = resultSet.getString("groupmembers");
                    String supervisor = resultSet.getString("supervisor");
                    String status = resultSet.getString("status");
                    String chairmanstatus = resultSet.getString("chairmanstatus");
                    StudentApply applies = new StudentApply(id,topic,groupMembers,supervisor, status,chairmanstatus);                    
                    ApplyList.add(applies);}
                    
                }catch(SQLException sqle){
                System.err.println("sqle");}
                    
    
    
        resultList=FXCollections.observableArrayList();
        resultList.addAll(ApplyList);
        resultTable.setItems(resultList);
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getStudentId()));
        topicColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getResearchTopic()));
        teacherInitialColoumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSupervisor()));}
        
        
    @FXML
    private void handleHomeActionButton(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getResource("chairmanPanel.fxml"));
                         seeNonERSupervisor.getChildren().setAll(pane);
        
    }
    
    
}
