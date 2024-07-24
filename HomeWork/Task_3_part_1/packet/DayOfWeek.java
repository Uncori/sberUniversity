package packet;

public class DayOfWeek {
    private byte day;
    private String weekDay;

    public DayOfWeek(byte day, String weekDay) {
        this.day = day;
        this.weekDay = weekDay;
    }

    public byte getDay() {
        return day;
    }

    public String getWeekDay() {
        return weekDay;
    }
}
