package Grep;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grep {
    public Grep() {}

    public static void main(String[] args) {

        File file;
        String fileName;
        Scanner input;
        String content = "";

        for(int i = 1; i < 6; i++){
            fileName = "/Users/lucasborba/Desktop/IntermediateJava/Grep/TestFile" + i + ".txt";
            try {
                file = new File(fileName);
                input = new Scanner(file);
                while(input.hasNext()){
                     content = input.nextLine();
                   // System.out.println(fileName.substring(48) + " - " + content);
                    Pattern pattern = Pattern.compile("\\d+");
                    Matcher matcher = pattern.matcher(content);
                    if (matcher.find()){

                        System.out.println(fileName.substring(48) + " - " + content);

                    }
                }
            }catch (FileNotFoundException e ){
                System.out.println("File not found " + fileName);
               e.printStackTrace();
            }

        }

    }
}
