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
    public void getLinks() {
        
        try {
            Path fileName = Path.of("test-file.md");
            String content = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(content);
            ArrayList<String> actual = new ArrayList<>();
            actual.add("https://something.com, some-thing.html");
            assertEquals(actual.toString(), links.toString());
            System.out.println("try");
        }
        catch (Exception e) {
            System.out.println("catch");
        }
        
    }
    @Test
    public void getLinks2() {
        
        try {
            Path fileName = Path.of("test-file8.md");
            String content = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(content);
            ArrayList<String> actual = new ArrayList<>();
            actual.add("a link on the first line");
            assertEquals(actual.toString(), links.toString());
            System.out.println("try2");
        }
        catch (Exception e) {
            System.out.println("catch2");
        }
        
    }
}