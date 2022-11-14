package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final int BONUS_NUMBER;

    private final List<Integer> LOTTO_NUMBER;

    public WinningNumbers(List<Integer> lottoNumber, int bonusNumber) {
        validate(lottoNumber, bonusNumber);
        this.LOTTO_NUMBER = lottoNumber;
        this.BONUS_NUMBER = bonusNumber;
    }

    private boolean isValidUnique(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }

    private void validate(List<Integer> numbers, int number) {
        if (!isValidUnique(numbers, number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getBonusNumber() {
        return BONUS_NUMBER;
    }

    public List<Integer> getLottoNumber() {
        return LOTTO_NUMBER;
    }
}
