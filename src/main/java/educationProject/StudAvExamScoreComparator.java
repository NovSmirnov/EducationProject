package educationProject;

import java.util.Comparator;

public class StudAvExamScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        return Float.compare(st2.getAdvExamScore(), st1.getAdvExamScore());
    }
}
