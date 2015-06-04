package encrypt.view;

import encrypt.MainApp;
import encrypt.model.FileModel;
import javafx.fxml.FXML;
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
    private void initialize() {
        // Initialize the person table with the two columns.
        fileStringTableColumn.setCellValueFactory(cellData -> cellData.getValue().birthdayProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        fileTableView.setItems(mainApp.getFilesList());
    }
}