package encrypt.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;

public class FileModel {
    private final ObjectProperty<File> fileProperty;

    public FileModel(String path) {
        this.fileProperty = new SimpleObjectProperty<>(new File(path));
    }

    public ObjectProperty<File> fileProperty() {
        return fileProperty;
    }
}
