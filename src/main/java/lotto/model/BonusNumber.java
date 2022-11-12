package lotto.model;

import java.util.List;
import lotto.constants.ErrorCode;

public class BonusNumber {

    int bonusNumber;

    public BonusNumber(Lotto lotto, int bonusNumber) throws Exception {
        validateContains(lotto,bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateContains(Lotto lotto, int bonusNumber) throws Exception {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            throw ErrorCode.NOT_CONTAINS_IN_LOTTO.getException();
        }
    }
}
