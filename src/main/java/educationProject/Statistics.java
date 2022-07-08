package educationProject;

public class Statistics {
    private StudyProfile studyProfile;
    private float averageExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;
    private String[] namesOfUniversities;

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

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public float getAverageExamScore() {
        return averageExamScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public String[] getNamesOfUniversities() {
        return namesOfUniversities;
    }
}
