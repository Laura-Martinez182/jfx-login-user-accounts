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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI {

	//Main pane
	 @FXML
	 private BorderPane mainPane;
	 
	 //login
	 @FXML
	 private TextField txtUsername;

	 @FXML
	 private PasswordField txtPassword;
	 
	 @FXML
	 private Label lbInfo;
	 
	 
	 //Register
	 @FXML
	 private PasswordField txtNewPassword;

	 @FXML
	 private TextField txtNewUsername;

	 @FXML
	 private ChoiceBox<String> cbFavBrowser;

	 @FXML
	 private DatePicker txBirthday;

	 @FXML
	 private ToggleGroup Gender;

	 @FXML
	 private TextField tfProfilePhoto;

	 @FXML
	 private CheckBox cbSoftware;

	 @FXML
	 private CheckBox cbTelematic;

	 @FXML
	 private CheckBox cbIndustrial;
	 	
	 
	 
	 //Account list
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
	  

//Methods login
	  
	  	@FXML
	    public void logIn(ActionEvent event) throws IOException {
		  boolean created = false;
		  for (int i = 0;i<classroom.getUsers().size(); i++) {
			  String username = classroom.getUsers().get(i).getUserName();
			  String password = classroom.getUsers().get(i).getPassword();
			  if(txtUsername.getText().equalsIgnoreCase(username) && txtPassword.getText().equalsIgnoreCase(password)) {
				  created = true;
				  loadAccountList(event);
			  }
		  }
		  if(!created) {
		  logInIncorrectAlert();
		  lbInfo.setText("The account given doesn´t exist");
	  	}
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
	  
	 
	    public void loadAccountList(ActionEvent event) throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
			
			fxmlLoader.setController(this);
			Parent accountListPane = fxmlLoader.load();
	    	
			mainPane.getChildren().clear();
	    	mainPane.setCenter(accountListPane);
	    	initializeTableView();
	    	
	    
	  }
	  
	  
		  
		
	  
	  @FXML
	   public void signUp(ActionEvent event) throws IOException {
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		  
		  fxmlLoader.setController(this);
		  Parent registerPane = fxmlLoader.load();
				  
		  mainPane.getChildren().clear();
		  mainPane.setCenter(registerPane);
		  
		  cbFavBrowser.getItems().add("Google Chrome");
		  cbFavBrowser.getItems().add("Safari");
		  cbFavBrowser.getItems().add("Microsoft Edge");
		  
	  }

	  @FXML
	  public void signIn(ActionEvent event) throws IOException {
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			
			fxmlLoader.setController(this);
			Parent root = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(root);  
	  }
	  
	  @FXML
	  public void browseFiles(ActionEvent event) {
		  FileChooser fileChooser = new FileChooser();
		  fileChooser.setTitle("Search Picture");
		  tfProfilePhoto.setText(fileChooser.showOpenDialog(null).getName());
	  }

	  //Alerts
	  
	  public void logInIncorrectAlert() {
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setHeaderText("Log in incorrect");
		  alert.setContentText("The username and password given are incorrect");
		  alert.showAndWait();
	  }
	  
	  
}
