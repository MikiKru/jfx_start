package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class EmployeeController {

    @FXML
    private TableView<?> tblEmpl;

    @FXML
    private TableColumn<?, ?> cName;

    @FXML
    private TableColumn<?, ?> cLastname;

    @FXML
    private TableColumn<?, ?> cPossition;

    @FXML
    private TableColumn<?, ?> cSalary;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLastname;

    @FXML
    private ComboBox<String> txtPossion;

    @FXML
    private TextField txtSalary;

    @FXML
    void saveAction(ActionEvent event) {

    }
    // Aby dodać zawartość do kontrolek JFX korzystamy z kolekcji pochodzącej z FXCollection
    // Odpowiednik ArrayList klasy JavaCollections
    ObservableList<String> possitions = FXCollections.observableArrayList(
            Arrays.asList("DEVELOPER","DEV OPS", "ANALYST", "SCRUM MASTER")
    );

    // metoda initialize wykonywana jest automatycznie przy utworzeniu widoku
    public void initialize(){
        // dodaje stanowiska do listy rozwijanej
        txtPossion.setItems(possitions);
    }


}
