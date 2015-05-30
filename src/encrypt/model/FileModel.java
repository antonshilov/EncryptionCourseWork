package encrypt.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;

/**
 * Created by vaccu on 30.05.2015.
 */
public class FileModel {
    private final ObjectProperty<File> fileProperty;
    public FileModel(String path){
        this.fileProperty = new SimpleObjectProperty<File>(new File(path));
    }
    public ObjectProperty<File> birthdayProperty() {
        return fileProperty;
    }
}
