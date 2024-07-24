package packet;

public class StudentService {

    public static Student bestStudent(Student[] students) {
        if (students != null) {
            int indexBestStudent = 0;
            double averageScore = students[0].getAverageScore();
            for (int i = 1; i < students.length; ++i) {
                if (students[i] != null) {
                    if (averageScore < students[i].getAverageScore()) {
                        averageScore = students[i].getAverageScore();
                        indexBestStudent = i;
                    }
                }
            }
            return students[indexBestStudent];
        } else {
            return null;
        }
    }

    public static void sortBySurname(Student[] students) {
        if (students != null) {
            Student tmp = null;
            for (int i = 0; i < students.length - 1; ++i) {
                for (int j = 0; j < students.length - i - 1; ++j) {
                    if (students[j].getSurname().compareTo(students[j + 1].getSurname()) > 0) {
                        tmp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = tmp;
                    }
                }
            }
        }
    }

}
