package educationProject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Создаём списки объектов классов Student и University
        ArrayList<Student> students = ExcelReader.readStudents();
        ArrayList<University> universities = ExcelReader.readUniversities();


        // Сериализация/десериализация коллекций со сверкой количества элементов
        String jsonStudCol = JsonUtil.studColSer(students);
        System.out.println(jsonStudCol);

        System.out.println("");

        String jsonUnivCol = JsonUtil.univColSer(universities);
        System.out.println(jsonUnivCol);

        ArrayList<Student> newStudents = JsonUtil.studColDeSer(jsonStudCol);
        ArrayList<University> newUniversities = JsonUtil.univColDeSer(jsonUnivCol);

        if (students.size() == newStudents.size() && universities.size() == newUniversities.size()) {
            System.out.println("Коллекции до и после сериализации/десериализации имеют одинаковый размер");
        } else {
            System.out.println("С размером коллекций что-то не так");
        }

        System.out.println("");

        // Давайте будем сериализовать чётные элементы для списка студентов и нечетные для списка университетов
        // Затем выводить и сразу же десериализовать и опять выводить
        students.stream()
                .filter(x -> students.indexOf(x) % 2 == 0 )
                .forEach(item -> {String serialized = JsonUtil.studSer(item);
                    System.out.println(serialized);
                    System.out.println(JsonUtil.studDeSer(serialized));
                });

        universities.stream()
                .filter(x -> universities.indexOf(x) % 2 != 0 )
                .forEach(item -> {String serialized = JsonUtil.univSer(item);
                    System.out.println(serialized);
                    System.out.println(JsonUtil.univDeSer(serialized));
                });
    }
}
