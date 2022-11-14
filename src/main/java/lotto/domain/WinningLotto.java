package lotto.domain;


import java.util.List;

public class WinningLotto {

    private static final String BONUS_NUMBER_NOT_DUPLICATE = "보너스 번호는 로또 번호와 중복되면 안됩니다.";

    private final List<Integer> numbers;

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_DUPLICATE);
        }
    }

    public Integer checkMatchNumber(List<Integer> lottoNumbers) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (numbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean isThereBonusNumber(List<Integer> lottoNumber) {
        boolean bonus = lottoNumber.contains(bonusNumber);
        return bonus;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
