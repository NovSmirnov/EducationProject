package educationProject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Создаём списки объектов классов Student и University
        ArrayList<Student> students = ExcelReader.readStudents();
        ArrayList<University> universities = ExcelReader.readUniversities();

        //Создаём коллекцию объектов типа Statistics
        ArrayList<Statistics> statisticsList = StatUtils.makeStatList(students, universities);

        //Выводим файл в resourses
        XlsWriter.tableGenerator(statisticsList, "src/main/resources/stat.xlsx");
    }
}
