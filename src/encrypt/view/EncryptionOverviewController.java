package encrypt.view;

import encrypt.MainApp;
import encrypt.model.FileModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;

public class EncryptionOverviewController {
    private MainApp mainApp;
    @FXML
    private TableView<FileModel> fileTableView;
    @FXML
    private TableColumn<FileModel, File> fileStringTableColumn;
    @FXML
    private RadioButton encryptionButton;
    @FXML
    private RadioButton decryptionButton;
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

    @FXML
    private void initialize() {
        choiceBox.getItems().add("Pidor");
        encryptionButton.fire();
        decryptionButton.disarm();
        fileStringTableColumn.setCellValueFactory(cellData -> cellData.getValue().birthdayProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        fileTableView.setItems(mainApp.getFilesList());
    }
}