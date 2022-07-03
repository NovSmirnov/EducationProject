package educationProject;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("Student s name")
    private String fullName;

    @SerializedName("University s ID")
    private String universityId;

    @SerializedName("Number of current course")
    private int currentCourseNumber;

    @SerializedName("Average score of exams")
    private float advExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, float advExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.advExamScore = advExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAdvExamScore(float advExamScore) {
        this.advExamScore = advExamScore;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAdvExamScore() {
        return advExamScore;
    }

    @Override
    public String toString() {
        return String.format("Student's name: %s, University ID: %s, Current course number: %s, Average exam score: %s,",
                fullName, universityId, currentCourseNumber, advExamScore);
    }

}
