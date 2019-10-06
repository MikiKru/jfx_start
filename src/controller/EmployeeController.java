package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private ComboBox<?> txtPossion;

    @FXML
    private TextField txtSalary;

    @FXML
    void saveAction(ActionEvent event) {

    }

}
