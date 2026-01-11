# Teacher Quality Rating System
## Developer Documentation
 
## 1. Project Overview

A console-based Java application that collects teacher quality ratings by subject, calculates average scores, assigns grades, and generates a quality report.

---

## 2. Input Specifications

### 2.1 Data Collection

- Subject name (string)
- Number of teachers per subject (integer)
- Quality rating for each teacher (integer: 0-100)

### 2.2 Input Validation

| Field | Valid Range | Error Message |
|-------|------------|---------------|
| Rating | 0-100 | "Rating must be between 0-100" |
| Teacher Count | ≥ 1 | "Enter valid teacher count" |
| Subject Name | Non-empty | "Subject name cannot be empty" |
| Input Type | Numeric | "Please enter a valid number" |

### 2.3 Input Flow

1. Add subject name
2. Enter number of teachers
3. Input rating for each teacher (0-100)
4. Repeat for additional subjects or proceed to report

---

## 3. Data Processing

### 3.1 Average Quality Calculation

```
Average Quality = Sum of all teacher ratings / Number of teachers
```

Display with 2 decimal places.

### 3.2 Grade Assignment (Switch-Case)

| Average Score | Grade |
|---------------|-------|
| 90-100 | A |
| 80-89 | B |
| 70-79 | C |
| 60-69 | D |
| 0-59 | F |

```Java
     static char getGradeFromAverage(double average) {
        int score = (int) average;
        switch (score / 10) {
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
``` 
---

## 4. Output Report

### 4.1 Report Format

```
=====================================
     TEACHER QUALITY REPORT
=====================================

Subject          # Teachers    Avg Quality    Grade
---------------------------------------------------
[Subject Name]   [Count]       [XX.XX]        [A-F]
[Subject Name]   [Count]       [XX.XX]        [A-F]
 
```

### 4.2 Report Contents

- Subject name
- Number of teachers
- Average quality score (2 decimals)
- Letter grade (A/B/C/D/F) 

---

## 5. Class Structure

### Teacher Class
- Properties: name, rating
- Methods: getName(), getRating()
```java
public class Teacher {
    private String name;
    private int rating;
    
    public Teacher(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
    
    public String getName() {
        return name;
    }
    
    public int getRating() {
        return rating;
    }
 
}

```
### Subject Class
- Properties: name, List<Teacher>
- Methods: addTeacher(), getTeacherCount(), getAverageRating(), getGrade()
```Java
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

```
### Main Class (TeacherQualitySystem)
- Menu-driven interface
- Input validation
- Report generation
- All operations

---

## 6. Features

### Feature 1: Add Subjects
- Input subject name
- Prevent duplicate subjects
- Confirm successful creation

### Feature 2: Add Teachers and Ratings
- Select subject by name/index
- Input number of teachers
- Input rating for each teacher (0-100)
- Validate ratings in range

### Feature 3: Calculate Statistics
- Calculate average rating per subject
- Assign grade based on average 

### Feature 4: Generate Quality Report
- Display formatted table
- Show all subjects with statistics
- Display grade

### Feature 5: Input Validation
- Reject ratings outside 0-100
- Reject non-numeric input
- Reject empty subject names
- Provide error messages and allow retry
