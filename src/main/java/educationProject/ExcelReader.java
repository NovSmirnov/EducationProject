package educationProject;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {

    private ExcelReader() {
    }

    public static ArrayList<Student> readStudents() {
        ArrayList<Student> studentsList = new ArrayList<>();
        try {
            XSSFWorkbook universityInfo = new XSSFWorkbook(new FileInputStream("src/main/resources/universityInfo.xlsx"));
            XSSFSheet students = universityInfo.getSheet("Студенты");
            String universityId;
            String fullName;
            int currentCourseNumber;
            float advExamScore;
            Iterator<Row> rows = students.iterator();
            rows.next();
            while (rows.hasNext()) {
                Row row = rows.next();
                universityId = row.getCell(0).getStringCellValue();
                fullName = row.getCell(1).getStringCellValue();
                currentCourseNumber = (int) row.getCell(2).getNumericCellValue();
                advExamScore = (float) row.getCell(3).getNumericCellValue();
                Student student = new Student(fullName, universityId, currentCourseNumber, advExamScore);
                studentsList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public static ArrayList<University> readUniversities() {
        ArrayList<University> universitiesList = new ArrayList<>();
        try {
            XSSFWorkbook universityInfo = new XSSFWorkbook(new FileInputStream("src/main/resources/universityInfo.xlsx"));
            XSSFSheet universities = universityInfo.getSheet("Университеты");
            String universityId;
            String fullName;
            String shortName;
            int yearOfFoundation;
            StudyProfile profile;
            Iterator<Row> rows = universities.iterator();
            rows.next();
            while (rows.hasNext()) {
                Row row = rows.next();
                universityId = row.getCell(0).getStringCellValue();
                fullName = row.getCell(1).getStringCellValue();
                shortName = row.getCell(2).getStringCellValue();
                yearOfFoundation = (int) row.getCell(3).getNumericCellValue();
                profile = StudyProfile.valueOf(row.getCell(4).getStringCellValue());
                University university = new University(universityId, fullName, shortName, yearOfFoundation, profile);
                universitiesList.add(university);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return universitiesList;
    }

}
