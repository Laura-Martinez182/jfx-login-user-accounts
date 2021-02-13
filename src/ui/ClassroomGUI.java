package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	 private RadioButton femaleOption;
	 
	 @FXML
	 private RadioButton maleOption;

	 @FXML
	 private RadioButton otherOption;

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
	 
	 @FXML
	 private ImageView picture;
	 	
	 
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

	 @FXML
	 private Label lbActualUser;

	
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
			  String username = classroom.getUsers().get(i).getUsername();
			  String password = classroom.getUsers().get(i).getPassword();
			  if(txtUsername.getText().equalsIgnoreCase(username) && txtPassword.getText().equalsIgnoreCase(password)) {
				  created = true;
				  loadAccountList(event, username);
				  lbActualUser.setText(username);
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
			tcUsername.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("username")); 
			tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender")); 
			tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("career"));
			tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("birthday"));
			tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("browser"));
	  
	  }
	  
	 
	    public void loadAccountList(ActionEvent event, String username) throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
			
			fxmlLoader.setController(this);
			Parent accountListPane = fxmlLoader.load();
	    	
			mainPane.getChildren().clear();
	    	mainPane.setCenter(accountListPane);
	    	initializeTableView();
	    	searchUsername(username);
	    	
	  }
	  
	    public void searchUsername(String username) {
	    	
	    	for(int i = 0; i<classroom.getUsers().size(); i++) {
	    		if(username.equals(classroom.getUsers().get(i).getUsername())) {
	    			
	    		 picture.setImage(classroom.getUsers().get(i).getPicture());
	    		 
	    		 i = classroom.getUsers().size();
	    		
	    		}
	    		
	    	}
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
	   public void logOut(ActionEvent event) throws IOException {
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		  
		  fxmlLoader.setController(this);
		  Parent loginPane = fxmlLoader.load();
				  
		  mainPane.getChildren().clear();
		  mainPane.setCenter(loginPane);
	  }

	  
	  //Methods register
	  
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
		  tfProfilePhoto.setText(fileChooser.showOpenDialog(null).getAbsolutePath());
	  }
	  
	  @FXML
	  public void createAccount(ActionEvent event) throws FileNotFoundException {
		  String career = getCareerChoosen(); 
		  String gender = getGenderChoosen();
		  LocalDate birthday = txBirthday.getValue();
		  String browser = cbFavBrowser.getValue();
		  Image picture = new Image(new FileInputStream(tfProfilePhoto.getText()));
		  classroom.addUsers(txtNewUsername.getText(), txtNewPassword.getText(), picture, gender, career, birthday, browser);
		  txtNewUsername.setText("");
		  txtNewPassword.setText("");
		  tfProfilePhoto.setText("");
		  txBirthday.setValue(null);
		  accountCreatedAlert();
		 
	  } 
	  
	  
	  public String getGenderChoosen() {
		  String gender = " ";
		  if(femaleOption.isSelected()) {
			  gender = femaleOption.getText();
		  }
		  if(maleOption.isSelected()) {
			  gender = maleOption.getText();
		  }
		  if(otherOption.isSelected()) {
			  gender = otherOption.getText();
		  }
		  return gender;
	  }
	  
	  
	  public String getCareerChoosen() {
		String career [] = new String[3];
		if(cbSoftware.isSelected()) {
			career[0] = "Software Engeenering";
			cbSoftware.setSelected(false);
		}
		if(cbTelematic.isSelected()) {
			career[1] = "Telematic Engeenering";
			cbTelematic.setSelected(false);
		}
		if(cbIndustrial.isSelected()) {
			career[2] = "Industrial Engeenering";
			cbIndustrial.setSelected(false);
		}
		
        String newCareer = "";
		for(int i = 0; i<career.length; i++) {
			if(career[i]!=null) {
				newCareer += career[i] + " ";
			}
			
		}
		return newCareer;
	  }
	  
	  
	  
	  //Alerts
	  
	  public void logInIncorrectAlert() {
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setHeaderText("Log in incorrect");
		  alert.setContentText("The username and password given are incorrect");
		  alert.showAndWait();
	  }
	  
	  public void validationErrorAlert() {
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setHeaderText("Validation error");
		  alert.setContentText("You must fill each field in the form");
		  alert.showAndWait();
	  }
	  
	  public void accountCreatedAlert() {
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setHeaderText("Account created");
		  alert.setContentText("The new account has been created");
		  alert.showAndWait();
	  }
}
