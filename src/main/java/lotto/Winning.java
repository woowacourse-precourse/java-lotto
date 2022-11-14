package lotto;

import java.util.List;

public class Winning {
    private final Lotto winningLotto;
    private final int bonusNum;

    public Winning(Lotto winningLotto, int bonusNum){
        this.winningLotto = winningLotto;

        validateBonus(bonusNum);
        this.bonusNum = bonusNum;
    }


    private void validateBonus(int number) {

    }
}
