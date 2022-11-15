package lotto.domain;


public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 입력가능합니다.");
        }
    }

    public boolean isDuplicate(Lotto lotto) {
        return lotto.contains(number);
    }

    public boolean isMatch(Lotto lotto) {
        return lotto.contains(number);
    }
}
