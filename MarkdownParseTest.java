import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinks() throws IOException {
        try {
            Path fileName = Path.of("test-file.md");
            String content = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(content);
            ArrayList<String> actual = new ArrayList<>();
            actual.add("https://something.com, some-thing.html");
            assertEquals(actual.toString(), links.toString());
        }
        catch (Exception e) {
            //TODO: handle exception
            System.out.println("catch");
        }
    }
}