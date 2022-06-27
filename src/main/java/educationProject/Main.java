package educationProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создаём списки объектов классов Student и University
        ArrayList<Student> students = ExcelReader.readStudents();
        ArrayList<University> universities = ExcelReader.readUniversities();

        // Создаём списки компараторов для объектов классов Student и University
        List<Comparator<Student>> studCompList = new ArrayList<>();
        for (StudComparators comparator : StudComparators.values()) {
            studCompList.add(ComparatorChooser.studComparator(comparator));
        }

        List<Comparator<University>> uniCompList = new ArrayList<>();
        for (UnivComparators comparator : UnivComparators.values()) {
            uniCompList.add(ComparatorChooser.univComparator(comparator));
        }

        //Применим сортировку по имени для списка студентов и по году основания для университетов.
        //Компаратор для студентов по индексу 1 - сортирует по имени
        //Компаратор для университетов по индексу 3 -сортирует по году основания
        students.sort(studCompList.get(1));
        universities.sort(uniCompList.get(3));

        //Выводим в консоль отсортированные списки студентов и университетов с помощью Stream API
        students.forEach(System.out::println);
        System.out.println("");
        universities.forEach(System.out::println);
    }
}
