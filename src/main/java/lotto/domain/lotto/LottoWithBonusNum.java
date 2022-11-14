package lotto.domain.lotto;

import java.util.List;

public class LottoWithBonusNum {
    protected final Lotto lotto;
    protected final BonusNum bonusNum;

    public LottoWithBonusNum(List<Integer> lottoNumbers, int bonusNumber) {
        validate(lottoNumbers, bonusNumber);

        lotto = new Lotto(lottoNumbers);
        bonusNum = new BonusNum(bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateSize(numbers);
        validateDuplidate(numbers, bonusNumber);
        validateNumberRange(numbers, bonusNumber);

    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 숫자들의 개수가 7개가 아닙니다.");
        }
    }

    private void validateDuplidate(List<Integer> numbers, int bonusNumber) {
        numbers.forEach((number) -> {
            if (!isOnceAppear(numbers, number)) {
                throw new IllegalArgumentException("[ERROR] 중복이 되는 숫자가 존재합니다.");
            }
        });
        if (isAppear(numbers, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자와 중복이 되는 숫자가 존재합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers, int bonusNumber) {
        numbers.forEach((number) -> {
            if (!isRanged(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자의 범위가 1 ~ 45 이내가 아닙니다.");
            }
        });
        if (!isRanged(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자의 범위가 1 ~ 45 이내가 아닙니다.");
        }
    }


    private boolean isAppear(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    private boolean isOnceAppear(List<Integer> numbers, int number) {
        return numbers.indexOf(number) == numbers.lastIndexOf(number);
    }

    private boolean isRanged(int number) {
        return 1 <= number && number <= 45;
    }
}
