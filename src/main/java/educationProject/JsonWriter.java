package educationProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonWriter {
    private static final Logger logger = LogManager.getLogger(JsonWriter.class);
    private JsonWriter() {

    }

    public static void writeJson(Structure structure) {
        Date fileDate = new Date();
        String dirName = "src/main/resources/jsonReqs/";
        new File(dirName).mkdir();
        SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fileNameStudents = fileDateFormat.format(fileDate) + "_students.json";
        String fileNameUniversities = fileDateFormat.format(fileDate) + "_universities.json";
        String fileNameStatistics = fileDateFormat.format(fileDate) + "_statistics.json";

        String studentsJson = JsonUtil.CollectionSerializer(structure.getStudents());
        String universitiesJson = JsonUtil.CollectionSerializer(structure.getUniversities());
        String statisticsJson = JsonUtil.CollectionSerializer(structure.getStatistics());

        try {
            FileWriter writer = new FileWriter(dirName + fileNameStudents);
            writer.write(studentsJson);
            writer.close();
            writer = new FileWriter(dirName + fileNameUniversities);
            writer.write(universitiesJson);
            writer.close();
            writer = new FileWriter(dirName + fileNameStatistics);
            writer.write(statisticsJson);
            writer.close();
            logger.info("Сериализованные коллекции объектов классов Student, University и Statistics успешно записаны в JSON файлы!");

        } catch (IOException e) {
            logger.error("Ошибка ввода/вывода при записи JSON файлов: \n" + e);
        }
    }
}
