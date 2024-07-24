import Package.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BeautyContest contest = new BeautyContest(4);


        Participant participant1 = new Participant("Иван", new Dog("Жучка"));
        participant1.setGrades(new double[]{7, 6, 7});
        contest.setParticipant(participant1);

        Participant participant2 = new Participant("Николай", new Dog("Кнопка"));
        participant2.setGrades(new double[]{8, 8, 7});
        contest.setParticipant(participant2);

        Participant participant3 = new Participant("Анна", new Dog("Цезарь"));
        participant3.setGrades(new double[]{4, 5, 6});
        contest.setParticipant(participant3);

        Participant participant4 = new Participant("Дарья", new Dog("Добряш"));
        participant4.setGrades(new double[]{9, 9, 9});
        contest.setParticipant(participant4);


        contest.print();
        System.out.println();
        contest.printWinners();

    }
}