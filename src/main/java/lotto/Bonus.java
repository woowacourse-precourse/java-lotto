package lotto;

import java.util.List;

public class Bonus {

    private final List<Integer> bonusNum;


    public Bonus(List<Integer> bonusNum) {
        this.bonusNum = bonusNum;
    }

    public List<Integer> getBonusNum() {
//        System.out.println(bonusNum);
        return bonusNum;
    }
}
