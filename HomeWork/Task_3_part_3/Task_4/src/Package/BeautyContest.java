package Package;

import java.util.ArrayList;
import java.util.Collections;

public class BeautyContest {
    private ArrayList<Participant> list;

    public BeautyContest(int count) {
        if (count >= 3) {
            list = new ArrayList<>(count);
        } else {
            System.out.println("Победителей должно быть минимум 3");
            list = new ArrayList<>();
        }

    }

    public ArrayList<Participant> getList() {
        return list;
    }

    public void setList(ArrayList<Participant> list) {
        this.list = list;
    }

    public void setParticipant(Participant participant) {
        list.add(participant);
    }

    public int getLen() {
        return list.size();
    }

    public void print() {
        if (!this.list.isEmpty()) {
            for (int i = 0; i < this.list.size(); ++i) {
                System.out.println(list.get(i).toString());
            }
        } else {
            System.out.println("Список пуст!");
        }
    }

    public void printWinners() {
        if (this.getLen() >= 3) {
            Collections.sort(list);
            for (int i = getLen() - 1; i >= list.size() - 3; --i) {
                System.out.println(list.get(i).toString());
            }
        }
    }

}
