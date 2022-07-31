package educationProject;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class StatUtils {
    private static final Logger logger = LogManager.getLogger(StatUtils.class);

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

    public static ArrayList<Statistics> makeStatListWithZero(ArrayList<Student> students, ArrayList<University> universities) {
        ArrayList<Statistics> statisticsList = new ArrayList<>();
        for (StudyProfile profile : StudyProfile.values()) {
            int altNumberOfUniversities = 0;
            ArrayList<String> altListOfUniversities = new ArrayList<>();
            Statistics statistics = null;
            for (University university : universities) {
                if (profile == university.getMainProfile()) {
                    altNumberOfUniversities++;
                    altListOfUniversities.add(university.getShortName());
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

                BigDecimal bigDecimal = BigDecimal.valueOf(statistics.getAverageExamScore()).setScale(2, RoundingMode.HALF_UP);
                statistics.setAverageExamScore(bigDecimal.floatValue());
                statisticsList.add(statistics);
            } else {
                String[] altArrayOfUniversities = altListOfUniversities.toArray(new String[0]);
                statistics = new Statistics(profile, 0.0f, 0, altNumberOfUniversities, altArrayOfUniversities);
                statisticsList.add(statistics);
            }

        }
        logger.info("Статистические данные по результату анализа списков студентов и ВУЗов сформированы!");
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
