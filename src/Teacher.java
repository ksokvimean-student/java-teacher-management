public class Teacher {

    private String name;
    private String gender;
    private String fromSchool;
    private String id;
    private String phoneNumber;
    private boolean isSubstitute;
    private String className;
    private String joinDate;
    private double creditScore;
    private double salary;


    public Teacher() {
        this.name = "";
        this.gender = "";
        this.fromSchool = "";
        this.id = "";
        this.phoneNumber = "";
        this.isSubstitute = false;
    }
 
    public Teacher(String name) {
        this();
        this.name = name;
    }

    public Teacher(String name, String gender) {
        this(name);
        this.gender = gender;
    }

    public Teacher(String name, String gender, String fromSchool) {
        this(name, gender);
        this.fromSchool = fromSchool;
    }

    public Teacher(String name, String gender, String fromSchool, String id) {
        this(name, gender, fromSchool);
        this.id = id;
    }

    public Teacher(String name, String gender, String fromSchool, String id, String phoneNumber) {
        this(name, gender, fromSchool, id);
        this.phoneNumber = phoneNumber;
    }

    public Teacher(String name, String gender, String fromSchool, String id, String phoneNumber, boolean isSubstitute) {
        this(name, gender, fromSchool, id, phoneNumber);
        this.isSubstitute = isSubstitute;
    }
    public Teacher(String name, String gender, String fromSchool, String id, String phoneNumber, boolean isSubstitute,String className) {
        this(name, gender, fromSchool, id, phoneNumber,isSubstitute);
        this.className = className;
    }
    public Teacher(String name, String gender, String fromSchool, String id, String phoneNumber, boolean isSubstitute,String className,String joinDate) {
        this(name, gender, fromSchool, id, phoneNumber,isSubstitute,className);
        this.joinDate = joinDate;
    }
    public Teacher(String name, String gender, String fromSchool, String id, String phoneNumber, boolean isSubstitute,String className,String joinDate,double creditScore) {
        this(name, gender, fromSchool, id, phoneNumber,isSubstitute,className,joinDate);
        this.creditScore = creditScore;
    }
    public Teacher(String name, String gender, String fromSchool, String id, String phoneNumber, boolean isSubstitute,String className,String joinDate,double creditScore,double salary) {
        this(name, gender, fromSchool, id, phoneNumber,isSubstitute,className,joinDate,creditScore);
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getFromSchool() {
        return fromSchool;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getClassName() {
        return className;
    }
    public String getJoinDate() {
        return joinDate;
    }
    public double getCreditScore() {
        return creditScore;
    }
    public double getSalary() {
        return salary;
    }


    public boolean isSubstitute() {
        return isSubstitute;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFromSchool(String fromSchool) {
        this.fromSchool = fromSchool;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSubstitute(boolean substitute) {
        isSubstitute = substitute;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", fromSchool='" + fromSchool + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", className='" + className + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", creditScore='" + creditScore + '\'' +
                ", salary='" + salary + '\'' +
                ", isSubstitute=" + isSubstitute +
                '}';
    }
}
