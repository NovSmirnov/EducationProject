package educationProject;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class UnivIdComparator implements Comparator<University> {
    @Override
    public int compare(University un1, University un2) {
        return StringUtils.compare(un1.getId(), un2.getId());
    }
}
