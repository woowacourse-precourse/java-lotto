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


    public static enum WinningCriteria {
        // TODO: 열거형 구조체 구현
        NOTHING
    }

    ;


}
