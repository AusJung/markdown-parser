//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
	System.out.println("change");
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int finalIndex = 0;
        boolean check = false;
        if(!markdown.contains("(") || !markdown.contains(")") ||
                !markdown.contains("[") || !markdown.contains("]")){
                    return toReturn;
        }
        int openBracket = 0;
        int closeBracket = 0;
        int openParen = 0;
        int closeParen = 0;
        while(currentIndex < markdown.length()-1) {
            if(markdown.substring(currentIndex).contains("[")) {
                openBracket = markdown.indexOf("[", currentIndex);
            }
            else return toReturn;
            if(markdown.substring(currentIndex).contains("]")) {
                closeBracket = markdown.indexOf("]", openBracket);
            }
            else return toReturn;
            if(markdown.substring(currentIndex).contains("(")) {
                openParen = markdown.indexOf("(", closeBracket);
            }
            else return toReturn;
            if(markdown.substring(currentIndex).contains(")")) {
                closeParen = markdown.indexOf(")", openParen);
            }
            else return toReturn;
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            if(finalIndex == currentIndex){
                check = true;
            }
            finalIndex = currentIndex;
            if(check){
                return toReturn;
            }
            //small change
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
