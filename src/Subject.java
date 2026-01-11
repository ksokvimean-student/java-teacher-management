import java.util.ArrayList;
import java.util.List;

public class Subject {
    private int id;
   
    private String name;
    private List<Teacher> teachers;
    
    public Subject(int id,String name) {
        this.id = id;
        this.name = name;
        this.teachers = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    
    public int getTeacherCount() {
        return teachers.size();
    }
    
    public double getAverageRating() {
        if (teachers.isEmpty()) return 0;
        int sum = 0;
        for (Teacher teacher : teachers) {
            sum += teacher.getRating();
        }
        return (double) sum / teachers.size();
    }
    
    public char getGrade() {
        double avg = getAverageRating();
        switch ((int) avg / 10) {
            case 10:
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }
}
