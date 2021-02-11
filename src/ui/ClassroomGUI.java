package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {

	 @FXML
	 private BorderPane mainPane;
	    
	 @FXML
	 private TextField txtUsername;

	 @FXML
	 private PasswordField txtPassword;
	 
	 @FXML
	 private TableView<UserAccount> tvUserList;

	 @FXML
	 private TableColumn<UserAccount, String> tcUsername;

	 @FXML
	 private TableColumn<UserAccount, String> tcGender;

	 @FXML
	 private TableColumn<UserAccount, String> tcCareer;

	 @FXML
	 private TableColumn<UserAccount, String> tcBirthday;

	 @FXML
	 private TableColumn<UserAccount, String> tcBrowser;


	
	 private Classroom classroom;

	  public ClassroomGUI(Classroom cl) {
	    	classroom = cl;    	
	  	}

	  public void initialize() {
	    	
	  }
	  
	  
	  private void initializeTableView() {
	    	ObservableList<UserAccount> observableList;
	    	observableList = FXCollections.observableArrayList(classroom.getUsers());
	    	
			tvUserList.setItems(observableList);
			tcUsername.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("username")); //the tableview search for a method called getUser
			tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender")); //the tableview search for a method called getEmail
			tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("career"));
			tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("birthday"));
			tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("browser"));
	  
	  }
	  
	  

}
