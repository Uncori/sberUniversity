package packet;

public class AmazingString {
    private char[] array;

    public AmazingString(char[] array) {
        this.array = new char[array.length];
        for (int i = 0; i < array.length; ++i) {
            this.array[i] = array[i];
        }
    }

    public AmazingString(String array) {
        this.array = new char[array.length()];
        for (int i = 0; i < array.length(); ++i) {
            this.array[i] = array.charAt(i);
        }
    }

    public char getChar(int index) {
        // условие для пользователя, он ведь не знает что массив начинается с 0 ))
        if (index >= 1 && index <= this.array.length) {
            return this.array[index - 1];
        }
        return '0';
    }

    public int getLength() {
        return this.array.length;
    }

    public void output() {
        for (char c : this.array) {
            System.out.print(c);
        }
    }

    public boolean subArray(char[] array) {
        // находит первое вхождение
        boolean res = false;
        int count = 0;
        for (int i = 0; i < this.array.length; ++i) {
            if (this.array[i] == array[0]) {
                count = 0;
                for (int j = 0; j < array.length; ++j) {
                    if (array[j] != this.array[i + j]) {
                        break;
                    }
                    ++count;
                }
            }
            if (count == array.length) {
                res = true;
                break;
            }
        }
        return res;
    }

    public boolean subString(String array) {
        // находит первое вхождение
        boolean res = false;
        int count = 0;
        for (int i = 0; i < this.array.length; ++i) {
            if (this.array[i] == array.charAt(0)) {
                count = 0;
                for (int j = 0; j < array.length(); ++j) {
                    if (array.charAt(j) != this.array[i + j]) {
                        break;
                    }
                    ++count;
                }
            }
            if (count == array.length()) {
                res = true;
                break;
            }
        }
        return res;
    }

    public void arrayTrim() {
        if (this.array.length > 0) {
            int count = 0;
            if (this.array[0] == ' ') {
                ++count;
                for (int i = 1; i < this.array.length; ++i) {
                    if (this.array[i] == this.array[i - 1]) {
                        ++count;
                    } else {
                        break;
                    }
                }
                char[] res = new char[this.array.length - count];
                for (int i = count, j = 0; i < this.array.length; ++i, ++j) {
                    res[j] = this.array[i];
                }
                this.array = res;
            }

        }

    }

    public void reverse() {
        if (this.array.length > 1) {
            char tmp;
            for (int i = 0, j = this.array.length - 1; i < this.array.length / 2; ++i, --j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }

}
