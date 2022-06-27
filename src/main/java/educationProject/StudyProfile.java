package educationProject;

public enum StudyProfile {
    MEDICINE ("Медицина"),
    ECONOMICS ("Экономика"),
    ENGINEERING ("Инженерия"),
    PHYSICS ("Физика"),
    MATHEMATICS ("Математика"),
    LINGUISTICS ("Лингвистика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
