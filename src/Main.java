import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Caroline on 2/10/16.
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Car car = new Car();

    public static void main(String[] args) throws IOException {
        try {
            car = loadAnswers();
            System.out.println("Loaded saved car information.");
            System.out.println(car);
            System.out.println("Would you like to update this car information? [y/n]");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                return;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Start new car entry.");
        } catch (Exception e) {
            System.out.println("An error occurred. Start a new car entry.");
        }
        car.askQuestions();
        saveAnswers();
    }

    public static void saveAnswers() throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(car);

        File f = new File("car.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static Car loadAnswers() throws FileNotFoundException {
        File f = new File("car.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();

        JsonParser p = new JsonParser();
        return p.parse(contents, Car.class);
    }
}






/*Description

    Write a program that asks the user to enter information about a particular good or service (it could be an album, game, book, car, etc). Ask for at least five different attributes, like title, author, and genre. Save the information to a file as a JSON object. When the program runs again, it should read the file and print out the data, then give the user the option to update it.

        Requirements

        Prompt the user to answer at least five different questions about a good or service.
        Save the information into a JSON object in a file.
        When the program first boots, read the file and display the contents.
        Give the user the ability to update the information and re-save it to the file.
        If the JSON parsing fails, give a friendly error rather than crashing the program.*/