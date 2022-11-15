package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class LottoStore {
    private Lotto lotto;
    private int bonusNumber;

    public LottoStore(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;

        Validator.validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
