package Week1_DesignPrinciplesAndPatterns.Exercise10_MVCPattern.Code;


class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("\nStudent Details:");
        System.out.println("Name    : " + name);
        System.out.println("ID      : " + id);
        System.out.println("Grade   : " + grade);
    }
}

class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudentName(String name) { student.setName(name); }
    public void setStudentId(String id) { student.setId(id); }
    public void setStudentGrade(String grade) { student.setGrade(grade); }

    public String getStudentName() { return student.getName(); }
    public String getStudentId() { return student.getId(); }
    public String getStudentGrade() { return student.getGrade(); }

    public void updateView() {
        view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
    }
}

public class MVCPatternExample {
    public static void main(String[] args) {
        Student student = new Student("Dharaneeswar", "S101", "A+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();


        controller.setStudentName("Dharaneesh");
        controller.setStudentGrade("A");

        controller.updateView();
    }
}
