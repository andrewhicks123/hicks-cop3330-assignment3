package ex41;


import junit.framework.TestCase;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest extends TestCase {
    public static boolean compareByMemoryMappedFiles(Path path1, Path path2) throws IOException {

        try (RandomAccessFile randomAccessFile1 = new RandomAccessFile(path1.toFile(), "r");
             RandomAccessFile randomAccessFile2 = new RandomAccessFile(path2.toFile(), "r")) {

            FileChannel ch1 = randomAccessFile1.getChannel();
            FileChannel ch2 = randomAccessFile2.getChannel();
            if (ch1.size() != ch2.size()) {

                return false;
            }
            long size = ch1.size();
            MappedByteBuffer m1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, size);
            MappedByteBuffer m2 = ch2.map(FileChannel.MapMode.READ_ONLY, 0L, size);

            return m1.equals(m2);
        }
    }
    public void testOutputFile() throws IOException {
        Path path1 = Paths.get("excercise41_output.txt");
        Path path2 = Paths.get("excercise41_output_test.txt");
        assertTrue(compareByMemoryMappedFiles(path1,path2));

    }
}