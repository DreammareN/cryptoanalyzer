import java.io.File;

public class FileManager {

    public boolean checkPathToFile(String path) {
        File f = new File(path);
        return f.isFile();
    }

}
