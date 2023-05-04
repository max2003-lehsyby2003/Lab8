import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {

    public void writeListToFile(List<Student> students, String filename) {


        try {
            FileWriter writer = new FileWriter(filename);
            for (Student item : students) {
                writer.write(item + "\n");
            }
            writer.close();
            System.out.println("Successfully wrote ArrayList to file " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing ArrayList to file " + filename);
            e.printStackTrace();
        }
    }


    public void createFile(String filename) {
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("Файл існує");

            return;
        }

        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("створення файла: " + file.getAbsolutePath());
            } else {
                System.out.println("Файл не вдалось створити");
            }
        } catch (IOException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public List<Student> readListFromFile(String filename) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // students.add(line);
                students.add(Student.parse(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }




}

