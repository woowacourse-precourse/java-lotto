package lotto.model;

public class Rank {
    private int fifth;
    private int fourth;
    private int third;
    private int second;
    private int first;

    public Rank(int fifth, int fourth, int third, int second, int first) {
        this.fifth = fifth;
        this.fourth = fourth;
        this.third = third;
        this.second = second;
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public int getFirst() {
        return first;
    }

    public int getFifth() {
        return fifth;
    }

    public int getFourth() {
        return fourth;
    }

    public int getThird() {
        return third;
    }

    public void addFifth() {
        fifth++;
    }

    public void addFourth() {
        fourth++;
    }

    public void addThird() {
        third++;
    }

    public void addSecond() {
        second++;
    }

    public void addFirst() {
        first++;
    }
}
