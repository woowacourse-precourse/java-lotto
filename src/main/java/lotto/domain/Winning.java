package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private int win1;
    private int win2;
    private int win3;
    private int win4;
    private int win5;

    public void score(List<List<Integer>> userNum, List<Integer> winNum, int bonusNum) {

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
}
