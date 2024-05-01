package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class AddBookController implements Initializable {
	@FXML
	private TextField tfLastName;
	@FXML
	private TextField tfFirstName;
	@FXML
	private TextField tfEmail;
	@FXML
	private Button Addbtn;
	@FXML
	private Button Exportbtn;
	@FXML
	private Button Importbtn;
	@FXML
	private Button Removebtn;
	@FXML
	private Button Quitbtn;

	@FXML
	private TableView<Personne> Table;
	@FXML
	private TableColumn<Personne, String> emailCol;
	@FXML
	private TableColumn<Personne, String> firstNameCol;
	@FXML
	private TableColumn<Personne, String> lastNameCol;
	
	

	private DataClass data = new DataClass();
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn()); 
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn()); 
		emailCol.setCellFactory(TextFieldTableCell.forTableColumn()); 
		Table.setEditable(true);
		
		
		firstNameCol.setOnEditCommit((CellEditEvent<Personne, String> t) -> {int i=0;
		ObservableList<Personne> l = FXCollections.observableArrayList(); for(Personne P:Table.getItems())
		{ if(P.equals(t.getRowValue()))
		{ P.setPrenom(t.getNewValue());
		 System.out.println(P.getPrenom());
		 }
		l.add(P);
		}
		Table.setItems(l);
		});
		
		lastNameCol.setOnEditCommit((CellEditEvent<Personne, String> t) -> {int i=0;
		ObservableList<Personne> l = FXCollections.observableArrayList(); for(Personne P:Table.getItems())
		{ if(P.equals(t.getRowValue()))
		{ P.setPrenom(t.getNewValue());
		 System.out.println(P.getPrenom());
		 }
		l.add(P);
		}
		Table.setItems(l);
		});
		
		emailCol.setOnEditCommit((CellEditEvent<Personne, String> t) -> {int i=0;
		ObservableList<Personne> l = FXCollections.observableArrayList(); for(Personne P:Table.getItems())
		{ if(P.equals(t.getRowValue()))
		{ P.setPrenom(t.getNewValue());
		 System.out.println(P.getPrenom());
		 }
		l.add(P);
		}
		Table.setItems(l);
		});
		
		
		importe();
	}

	public void addbtn() {
		String firstName = tfFirstName.getText();
		String lastName = tfLastName.getText();
		String email = tfEmail.getText();
		
		if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);  
			alert.setTitle("Champ vide");
			alert.setHeaderText(null);
			alert.setContentText("Remplir tout les champs"); 
			alert.showAndWait();
			}
		else if(!isEmailAdress(email)){
			Alert alert = new Alert(AlertType.WARNING);  
			alert.setTitle("Champ vide");
			alert.setHeaderText(null);
			alert.setContentText("Email incorrecte"); 
			alert.showAndWait();
		}
		else {
			
		Personne newPerson = new Personne(firstName, lastName, email);

		Table.getItems().add(newPerson);
		tfFirstName.clear();
		tfLastName.clear();
		tfEmail.clear();
		}
		

	}

	public void remove() {
		TableView.TableViewSelectionModel<Personne> selectionModel = Table.getSelectionModel();
	    
	   
	    Personne selectedPerson = selectionModel.getSelectedItem();
	    
	    if (selectedPerson != null) {
	        
	        Table.getItems().remove(selectedPerson);
	    } else {
	    	Alert alert = new Alert(AlertType.WARNING);  
			alert.setTitle("Champ vide");
			alert.setHeaderText(null);
			alert.setContentText("Selectionner une ligne a supprimer !"); 
			alert.showAndWait();
	        
	    }

	}

	public void importe() {
		Table.getItems().addAll(data.getImportList());
	}

	public void export() {
		
		ObservableList<Personne> listpr = Table.getItems();
		
		ArrayList<Personne> listfinal = new ArrayList<>(listpr);
		
		data.setExportList(listfinal);

	}

	public void quit() {
		System.exit(0); 
	}
	public static boolean isEmailAdress(String email){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[AZ]{2,4}$" );
		Matcher m = p.matcher(email.toUpperCase());
		return m.matches(); }

}