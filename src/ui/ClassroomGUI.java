package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	  
	  public void loadLogin() throws IOException {
		  	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			
			fxmlLoader.setController(this);
			Parent root = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(root);
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
	  
	  @FXML
	    public void loadAccountList(ActionEvent event) throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
			
			fxmlLoader.setController(this);
			Parent accountListPane = fxmlLoader.load();
	    	
			mainPane.getChildren().clear();
	    	mainPane.setCenter(accountListPane);
	    	initializeTableView();
	  }
	  
	  //Methods login
	  
	  @FXML
	    public void logIn(ActionEvent event) {
		  //SI EL USER ESTA MAL LLAMAR ALERTA, SINO QUE CARGUE LA LISTA CON LA INFO
		  
		  logInIncorrectAlert();
		  
		  
	  
	  }
	  
	  @FXML
	   public void signUp(ActionEvent event) {
		  
		  

	  }

	 
	  //Alerts
	  
	  public void logInIncorrectAlert() {
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setHeaderText("Log in incorrect");
		  alert.setContentText("The username and password given are incorrect");
		  alert.showAndWait();
	  }
}
