package lotto.model;

public class Ranking {
    private int fifth = 0;
    private int fourth = 0;
    private int third = 0;
    private int second = 0;
    private int first = 0;

    public void doRank(int ranking) {
        if (ranking == 5) {
            fifth++;
        }
        if (ranking == 4) {
            fourth++;
        }
        if (ranking == 3) {
            third++;
        }
        if (ranking == 2) {
            second++;
        }
        if (ranking == 1) {
            first++;
        }
    }

    public int sumFifth() {
        return WinningMoney.FIFTH.getReword() * fifth;
    }

    public int sumFourth() {
        return WinningMoney.FOURTH.getReword() * fourth;
    }

    public int sumThird() {
        return WinningMoney.THIRD.getReword() * third;
    }

    public int sumSecond() {
        return WinningMoney.SECOND.getReword() * second;
    }

    public int sumFirst() {
        return WinningMoney.FIRST.getReword() * first;
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

    public int getSecond() {
        return second;
    }

    public int getFirst() {
        return first;
    }
}
