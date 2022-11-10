package lotto.rank;

public class Rank {

    static int count;
    static int fifth;
    static int fourth;
    static int third;
    static int second;
    static int first;

    public static void initCount() {
        count = 0;
    }

    public static void initParam() {
        fifth = 0;
        fourth = 0;
        third = 0;
        second = 0;
        first = 0;
    }

    public static int getCount() {
        return count;
    }

    public static int getFifth() {
        return fifth;
    }

    public static int getFourth() {
        return fourth;
    }

    public static int getThird() {
        return third;
    }

    public static int getSecond() {
        return second;
    }

    public static int getFirst() {
        return first;
    }

    public static void addCount() {
        count++;
    }

    public static void addFifth() {
        fifth++;
    }

    public static void addFourth() {
        fourth++;
    }

    public static void addThird() {
        third++;
    }

    public static void addSecond() {
        second++;
    }

    public static void addFirst() {
        first++;
    }
}
