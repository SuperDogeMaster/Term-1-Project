package registration_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // importing Scanner for user input

// class of all the students together (like a classroom)
public class Student { 
    
    // create parallel lists for storing student information
    private List<String> namesList = new ArrayList<>();
    private List<Integer> gradesList = new ArrayList<>();
    private List<String[][]> schedulesList = new ArrayList<>(); // list of schedules (4x4 matrices)
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

        // assume by default that the student is absent
        attendanceList.add("ABSENT");
    }

    public void editStudent(Scanner reader){
        String studentChoice;
        int studentID = -1; // index number, set to -1 as a default
        boolean searchEnd = false;

        // search for the student
        if (!namesList.isEmpty()) {
            System.out.println("Which Student would you like to edit?");
            studentChoice = reader.nextLine();
            for (int i = 0; i < namesList.size(); i++) {
                if (namesList.get(i).equals(studentChoice)) {
                    studentID = i; // found the student
                    searchEnd = true;
                }
            }
            if (studentID == -1) {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("No students registered yet.");
        }

        boolean end = (studentID == -1); // check if no valid student was found

        int choice;
        while (!end) {
            // display options for editing
            System.out.println("1) View Schedule\n2) Edit Schedule\n3) Take Attendance\n4) View Grades\n5) Edit Grades\n0) Quit");
            choice = reader.nextInt();
            String[][] schedule = schedulesList.get(studentID);
            String[][] gradesList = classGradesList.get(studentID);
            switch(choice) { // handle user's choice

                case 1: // view schedule
                    for (int i = 0; i < 4; i++) {
                        for (int x = 0; x < 4; x++) {
                            System.out.print(schedule[i][x]);
                            if(schedule[i][x] == null || schedule[i][x].isEmpty())
                                System.out.print("          ");
                            else {
                                int spaces = schedule[i][x].length();
                                for (int s = 0; s < 14 - spaces; s++)
                                    System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 2: // edit schedule
                    System.out.print("Enter the term for this class (1-4): ");
                    int term = reader.nextInt();
                    System.out.print("Enter the period for this class (1-4): ");
                    int period = reader.nextInt();
                    reader.nextLine();
                    System.out.print("Enter the name of a class: ");
                    String classChoice = reader.nextLine();
                    schedule[period-1][term-1] = classChoice; // update the schedule
                    System.out.println();
                    break;

                case 3: // take attendance
                    int status;
                    System.out.println("Was the student here today? \n1) Absent\n2) Present\n3) Tardy");
                    status = reader.nextInt();
                    String STATUS_STRING = switch (status) {
                        case 1 -> "ABSENT";
                        case 2 -> "PRESENT";
                        default -> "TARDY";
                    };
                    attendanceList.set(studentID, STATUS_STRING); // update attendance
                    break;

                case 4: // view grades
                    for (int i = 0; i < 4; i++) {
                        for (int x = 0; x < 4; x++) {
                            System.out.print(gradesList[i][x]);
                            if(gradesList[i][x] == null || gradesList[i][x].isEmpty())
                                System.out.print("          ");
                            else {
                                int spaces = gradesList[i][x].length();
                                for (int s = 0; s < 14 - spaces; s++)
                                    System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 5: // edit grades
                    System.out.print("Enter the term for the class (1-4): ");
                    int gradeTerm = reader.nextInt();
                    System.out.print("Enter the period for the class (1-4): ");
                    int gradePeriod = reader.nextInt();
                    reader.nextLine();
                    System.out.print("Enter the grade they should receive (as a letter): ");
                    String grade = reader.nextLine();
                    gradesList[gradePeriod-1][gradeTerm-1] = grade; // update grades
                    System.out.println();
                    break;

                default:
                    System.out.println("Quitting editing mode"); // exit editing mode
                    return;
            }
        }
    }
    
    // method to set a student's grade
    public void setGrade(int studentID, int grade) {
        gradesList.set(studentID, grade);
    }

    // for printing out student info
    public void printAllStudents() {
        if (namesList.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("\nRegistered students:");
            // print out students and their attendance status
            for (int i = 0; i < namesList.size(); i++){
                System.out.println("Grade: " + gradesList.get(i) + "\tName: " + namesList.get(i) + "\tStatus: " + attendanceList.get(i));
            }
            System.out.println();
        }
    }

    // removes a student from the list
    public void removeStudent(Scanner reader){
        String studentChoice;
        int studentID = -1; // default to not found
        System.out.print("Enter the student you'd like to remove: ");
        studentChoice = reader.nextLine();
    
        for (int i = 0; i < namesList.size(); i++) {
            if (namesList.get(i).equals(studentChoice)) {
                studentID = i; // found the student
                namesList.remove(studentID);
                gradesList.remove(studentID);
                attendanceList.remove(studentID);
                schedulesList.remove(studentID);
            }
        }
        
        if (studentID == -1) {
            System.out.println("Not a registered student!"); // notify if not found
        }
    }

    // reset all attendance to absent
    public void resetAttendance(){
        for (int i = 0; i < attendanceList.size(); i++){
        	attendanceList.set(i, "ABSENT"); // set status to absent
        }
        System.out.println("Attendance reset successfully."); // confirmation message
    } 
}
