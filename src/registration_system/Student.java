package registration_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    
    private List<String> namesList = new ArrayList<>();
	private List<Integer> gradesList = new ArrayList<>();

    public void newStudent(Scanner reader) {
        System.out.print("Please enter the student's name: ");
        String name = reader.nextLine(); 
        namesList.add(name); 	
        System.out.println("Added student: " + name);

		System.out.print("Please enter the student's grade: ");
		int grade = reader.nextInt();
		gradesList.add(grade);

    }

	public void editStudent(Scanner reader){

	}

    // For printing out student info (testing purposes)
    public void printAllStudents() {
        if (namesList.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("Registered students:");
            for (String studentName : namesList) {
                System.out.println(studentName);
            }
        }
    }
}