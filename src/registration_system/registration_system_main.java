package registration_system;

import java.util.Scanner;

public class registration_system_main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Student studentReg = new Student();
        String condition = "";
        int menuChoice = 0;

        while (!condition.equals("end")) {
            System.out.println("1) New Student \n2) View All Students \n3) Edit Student \n4) Remove Student \n5) Exit");
            menuChoice = reader.nextInt();
            reader.nextLine();
            switch (menuChoice) { 
                case 1:
                    studentReg.newStudent(reader);
                    break;
                case 2:
                    studentReg.printAllStudents();
                    break;
                case 3:
                    studentReg.editStudent(reader);
                    break;
                case 4:
                    studentReg.removeStudent(reader);
                    break;
                case 5:
                    condition = "end";
                    break;
                default:
                    System.out.println("Invalid choice, please select again.");
            }

        }

        System.out.println("Exiting the system...");
        reader.close();
    }
}
