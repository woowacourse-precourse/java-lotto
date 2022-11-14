package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private int three;
    private int four;
    private int five;
    private int fiveBonus;
    private int six;

    public Result() {
        three = 0;
        four = 0;
        five = 0;
        fiveBonus = 0;
        six = 0;
    }

    public List<Integer> getStatus() {
        List<Integer> status = new ArrayList<>();
        status.add(three);
        status.add(four);
        status.add(five);
        status.add(fiveBonus);
        status.add(six);
        return status;
    }

    public void add(int count) {
        if (count == 3) {
            three++;
            return;
        }
        if (count == 4) {
            four++;
            return;
        }
        if (count == 5) {
            five++;
            return;
        }
        if (count == 6) {
            six++;
        }
    }

    public void addFiveBonus() {
        fiveBonus++;
    }
}
