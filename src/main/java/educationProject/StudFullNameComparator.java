package educationProject;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class StudFullNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        return StringUtils.compare(st1.getFullName(), st2.getFullName());
    }
}
