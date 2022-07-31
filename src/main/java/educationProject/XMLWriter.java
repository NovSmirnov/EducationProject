package educationProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLWriter {
    private static final Logger logger = LogManager.getLogger(XMLWriter.class);

    private XMLWriter() {

    }

    public static void writeXml(Structure structure) {
        Date fileDate = new Date();
        String dirName = "src/main/resources/xmlFiles/";
        new File(dirName).mkdir();
        SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = fileDateFormat.format(fileDate) + "_educationProject.xml";
        try {
            FileWriter writer = new FileWriter(dirName + fileName);
            try {
                JAXBContext context = JAXBContext.newInstance(Student.class, University.class, Statistics.class, Structure.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(structure, writer);
                logger.info("Маршалинг классовой структуры прошёл успешно!");
            } catch (JAXBException e) {
                logger.error("Ошибка при маршалинге классовой структуры: \n" + e);
            }

            writer.write(0);
            writer.close();
            logger.info("Файл c xml структурой успешно создан!");

        } catch (IOException e) {
            logger.error("Ошибка ввода/вывода при записи файла c xml структурой: \n" + e);
        }
    }
}
