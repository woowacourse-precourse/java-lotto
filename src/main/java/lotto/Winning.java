package lotto;

import lotto.Enums.ErrorMessage;

import java.util.List;

public class Winning {
    private final Lotto winningLotto;
    private final int bonusNum;

    public Winning(Lotto winningLotto, int bonusNum){
        this.winningLotto = winningLotto;

        validateBonus(bonusNum);
        this.bonusNum = bonusNum;
    }

    public Lotto getLotto(){
        return winningLotto;
    }

    public int getBonusNum(){
        return bonusNum;
    }


    private void validateBonus(int number) {
        int minNum = 1;
        int maxNum = 45;

        if(number<minNum) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE.getMessage());
        }
        if(number>maxNum) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE.getMessage());
        }
        if(winningLotto.getNumbers().contains(number)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getMessage());
        }
    }
}
