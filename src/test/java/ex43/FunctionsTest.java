package ex43;

import junit.framework.TestCase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FunctionsTest extends TestCase {

    public void testSetPath() {
        String path;
        path = System.getProperty("user.dir");
        path += "\\TestPath";
        assertTrue(path.equals(Functions.setPath("TestPath")));
        System.out.println("Successfully tested setPath.");
    }

    public void testMakeDir() {
        String path;
        path = System.getProperty("user.dir");
        path += "\\testMakeDir";
        Functions.makeDir(path);
        int test = 0;
        if(Files.isDirectory(Paths.get(path))){
            test = 1;
        }
        assertEquals(1,test);

        File delete = new File(path);
        delete.deleteOnExit();
        if(Files.isDirectory(Paths.get(path))){
            System.out.println("Successfully deleted the testing directory");
        }

    }

    public void testHtml() {
    }

    public void testCss() {
    }

    public void testJs() {
    }
}