/**
 * Created by Caroline on 2/10/16.
 */
public class Car {
    String make;
    String model;
    String color;
    int year;
    int numberOfDoors;

    public void askQuestions() {
        System.out.println("What is the make of your car?");
        this.make = Main.scanner.nextLine();
        System.out.println("What is the model of your car?");
        this.model = Main.scanner.nextLine();
        System.out.println("What color is your car?");
        this.color = Main.scanner.nextLine();
        System.out.println("What model year is your car?");
        this.year = Main.scanner.nextInt();
        System.out.println("How many doors does your car have?");
        this.numberOfDoors = Main.scanner.nextInt();

    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}
