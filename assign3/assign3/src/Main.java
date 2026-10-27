
import java.util.Scanner;
import java.util.InputMismatchException;


class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}
class ExamRegistration {
    private String studentId;
    private String studentName;
    private int age;
    private double examMark;
    private int numberOfSubjects;

    public void registerStudent(Scanner input)
            throws InvalidRegistrationException {

        System.out.print("Enter Student ID: ");
        studentId = input.nextLine().trim();

        if (studentId.isEmpty()) {
            throw new InvalidRegistrationException("Student ID cannot be empty.");
        }

        System.out.print("Enter Student Name: ");
        studentName = input.nextLine().trim();

        System.out.print("Enter Age: ");
        age = Integer.parseInt(input.nextLine().trim());

        if (age < 18) {
            throw new InvalidRegistrationException("Age must be at least 18.");
        }
        System.out.print("Enter Exam Mark: ");
        examMark = Double.parseDouble(input.nextLine().trim());

        if (examMark < 0 || examMark > 100) {
            throw new InvalidRegistrationException(
                    "Exam mark must be between 0 and 100.");
        }

        System.out.print("Enter Number of Subjects: ");
        numberOfSubjects = Integer.parseInt(input.nextLine().trim());

        if (numberOfSubjects < 1 || numberOfSubjects > 5) {
            throw new InvalidRegistrationException(
                    "Maximum allowed subjects is 5. Students must register for 1–5 subjects.");
        }

        System.out.println();
        System.out.println("Registration Successful!");
        System.out.println("Student: " + studentName);
        System.out.println("Registered Subjects: " + numberOfSubjects);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExamRegistration registration = new ExamRegistration();

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");
        System.out.println();

        try {
            registration.registerStudent(input);
        } catch (InvalidRegistrationException e) {
            System.out.println();
            System.out.println("Registration Failed!");
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Registration Failed!");
            System.out.println("Error: Please enter a valid number for age, exam mark, and number of subjects.");
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Registration Failed!");
            System.out.println("Error: Invalid input type.");
        } finally {
            System.out.println();
            System.out.println("Registration attempt completed.");
            input.close();
        }
    }
}