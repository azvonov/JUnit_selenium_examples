import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class HasTemporaryFolder {
    //Создает темповую директорию, которая автоматически удаляется просле прогона

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile = folder.newFile();
        File createdFolder = folder.newFolder("subfolder");
        System.out.println(folder.getRoot());
    }

}
