package lotto;

import java.util.Collections;
import java.util.List;

public class LotteryHostAgency {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    protected void setWinningNumbers(List<Integer> numbers) {
        // TODO: 메소드 구현
    }

    protected void setBonusNumber() {
        // TODO: 메소드 구현
    }

    public void draw(List<Integer> winningNumbers, int bonusNumber) {
        // TODO: 메소드 구현
    }

    public WinningCriteria getResult(List<Integer> challengeNumbers) {
        // TODO: 메소드 구현
        return WinningCriteria.NOTHING;
    }


    public enum WinningCriteria {
        FIRST(2000000000), SECOND(30000000), THIRD(1500000), FORTH(50000), FIFTH(5000), NOTHING(0);
        int amount;

        WinningCriteria(int amount) {
            this.amount = amount;
        }
    }


}
