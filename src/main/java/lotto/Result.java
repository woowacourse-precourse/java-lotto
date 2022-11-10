package lotto;

public class Result {
    private double earningsRate;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public void checkRanks(Comparator comparator) {
        int count = comparator.getAnswerCount();
        if(count == 6) {
            first += 1;
        } else if(count == 5 && comparator.isBonus()) {
            second += 1;
        } else if(count == 4) {
            third += 1;
        }else if(count == 3) {
            fourth += 1;
        }else if(count == 2) {
            fifth += 1;
        }
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }
}
