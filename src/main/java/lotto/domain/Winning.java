package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winning {

    public void score(List<Lotto> userNum, Lotto winNum, int bonusNum) {
        for (int i=0; i<userNum.size(); i++) {
            int count = sameCount(userNum.get(i), winNum);

            switch (count) {
                case 3 : Rank.WIN5.addMatchCount();
                break;
                case 4 : Rank.WIN4.addMatchCount();
                break;
                case 5 : bonusCount(userNum.get(i), bonusNum);
                break;
                case 6 : Rank.WIN1.addMatchCount();
                break;
                default: break;
            }
        }
    }

    public int sameCount(Lotto userNum, Lotto winNum) {
        int count = 0;

        count = userNum.matchCount(winNum);

        return count;
    }

    public void bonusCount(Lotto userNum, int bonusNum) {
        if (userNum.contains(bonusNum)) {
            Rank.WIN2.addMatchCount();
            return;
        }

        Rank.WIN3.addMatchCount();
    }

    public double rate(int amount) {
        double sum = 0;

        sum = (Rank.WIN5.getMatchCount() * 5000)
                +(Rank.WIN4.getMatchCount() * 50000)
                +(Rank.WIN3.getMatchCount() * 1500000)
                +(Rank.WIN2.getMatchCount() * 30000000)
                +(Rank.WIN1.getMatchCount() * 2000000000);

        double rate = (sum / amount) * 100;

        return Math.round(rate * 100) / 100.0;
    }

    public List winning(String win) {
        List<Integer> list = new ArrayList<>();

        String[] split = win.split(",");

        try {
            for (int i=0; i<split.length; i++) {
                int num = Integer.parseInt(split[i]);
                numberRange(num);
                list.add(num);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }

        return list;
    }
    
    public void numberRange(int num) {
        if (num<0 || num>46) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 46의 숫자만 입력해 주세요.");
        }
    }
}
