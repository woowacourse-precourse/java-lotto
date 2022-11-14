package lotto.domain.lotto;

import java.util.List;

public class LottoWithBonusNum {
    protected final Lotto lotto;
    protected final BonusNum bonusNum;

    public LottoWithBonusNum(List<Integer> lottoNumbers, int bonusNumber) {
        lotto = new Lotto(lottoNumbers);

        validate(lottoNumbers, bonusNumber);
        bonusNum = new BonusNum(bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateDuplicate(numbers, bonusNumber);
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자와 중복이 되는 숫자가 존재합니다.");
        }
    }
}
