package registration_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//arraylist is basically a list but able to add onto

public class Student {
    
	// create parallel lists, along with schedules list.
    private List<String> namesList = new ArrayList<>();
	private List<Integer> gradesList = new ArrayList<>();
	private List<String[][]> schedulesList = new ArrayList<>();

    public void newStudent(Scanner reader) {
        System.out.print("Please enter the student's name: ");
        String name = reader.nextLine(); 
        namesList.add(name); 	
        System.out.println("Added student: " + name);

		System.out.print("Please enter the student's grade: ");
		int grade = reader.nextInt();
		gradesList.add(grade);
		
		// add a blank schedule to the schedules list
		String[][] newSchedule = new String[4][4];
		schedulesList.add(newSchedule);

    }

	public void editStudent(Scanner reader){
		String studentChoice;
		int studentID = 0;
		System.out.println("Which Student would you like to edit?");
		studentChoice = reader.nextLine();
		// search and get the array id for the student
		for (int i = 0; i < namesList.size(); i++) {
			if (namesList.get(i) == studentChoice) {
				studentID = i;
			}
		}
		
		//
		boolean end = false;
		int choice;
		while (!end) {
			System.out.println("1) View Schedule\n2) Edit Schedule\n3) Quit");
			choice = reader.nextInt();
			
			switch(choice) { // choice
				case 1:
					String[][] schedule = schedulesList.get(studentID);
					for (int i = 0; i < 4; i++) {
						for (int x = 0; x < 4; x++) {
							System.out.print(schedule[x][i] +  " ");
						}
						System.out.println();
					}
					break;
				case 2:
					System.out.println("not implemented yet");
					break;
				case 3:
					return;
			}
		}
		
		
	}
	
	// method to set a student's grade. ID = number in list, not the student's name. 
	public void setGrade(int studentID, int grade) {
		gradesList.set(studentID, grade);
	}

    // For printing out student info (testing purposes)
    public void printAllStudents() {
        if (namesList.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("\nRegistered students:");
            for (String studentName : namesList) {
                System.out.println(studentName);
            }
            System.out.println();
        }
    }
}