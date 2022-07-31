package educationProject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

//@XmlType(name = "statisticsEntry")
public class Statistics {
    private StudyProfile studyProfile;
    private float averageExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;
    private String[] namesOfUniversities;

    public Statistics() {

    }

    public Statistics(StudyProfile studyProfile, float averageExamScore, int numberOfStudents, int numberOfUniversities, String[] namesOfUniversities) {
        this.studyProfile = studyProfile;
        this.averageExamScore = averageExamScore;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUniversities = numberOfUniversities;
        this.namesOfUniversities = namesOfUniversities;
    }

    public Statistics setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    public Statistics setAverageExamScore(float averageExamScore) {
        this.averageExamScore = averageExamScore;
        return this;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public Statistics setNamesOfUniversities(String[] namesOfUniversities) {
        this.namesOfUniversities = namesOfUniversities;
        return this;
    }
    @XmlElement(name = "universityProfile")
    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    @XmlElement(name = "avgScore")
    public float getAverageExamScore() {
        return averageExamScore;
    }
    @XmlTransient
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    @XmlTransient
    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }
    @XmlTransient
    public String[] getNamesOfUniversities() {
        return namesOfUniversities;
    }
}
