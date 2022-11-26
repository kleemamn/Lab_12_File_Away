import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner inFile;
        JFileChooser chooser = new JFileChooser();

         String line;
         int lines = 0;
         int words = 0;
         int characters = 0;

         Path target = new File(System.getProperty("user.dir")).toPath();
         target = target.resolve("src");
         chooser.setCurrentDirectory(target.toFile());

         try
         {
             if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
             {
                 target = chooser.getSelectedFile().toPath();
                 inFile = new Scanner(target);

                 while (inFile.hasNextLine())
                 {
                     line = inFile.nextLine();
                     lines++;

                     characters += line.length();

                     words += new StringTokenizer(line, " ,").countTokens();
                 }

                 inFile.close();
                 System.out.println("File: " + target.getFileName());
                 System.out.printf("Number of lines %d\nNumber of words: %d\nNumber of characters: %d\n", lines, words, characters);
             }
         }

         catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
         catch (IOException e)
         {
             System.out.println("IOException Error");
             e.printStackTrace();
         }
    }
}