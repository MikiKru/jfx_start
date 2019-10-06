package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employee;
import util.EmployeeDB;

import java.util.Arrays;

public class EmployeeController {
    @FXML
    private TableView<Employee> tblEmpl;
    @FXML
    private TableColumn<Employee, String> cName;
    @FXML
    private TableColumn<Employee, String> cLastname;
    @FXML
    private TableColumn<Employee, String> cPossition;
    @FXML
    private TableColumn<Employee, Double> cSalary;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastname;
    @FXML
    private ComboBox<String> txtPossion;
    @FXML
    private TextField txtSalary;

    private boolean validInputData(){
        if(!txtName.getText().equals("") &&
                !txtLastname.getText().equals("") &&
                !txtSalary.getText().equals("") &&
                txtPossion.getValue() != null){
            try{
                // próba konwersji na double
                System.out.println(Double.valueOf(txtSalary.getText()));
                System.out.println("OK");
                return true;
            }catch (NumberFormatException e){
                System.out.println("Błąd konwersji");
                return false;
            }
        } else {
            System.out.println("N-OK");
            return false;
        }
    }
    @FXML
    void saveAction(ActionEvent event) {
        if(validInputData()) {
            // utworzenie obiektu
            Employee employee = new Employee(
                    txtName.getText(),
                    txtLastname.getText(),
                    txtPossion.getValue(),
                    Double.valueOf(txtSalary.getText()));
            // dodanie obiektu do kolekcji FXCollection
            employees.add(employee);
            // aktualizujemy zawartość tabeli
            tblEmpl.setItems(employees);
        }
    }
    // Aby dodać zawartość do kontrolek JFX korzystamy z kolekcji pochodzącej z FXCollection
    // Odpowiednik ArrayList klasy JavaCollections
    ObservableList<String> possitions = FXCollections.observableArrayList(
            Arrays.asList("DEVELOPER","DEV OPS", "ANALYST", "SCRUM MASTER")
    );
    // List obiektów dodawanych do tabeli
    ObservableList<Employee> employees = FXCollections.observableArrayList();

    // metoda initialize wykonywana jest automatycznie przy utworzeniu widoku
    public void initialize(){
        // dodaje stanowiska do listy rozwijanej
        txtPossion.setItems(possitions);
        // konfiguracja kolumn w tabeli
        //nazwaKolumny.setCellValueFactory(new PropertyValueFactory<>("nazwaPolaObiektuTabeli"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        cPossition.setCellValueFactory(new PropertyValueFactory<>("possition"));
        cSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        // dodanie danych obiektu ObservableList
        employees.addAll(EmployeeDB.users);
        // dodanie danych do tabeli
        tblEmpl.setItems(employees);
    }



}
