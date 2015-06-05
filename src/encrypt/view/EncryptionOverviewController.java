package encrypt.view;

import encrypt.MainApp;
import encrypt.encrypter.IEncyptor;
import encrypt.encrypter.Morse;
import encrypt.model.FileModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EncryptionOverviewController {
    private ToggleGroup group;
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
    private Button cryptButton;

    @FXML
    private void initialize() {
        choiceBox.getItems().add("Morse");
        group = new ToggleGroup();
        encryptionButton.setToggleGroup(group);
        decryptionButton.setToggleGroup(group);
        fileStringTableColumn.setCellValueFactory(cellData -> cellData.getValue().fileProperty());
    }

    @FXML
    private void handleCryptButton() {
        IEncyptor encyptor = new Morse();
        int selectedIndex = fileTableView.getSelectionModel().getSelectedIndex();
        Path path = Paths.get(fileTableView.getItems().get(selectedIndex).fileProperty().getValue().getAbsolutePath());
        File fileOut = new File(path.getParent() + com.google.common.io.Files.getNameWithoutExtension(path.toString()) + "Encrypted.txt");
        try {
            if (!fileOut.exists()) {
                fileOut.createNewFile();
            }
            PrintWriter out = new PrintWriter(fileOut.getAbsoluteFile());
            try (
                    Stream<String> stream = Files.lines(path, Charset.defaultCharset())) {
                stream.forEach((str) -> out.println(encyptor.encrypt(str)));
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        fileTableView.setItems(mainApp.getFilesList());
    }
}