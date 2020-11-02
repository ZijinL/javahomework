public class homework_3_4 {
    public static void main (String [] args) {
        Course c1 = new Course("java");
        String[] stu_list = {"001", "002", "003"};
        for (String stu: stu_list) {
            c1.addStudent(stu);
        }
        System.out.print("c1: ");
        for (int i=0; i < c1.getNumberOfStudents(); i++) {
            System.out.print(c1.getStudents()[i] + " ");
        }

        Course c2 = (Course) c1.clone();
        c1.addStudent("004");
        c2.dropStudent("003");
        System.out.print("\nc1: ");
        for (int i=0; i < c1.getNumberOfStudents(); i++) {
            System.out.print(c1.getStudents()[i] + " ");
        }
        System.out.print("\nc2: ");
        for (int i=0; i < c2.getNumberOfStudents(); i++) {
            System.out.print(c2.getStudents()[i] + " ");
        }

    }
}

class Course implements Cloneable {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
  
    public Course(String courseName) {
        this.courseName = courseName;
    }
  
    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }
  
    public String[] getStudents() {
        return students;
    }
  
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
  
    public String getCourse1Name() {
        return courseName;
    }
  
    public void dropStudent(String student) {
        for (int i=0; i < students.length; i++) {
            if (students[i] == student) {
                for (int j=i; j < students.length-1; j++) {
                    students[j] = students[j+1];
                }
                // System.out.printf("Student(%s) has been dropped successfully!\n", student);
                numberOfStudents -= 1;
                return;
            }
        }
        System.out.printf("Student(%s) Not Found.\n", student);
    }

    public Object clone() {
        try {
            Course newCourse = (Course) super.clone();
            newCourse.students = new String[100];
            System.arraycopy(students, 0, newCourse.students, 0, 100); 
            newCourse.numberOfStudents = numberOfStudents;
            return newCourse;
        }
        catch (CloneNotSupportedException exception) {
            return null;
        }
    }
    
  }