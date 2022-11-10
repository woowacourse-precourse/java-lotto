package lotto.domain;

import java.util.List;

public class LottoWinningNumber extends Lotto {
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumber, String bonus) {
        super(winningNumber);
        int bonusNumber = validateInputIsNumber(bonus);
        this.bonusNumber = validateDuplicate(bonusNumber);
    }

    public WinningResult getResult(IssuedLotto issuedLotto) {
        return issuedLotto.compare(super.getNumbers(), bonusNumber);
    }

    private int validateInputIsNumber(String bonus) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonus);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("1~45 사이 숫자를 입력해 주시기 바랍니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~45 사이 숫자를 입력해 주시기 바랍니다.");
        }
        return bonusNumber;
    }

    private int validateDuplicate(int bonusNumber) {
        if (super.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("1~45 사이 숫자를 입력해 주시기 바랍니다.");
        }
        return bonusNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonusNumber : "+
                bonusNumber;
    }
}
