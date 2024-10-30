package registration_system;

import java.util.Scanner;

public class registration_system_main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Student studentReg = new Student();
        String condition = "";
        int menuChoice = 0;

        while (!condition.equals("end")) {
            System.out.println("1: New Student \n2: View All Students \n3: Edit Student \n4: Exit");
            menuChoice = reader.nextInt();
            reader.nextLine();

            if (menuChoice == 1) {
                studentReg.newStudent(reader);
            } 
			else if (menuChoice == 2) {
				studentReg.printAllStudents();
            } 
			else if (menuChoice == 3) {
				studentReg.editStudent(reader);
            } 
			else if (menuChoice == 4) {
                condition = "end";
            } 
			else {
                System.out.println("Invalid choice, please select again.");
            }

        }

        System.out.println("Exiting the system.");
        reader.close();
    }
}