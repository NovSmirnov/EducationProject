package educationProject;

public class Main {
    public static void main(String[] args) {
        Student vasia = new Student("Vasya Ivanov", "MGU", 4, 4.5f);
        University mgu = new University("MGU", "Moscow State University", "MGU", 1795, StudyProfile.ECONOMICS);
        System.out.println(vasia);
        System.out.println(mgu);
    }
}
