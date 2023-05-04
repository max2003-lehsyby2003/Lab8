import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Logik {

    //вносим данные в список
    public List<Student> createList() {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество записей: ");
        int count = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите данные для записи " + (i + 1) + ":");
            System.out.print("Имя: ");
            String imy = scanner.nextLine();
            System.out.print("Фамилия: ");
            String famil = scanner.nextLine();
            System.out.print("Отчество: ");
            String batkiv = scanner.nextLine();
            System.out.print("Дата рождения (гггг-мм-дд): ");
            String dataNarodgString = scanner.nextLine();
            LocalDate dataNarodg = LocalDate.parse(dataNarodgString);
            System.out.print("Адрес: ");
            String adress = scanner.nextLine();
            System.out.print("Факультет: ");
            String fakul = scanner.nextLine();
            System.out.print("Группа: ");
            String grupa = scanner.nextLine();
            System.out.print("Телефон: ");
            String telefon = scanner.nextLine();
            System.out.print("Курс: ");
            int kurs = scanner.nextInt();
            scanner.nextLine();

            students.add(new Student(imy, famil, batkiv, dataNarodg, adress, fakul, grupa, telefon, kurs));
        }


        return students;
    }
    //вывод данных списка
    public void printStudent(List<Student> students) {
        students.forEach(System.out::println);

    }
    //список студентів заданого факультету;
    public  List<Student> filterFakultStudent(List<Student>  students, String fakul) {
        List<Student> temp = students
                .stream()
                .filter(student -> student.getFakul().equals(fakul))
                .collect(Collectors.toList());
        return temp;
    }

    //список студентів, які народились після заданого року;
    public  List<Student> filterDataNarodg(List<Student> students, int yearNarodg) {
        List<Student> filteredStudents = students
                .stream()
                .filter(student -> student.getDataNarodg().getYear() > yearNarodg)
                .collect(Collectors.toList());
        return filteredStudents;
    }

    //список навчальної групи в порядку алфавіту;
    public List<Student> sortGroupStudent(List<Student> students, String group) {
        List<Student> temp = students
                .stream()
                .filter(student -> student.getGrupa().equals(group))
                .sorted(Comparator.comparing(Student::getFamil).thenComparing(Student::getImy))
                .collect(Collectors.toList());

        return temp;
    }
    public List<Student> sortListStudent(List<Student> students){
        students.sort(Comparator.comparing(Student:: getFakul).thenComparing(Student::getDataNarodg));
        return students;
    }
    public Set<String> imyFakul (List<Student> students){
        return students.stream()
                .map(Student::getFakul)
                .collect(Collectors.toSet());
    }

    public void printStudentSet(Set<String> imyFakul) {
        imyFakul.forEach(System.out::println);
    }
     public  Map<String, Long> kilFakul (List<Student> students){
        return students.stream()
                .collect(Collectors.groupingBy(Student::getFakul, Collectors.counting()));
     }
     public void printStudentMap(Map<String, Long> map){
         map.forEach((key, value) -> System.out.println(key + ": " + value));
     }

}

