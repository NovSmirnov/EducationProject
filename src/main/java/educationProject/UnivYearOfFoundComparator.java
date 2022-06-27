package educationProject;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class UnivYearOfFoundComparator implements Comparator<University> {
    @Override
    public int compare(University un1, University un2) {
        return Integer.compare(un1.getYearOfFoundation(), un2.getYearOfFoundation());
    }
}
