package packet;

public class TimeUnit {
    private int sec, min, hour;

    private void checkTime() {
        int minTmp = 0, hourTmp = 0;
        if (this.sec > -1) {
            if (this.sec > 59) {
                minTmp = this.sec / 60;
                this.sec %= 60;
            }
        } else {
            this.sec = 0;
        }

        if (this.min > -1) {
            this.min += minTmp;
            if (this.min > 59) {
                hourTmp = this.min / 60;
                this.min %= 60;
            }
        } else {
            this.min = 0;
            this.min += minTmp;
        }

        if (this.hour > -1) {
            this.hour += hourTmp;
            if (this.hour > 23) {
                this.hour %= 24;
            }
        } else {
            this.hour = 0;
            this.hour += hourTmp;
        }
    }


    public TimeUnit(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        checkTime();
    }

    public TimeUnit(int hour, int min) {
        this.hour = hour;
        this.min = min;
        this.sec = 0;
        checkTime();
    }

    public TimeUnit(int hour) {
        this.hour = hour;
        this.min = 0;
        this.sec = 0;
        checkTime();
    }

    public void printTwentyFourFormat() {
        if (this.hour < 10) {
            System.out.print("0" + this.hour + ":");
        } else {
            System.out.print(this.hour + ":");
        }
        if (this.min < 10) {
            System.out.print("0" + this.min + ":");
        } else {
            System.out.print(this.min + ":");
        }
        if (this.sec < 10) {
            System.out.println("0" + this.sec);
        } else {
            System.out.println(this.sec);
        }
    }

    public void printTwelveFormat() {
        String meridian = "";
        int tmp = 0;
        if (this.hour >= 12 && this.hour <= 23) {
            tmp = this.hour % 12;
            if (tmp == 0) {
                tmp = 12;
            }
            meridian = "pm";
        }

        if (this.hour >= 0 && this.hour <= 11) {
            tmp = this.hour % 12;
            if (tmp == 0) {
                tmp = 12;
            }
            meridian = "am";
        }

        if (tmp < 10) {
            System.out.print("0" + tmp + ":");
        } else {
            System.out.print(tmp + ":");
        }
        if (min < 10) {
            System.out.print("0" + min + ":");
        } else {
            System.out.print(min + ":");
        }
        if (sec < 10) {
            System.out.println("0" + sec + " " + meridian);
        } else {
            System.out.println(sec + " " + meridian);
        }
    }

    public void addTime(int hour, int min, int sec) {
        this.hour += hour;
        this.min += min;
        this.sec += sec;
        checkTime();
    }


}
