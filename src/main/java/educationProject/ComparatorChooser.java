package educationProject;

import java.util.Comparator;

public class ComparatorChooser {
    private ComparatorChooser() {
    }

    public static Comparator<University> univComparator(UnivComparators univComparators) {
        if (univComparators == UnivComparators.ID) {
            return new UnivIdComparator();
        } else if (univComparators == UnivComparators.FULL_NAME) {
            return new UnivFullNameComparator();
        } else if (univComparators == UnivComparators.SHORT_NAME) {
            return new UnivShortNameComparator();
        } else if (univComparators == UnivComparators.YEAR_OF_FOUNDATION) {
            return new UnivYearOfFoundComparator();
        } else if (univComparators == UnivComparators.MAIN_PROFILE) {
            return new UnivProfileComparator();
        } else {
            return new UnivIdComparator();
        }
    }

    public static Comparator<Student> studComparator(StudComparators studComparators) {
        if (studComparators == StudComparators.UNIVERSITY_ID) {
            return new StudUniversityIdComparator();
        } else if (studComparators == StudComparators.FULL_NAME) {
            return new StudFullNameComparator();
        } else if (studComparators == StudComparators.COURSE_NUMBER) {
            return new StudCourseNumComparator();
        } else if (studComparators == StudComparators.AVERAGE_SCORE) {
            return new StudAvExamScoreComparator();
        } else {
            return new StudUniversityIdComparator();
        }
    }
}
