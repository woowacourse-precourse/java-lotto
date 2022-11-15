package lotto.exception.winningNums;

public class BonusNumDuplicatedException extends IllegalArgumentException{
    public BonusNumDuplicatedException() {
        super("[ERROR] 당첨 숫자와 보너스 숫자가 중복됩니다.");
    }
}
