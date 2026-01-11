import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Subject> subjects = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getValidInt("Select an option: ", 1, 5);
            
            switch (choice) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    addTeachersToSubject();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    viewSubjects();
                    break;
                case 5:
                    running = false;
                    System.out.println("\nThank you for using Teacher Quality Rating System!");
                    break;
            }
        }
        scanner.close();
    }
    static void displayMenu() {
        System.out.println("\n=====================================");
        System.out.println("   TEACHER QUALITY RATING SYSTEM");
        System.out.println("=====================================");
        System.out.println("1. Add Subject");
        System.out.println("2. Add Teachers to Subject");
        System.out.println("3. Generate Quality Report");
        System.out.println("4. View Subjects");
        System.out.println("5. Exit");
        System.out.println("=====================================");
    }
    
    static void addSubject() {
        System.out.print("\nEnter subject name: ");
        String subjectName = scanner.nextLine().trim();
        
        if (subjectName.isEmpty()) {
            System.out.println("ERROR: Subject name cannot be empty");
            return;
        } 
        for (Subject subject : subjects) {
            if (subject.getName().equalsIgnoreCase(subjectName)) {
                System.out.println("ERROR: Subject already exists");
                return;
            }
        }
        int newSubId = subjects.size() + 1;
        subjects.add(new Subject(newSubId,subjectName));
        System.out.println("SUCCESS: Subject '" + subjectName + "' added successfully!");
    }
    
    static void addTeachersToSubject() {
        if (subjects.isEmpty()) {
            System.out.println("\nERROR: No subjects available. Please add a subject.");
            return;
        }
        
        viewSubjects();
        int subjectIndex = getValidInt("Enter subject index: ", 1, subjects.size());
        
        Subject selectedSubject = subjects.get(subjectIndex - 1);
        
        if (selectedSubject == null) {
            System.out.println("ERROR: Subject not found");
            return;
        }
         
        int teacherCount = getValidInt("Enter number of teachers: ", 1, Integer.MAX_VALUE);
        
        for (int i = 1; i <= teacherCount; i++) {
            System.out.print("Teacher " + i + " - Enter name: ");
            String teacherName = scanner.nextLine().trim();
            
            if (teacherName.isEmpty()) {
                System.out.println("ERROR: Teacher name cannot be empty");
                i--;
                continue;
            }
            
            int rating = getValidInt("Enter rating (0-100): ", 0, 100);
            selectedSubject.addTeacher(new Teacher(teacherName, rating));
        }
        
        System.out.println("SUCCESS: " + teacherCount + " teacher(s) added to " + selectedSubject.getName());
    }
    
    static void generateReport() {
        if (subjects.isEmpty()) {
            System.out.println("\nERROR: No subjects available. Please add subjects first.");
            return;
        }
        
        System.out.println("\n=====================================");
        System.out.println("     TEACHER QUALITY REPORT");
        System.out.println("=====================================\n");
        
        System.out.printf("%-20s %-12s %-15s %-6s\n", "Subject", "# Teachers", "Avg Quality", "Grade");
        System.out.println("---------------------------------------------------");
        
        double totalRatingSum = 0;
        int totalTeachers = 0;
        
        for (Subject subject : subjects) {
            if (subject.getTeacherCount() == 0) {
                System.out.printf("%-20s %-12d %-15s %-6s\n", 
                    subject.getName(), 0, "N/A", "N/A");
            } else {
                double avgRating = subject.getAverageRating();
                char grade = subject.getGrade();
                System.out.printf("%-20s %-12d %-15.2f %-6c\n", 
                    subject.getName(), subject.getTeacherCount(), avgRating, grade);
                
                totalRatingSum += avgRating * subject.getTeacherCount();
                totalTeachers += subject.getTeacherCount();
            }
        }
         
        System.out.println("=====================================\n");
    }
    
    static void viewSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("\nNo subjects available.");
            return;
        }
        
        System.out.println("\nAvailable Subjects:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((subjects.get(i).getId()) + ". " + subjects.get(i).getName() + 
                " (" + subjects.get(i).getTeacherCount() + " teachers)");
        }
    }
    
    static int getValidInt(String input, int min, int max) {
        while (true) {
            try {
                System.out.print(input);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < min || value > max) {
                    System.out.println("ERROR: Please enter a number between " + min + " and " + max);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a valid number");
            }
        }
    } 
}
