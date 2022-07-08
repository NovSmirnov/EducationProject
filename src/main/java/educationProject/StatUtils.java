package educationProject;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class StatUtils {
    private StatUtils() {

    }

    public static ArrayList<Statistics> makeStatList(ArrayList<Student> students, ArrayList<University> universities) {
        ArrayList<Statistics> statisticsList = new ArrayList<>();
        for (StudyProfile profile : StudyProfile.values()) {
            Statistics statistics = null;
            for (University university : universities) {
                if (profile == university.getMainProfile()) {
                    for (Student student : students) {
                        if (student.getUniversityId().equals(university.getId())) {
                            if (statistics == null) {
                                statistics = new Statistics(profile, student.getAdvExamScore(), 1,
                                        1, new String[] {university.getShortName()});
                            } else {
                                float newAverageScore = (statistics.getAverageExamScore() * statistics.getNumberOfStudents() +
                                        student.getAdvExamScore()) / (statistics.getNumberOfStudents() + 1);
                                int newNumberOfStudents = statistics.getNumberOfStudents() + 1;
                                if (Arrays.stream(statistics.getNamesOfUniversities())
                                        .anyMatch(x -> !(x.equals(getUniverShortNameFromStudent(student, universities))))) {
                                    int newNumberOfUniversities = statistics.getNumberOfUniversities() + 1;
                                    String[] newNamesOfUniversities = ArrayUtils.addAll(statistics.getNamesOfUniversities(),
                                            getUniverShortNameFromStudent(student, universities));
                                    statistics.setNumberOfUniversities(newNumberOfUniversities);
                                    statistics.setNamesOfUniversities(newNamesOfUniversities);
                                }
                                statistics.setAverageExamScore(newAverageScore);
                                statistics.setNumberOfStudents(newNumberOfStudents);
                            }
                        }
                    }
                }
            }
            if (statistics != null) {
                statisticsList.add(statistics);
            }
        }
        return statisticsList;
    }

    //Получаем короткое имя Университета, в котором учится студент
    private static String getUniverShortNameFromStudent (Student student, ArrayList<University> universities) {
        for (University university : universities) {
            if (university.getId().equals(student.getUniversityId())) {
                return university.getShortName();
            }
        }
        return null;
    }
}
