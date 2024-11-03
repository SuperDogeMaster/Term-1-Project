package registration_system;

import java.util.Scanner;

public class registration_system_main {

    public static void main(String[] args) {

        // create instances and declare variables
        Scanner reader = new Scanner(System.in); 
        Student studentReg = new Student(); 
        String condition = "";
        int menuChoice = 0;

        while (!condition.equals("end")) { // loop until the user decides to end
            System.out.println("1) New Student \n2) View All Students \n3) Edit Student \n4) Remove Student \n5) Reset Attendances \n6) Exit");
            menuChoice = reader.nextInt();
            reader.nextLine(); 
            switch (menuChoice) { 
                case 1:
                    studentReg.newStudent(reader); // call to add a new student
                    break;
                case 2:
                    studentReg.printAllStudents(); // call to display all students
                    break;
                case 3:
                    studentReg.editStudent(reader); // call to edit a student's information
                    break;
                case 4:
                    studentReg.removeStudent(reader); // call to remove a student from the list
                    break;
                case 5:
                    studentReg.resetAttendance(); // call to reset attendance for all students
                    break;
                case 6:
                    condition = "end"; // set condition to end the loop
                    break;
                default:
                    System.out.println("Invalid choice, please select again.");
            }

        }

        System.out.println("Exiting the system...");
        reader.close();
    }
}
