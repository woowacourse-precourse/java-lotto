package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winning {
    public int win1 = 0;
    public int win2 = 0;
    public int win3 = 0;
    public int win4 = 0;
    public int win5 = 0;

    public void score(List<Lotto> userNum, List<Integer> winNum, int bonusNum) {
        for (int i=0; i<userNum.size(); i++) {
            int count = sameCount(userNum.get(i), winNum);

            switch (count) {
                case 3 : win5++;
                break;
                case 4 : win4++;
                break;
                case 5 : bonusCount(userNum.get(i), bonusNum);
                break;
                case 6 : win1++;
                break;
                default: break;
            }
        }
    }

    public int sameCount(Lotto userNum, List<Integer> winNum) {
        int count = 0;

        for (int i=0; i<userNum.getNumbers().size(); i++) {
            if(winNum.contains(userNum.getNumbers().get(i))) {
                count++;
            }
        }

        return count;
    }

    public void bonusCount(Lotto userNum, int bonusNum) {
        if (userNum.getNumbers().contains(bonusNum)) {
            win2++;
            return;
        }

        win3++;
    }

    public double rate(List<Integer> score, int amount) {
        double sum = 0;

        sum = (score.get(0) * 5000) + (score.get(1) * 50000) + (score.get(2) * 1500000) + (score.get(3) * 30000000)
                + (score.get(4) * 2000000000);

        double rate = (sum / amount) * 100;

        return Math.round(rate * 100) / 100.0;
    }

    public List winning(String win) {
        List<Integer> list = new ArrayList<>();

        String[] split = win.split(",");

        for (int i=0; i<split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }

        return list;
    }

    public List<Integer> score() {
        List<Integer> score = new ArrayList<>();

        score.add(win5);
        score.add(win4);
        score.add(win3);
        score.add(win2);
        score.add(win1);

        return score;
    }
}
