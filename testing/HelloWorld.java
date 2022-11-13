import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloWorld {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner reader = new Scanner(new File("data/testfile.txt"));
    List<String> uniqueWords = new ArrayList<>();
    int numWords = 0;
    while (reader.hasNext()) {
      String word = reader.next();
      if (!uniqueWords.contains(word)) {
          numWords++;
          uniqueWords.add(word);
      }
    }
    System.out.println(numWords);
    // System.out.println("Hello, world!"); 
  }
}
