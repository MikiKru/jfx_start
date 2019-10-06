package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    private void getAlert(Alert.AlertType alertType, String title, String header, String text){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        // zatrzymanie okna na ekranie
        alert.showAndWait();
    }

    public void clearFields(){
        txtName.clear();
        txtLastname.clear();
        txtSalary.clear();
        txtPossion.setValue(null);
    }
    private boolean validInputData(){
        if(!txtName.getText().equals("") &&
                !txtLastname.getText().equals("") &&
                !txtSalary.getText().equals("") &&
                txtPossion.getValue() != null){
            try{
                // próba konwersji na double
                Double.valueOf(txtSalary.getText());
                getAlert(Alert.AlertType.INFORMATION, "Dodano pracownika", "Dodano pracownika",
                        "Dodano pracownika: " + txtName.getText() + " " + txtLastname.getText());
                return true;
            }catch (NumberFormatException e){
                getAlert(Alert.AlertType.ERROR, "Błąd konwersji danych", "Błąd konwersji danych",
                        "Pensja musi być wprowadzona w formacie XXXXX.XX");
                return false;
            }
        } else {
            getAlert(Alert.AlertType.ERROR, "Błąd danych", "Błąd danych",
                    "Wszystkie pola muszą być uzupełnione");
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
            clearFields();
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
