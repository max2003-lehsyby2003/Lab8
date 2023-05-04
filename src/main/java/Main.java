import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        IOFile ioFile = new IOFile();
        Logik logik = new Logik();
//        Json json = new Json();
        List<Student> students;
        Scanner input = new Scanner(System.in);
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        String file, filename, fakul, group;
        int date;


        while (true) {
            System.out.println("Выберите один из пунктов меню:");
            System.out.println("1. Створення/перевірка на існування файла, виведення данних файлу");
            System.out.println("2. Запис данних до файлу");
            System.out.println("3. список студентів заданого факультету;");
            System.out.println("4. список студентів, які народились після заданого року;");
            System.out.println("5. список навчальної групи в порядку алфавіту;");
            System.out.println("6. список студентів упорядкований за алфавітом назви факультету, а для студентів одного" +
                    "факультету – за датою народження");
            System.out.println("7. список всіх факультетів, інформація про студентів яких є у програмі без повторів");
            System.out.println("8. для всіх факультетів, визначених у пункті 7 визначити кількість студентів, що\n" +
                    "там навчаються та вивести цю інформацію у зручному вигляді.");
            System.out.println("7. Вихід з програми");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1.Створення/перевірка на існування файла, виведення данних файлу ");
                    System.out.println("Введіть назву файлу");
                    filename = sc.next();
                    ioFile.createFile(filename);
                    break;

                case 2:
                    System.out.println("2.Запис данних до файлу");
                    System.out.println("Введіть назву файлу");
                    file = sc.next();
                    students = logik.createList();
                    ioFile.writeListToFile(students, file);
                    break;

                case 3:
                    System.out.println("3. список студентів заданого факультету;");
                    System.out.println("введіть назву файлу");
                    file = sc.nextLine();
                    System.out.println("Введіть назву факультету(Програмна інженерія, Комп'ютерні технологіі)");
                    fakul = sc.nextLine();
                    System.out.println("------Студенти факультету Програмна інженерія----");
                    students = ioFile.readListFromFile(file);
                    logik.printStudent(logik.filterFakultStudent(students, fakul));
                    break;

                case 4:
                    System.out.println("4. список студентів, які народились після заданого року;");
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);
                    System.out.println("Введіть дату год");
                    date = Integer.parseInt(sc.next());
                    logik.printStudent(logik.filterDataNarodg(students, date));
                    break;

                case 5:
                    System.out.println("5. список навчальної групи в порядку алфавіту;");
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);
                    System.out.println("Введіть назву группи");
                    group = sc.next();
                    logik.printStudent(logik.sortGroupStudent(students, group));
                    break;

                case 6:
                    System.out.println("6. список студентів упорядкований за алфавітом назви факультету, а для студентів одного факультету – за датою народження");
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);
                    logik.printStudent(logik.sortListStudent(students));
                    break;

                case 7:
                    System.out.println("7. список всіх факультетів, інформація про студентів яких є у програмі без повторів");
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);
                    logik.printStudentSet(logik.imyFakul(students));
                    break;

                case 8:
                    System.out.println("8. для всіх факультетів, визначених у пункті 7 визначити кількість студентів, що\n" +
                            "там навчаються та вивести цю інформацію у зручному вигляді");
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);
                    logik.printStudentMap(logik.kilFakul(students));
                    break;

                case 9:
                    System.out.println("Выход из программы");
                    exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

}

