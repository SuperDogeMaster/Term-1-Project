package registration_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//arraylist is basically a list but able to add onto

public class Student { //class of all the students together (like a classroom)
    
	// create parallel lists, along with schedules list.
    private List<String> namesList = new ArrayList<>();
	private List<Integer> gradesList = new ArrayList<>();
	private List<String[][]> schedulesList = new ArrayList<>(); //list of schedules (which are 4x4 matrices)
	private List<String[][]> classGradesList = new ArrayList<>();
    private List<String> attendanceList = new ArrayList<>();

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
		
		// add blank grades as well
		String[][] newGrades = new String[4][4];
		classGradesList.add(newGrades);

        //assume by default that the student is absent
        attendanceList.add("ABSENT");

    }

	public void editStudent(Scanner reader){
		String studentChoice;
		int studentID = -1; //index number, set to -1 as a default
		boolean searchEnd = false;

		// search and get the array id for the student
		if (!namesList.isEmpty()) {
			System.out.println("Which Student would you like to edit?");
			studentChoice = reader.nextLine();
			for (int i = 0; i < namesList.size(); i++) {
				if (namesList.get(i).equals(studentChoice)) {
					studentID = i;
					searchEnd = true;
				}
			}
			if (studentID == -1) {
				System.out.println("Student not found.");
			}
		}
		else {
			System.out.println("No students registered yet.");
		}
		boolean end = false;

		if (studentID == -1) {
			end = true;
		}

		int choice;
		while (!end) {
			System.out.println("1) View Schedule\n2) Edit Schedule\n3) Take Attendance\n4) View Grades\n5) Edit Grades\n0) Quit");
			choice = reader.nextInt();
			String[][] schedule = schedulesList.get(studentID);
			String[][] gradesList = classGradesList.get(studentID);
			switch(choice) { // choice

                //view schedule
				case 1:
					for (int i = 0; i < 4; i++) {
						for (int x = 0; x < 4; x++) {
							System.out.print(schedule[i][x]);
							if(schedule[i][x] == null || schedule[i][x].isEmpty())
								System.out.print("          ");
							else{
								int spaces = schedule[i][x].length();
								for (int s = 0; s < 14 - spaces; s++)
									System.out.print(" ");
							}
						}
						System.out.println();
					}
					break;

                //edit schedule
				case 2:
					System.out.print("Enter the term for this class (1-4): ");
					int term = reader.nextInt();
					System.out.print("Enter the period for this class (1-4): ");
					int period = reader.nextInt();
					reader.nextLine();
					System.out.print("Enter the name of a class: ");
					String classChoice = reader.nextLine();
					schedule[period-1][term-1] = classChoice;
					System.out.println();
					break;

                //take attendance for selected student (studentID is the index)
                case 3:
                    int status;
                    System.out.println("Was the student here today? \n1) Absent\n2) Present\n3) Tardy");
                    status = reader.nextInt();
                    String STATUS_STRING;
                    STATUS_STRING = switch (status) {
                        case 1 -> "ABSENT";
                        case 2 -> "PRESENT";
                        default -> "TARDY";
                    };
                    attendanceList.set(studentID,STATUS_STRING);

                    break;
               
               case 4:
					for (int i = 0; i < 4; i++) {
						for (int x = 0; x < 4; x++) {
							System.out.print(gradesList[i][x]);
							if(gradesList[i][x] == null || gradesList[i][x].isEmpty())
								System.out.print("          ");
							else{
								int spaces = gradesList[i][x].length();
								for (int s = 0; s < 14 - spaces; s++)
									System.out.print(" ");
							}
						}
						System.out.println();
					}
					break;
                case 5:
					System.out.print("Enter the term for the class (1-4): ");
					int gradeTerm = reader.nextInt();
					System.out.print("Enter the period for the class (1-4): ");
					int gradePeriod = reader.nextInt();
					reader.nextLine();
					System.out.print("Enter the grade they should recieve: ");
					String grade = reader.nextLine();
					gradesList[gradePeriod-1][gradeTerm-1] = grade;
					System.out.println();
					break;

		default:
                    System.out.println("Quitting editing mode");
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

            //print out students and their attendance status
            //abuse parallel arrays
            for (int i = 0; i < namesList.size(); i++){
                System.out.println("Grade: " + gradesList.get(i) + "\tName: " + namesList.get(i) + "\tStatus: " + attendanceList.get(i));
            }
            System.out.println();
        }
    }

    // Removes a student from the list, along with their stored data.
	public void removeStudent(Scanner reader){
		String studentChoice;
		int studentID = -1;
		System.out.print("Enter the student you'd like to remove: ");
		studentChoice = reader.nextLine();
	
		for (int i = 0; i < namesList.size(); i++) {
			if (namesList.get(i).equals(studentChoice)) {
				studentID = i;
				namesList.remove(studentID);
				gradesList.remove(studentID);
				attendanceList.remove(studentID);
				schedulesList.remove(studentID);
			}
		}
		
		if (studentID == -1) {
			System.out.println("Not a registered student!");
		}
		
	}
}
