package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private int win1 = 0;
    private int win2 = 0;
    private int win3 = 0;
    private int win4 = 0;
    private int win5 = 0;

    public void score(List<List<Integer>> userNum, List<Integer> winNum, int bonusNum) {
        for (int i=0; i<userNum.size(); i++) {
            int count = sameCount(userNum.get(i), winNum);

            switch (count) {
                case 3 : win5++ ;
                case 4 : win4++ ;
                case 5 : bonusCount(userNum.get(i), bonusNum) ;
                case 6 : win1++ ;
            }
        }
    }

    public int sameCount(List<Integer> userNum, List<Integer> winNum) {
        int count = 0;

        for (int i=0; i<userNum.size(); i++) {
            if(winNum.contains(userNum.get(i))) {
                count++;
            }
        }

        return count;
    }

    public void bonusCount(List<Integer> userNum, int bonusNum) {
        if (userNum.contains(bonusNum)) {
            win2++;
            return;
        }

        win3++;
    }

    public double rate() {
        return 0;
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
