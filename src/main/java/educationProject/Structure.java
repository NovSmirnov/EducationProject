package educationProject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;

@XmlRootElement(name = "root")
public class Structure {
    @XmlElementWrapper(nillable = true, name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    ArrayList<Student> students;

    @XmlElementWrapper(nillable = true, name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    ArrayList<University> universities;

    @XmlElementWrapper(nillable = true, name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    ArrayList<Statistics> statistics;

    @XmlElement(name = "processedAt", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date processedAt;


    public Structure() {

    }

    public Structure(ArrayList<Student> students, ArrayList<University> universities, ArrayList<Statistics> statistics) {
        this.students = students;
        this.universities = universities;
        this.statistics = statistics;
        this.processedAt = new Date();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public ArrayList<Statistics> getStatistics() {
        return statistics;
    }

    public Date getProcessedAt() {
        return processedAt;
    }
}
