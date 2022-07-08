package educationProject;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class XlsWriter {

    public static void tableGenerator(ArrayList<Statistics> statistics, String path) {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Статистика");
        headerGenerator(book, sheet);
        for (int i = 0; i < statistics.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            BigDecimal average;

            for (int j = 0; j < 5; j++) {
                XSSFCell cell = row.createCell(j);
                switch (j) {
                    case 0:
                        cell.setCellValue(String.valueOf(statistics.get(i).getStudyProfile()));
                        sheet.autoSizeColumn(j);
                        break;
                    case 1:
                        average = BigDecimal.valueOf(Double.parseDouble(String.valueOf(statistics.get(i)
                                .getAverageExamScore()))).setScale(2, RoundingMode.HALF_UP);
                        cell.setCellValue(average.doubleValue());
                        sheet.autoSizeColumn(j);
                        break;
                    case 2:
                        cell.setCellValue(Integer.parseInt(String.valueOf(statistics.get(i).getNumberOfStudents())));
                        sheet.autoSizeColumn(j);
                        break;
                    case 3:
                        cell.setCellValue(Integer.parseInt(String.valueOf(statistics.get(i).getNumberOfUniversities())));
                        sheet.autoSizeColumn(j);
                        break;
                    case 4:
                        cell.setCellValue(Arrays.toString(statistics.get(i).getNamesOfUniversities()));
                        sheet.autoSizeColumn(j);
                        break;
                }

            }
        }
        tableToFile(book, path);
    }

    private static void tableToFile(XSSFWorkbook book, String path) {
        try {
            FileOutputStream out = new FileOutputStream(path);
            book.write(out);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void headerGenerator(XSSFWorkbook book, XSSFSheet sheet) {
        String[] sheetHeader = {"Study profile", "Average exam score", "Number of students", "Number of universities",
                "Names of universities"};
        XSSFRow header = sheet.createRow(0);
        for (int i = 0; i < 5; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue(sheetHeader[i]);
            cell.setCellStyle(fontHeader(book, 16));
        }

    }

    private static XSSFCellStyle fontHeader (XSSFWorkbook book, int fontHeight) {
        XSSFCellStyle headerStyle = book.createCellStyle();
        XSSFFont fontHeader = book.createFont();
        fontHeader.setBold(true);
        fontHeader.setFontHeight(fontHeight);
        headerStyle.setFont(fontHeader);
        return headerStyle;
    }
}
