package educationProject;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class StudCourseNumComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        return Integer.compare(st1.getCurrentCourseNumber(), st2.getCurrentCourseNumber());
    }
}
