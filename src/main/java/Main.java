import educationProject.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        logger.info("Начало работы программы!");

        //Создаём списки объектов классов Student и University
        ArrayList<Student> students = ExcelReader.readStudents();
        ArrayList<University> universities = ExcelReader.readUniversities();

        //Создаём коллекцию объектов типа Statistics
        ArrayList<Statistics> statisticsList = StatUtils.makeStatListWithZero(students, universities);

        //Создаём объект класса структуры, которая впоследствии будет записана в xml json файлы
        Structure structure = new Structure(students, universities, statisticsList);

        //Записываем созданную структуру в xml и json файлы
        XMLWriter.writeXml(structure);
        JsonWriter.writeJson(structure);

        //Выводим файл в resources (Оставил метод для наглядности)
        XlsWriter.tableGenerator(statisticsList, "src/main/resources/stat.xlsx");

        logger.info("Работа программы окончена!");
    }
}
