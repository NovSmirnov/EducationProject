package educationProject;

import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("University s ID")
    private String id;

    @SerializedName("University s full name")
    private String fullName;

    @SerializedName("University s short name")
    private String shortName;

    @SerializedName("University s year of foundation")
    private int yearOfFoundation;

    @SerializedName("Study profile of university")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }
    
    @Override
    public String toString() {
        return String.format("University ID: %s, University's full name: %s, University's short name: %s, Year of foundation: %s, Study profile: %s",
                id, fullName, shortName, yearOfFoundation, mainProfile);
    }
}
