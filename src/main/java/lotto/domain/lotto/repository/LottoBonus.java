package lotto.domain.lotto.repository;

import java.util.List;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.UserInterfaceMessage;

public class LottoBonus {
    private final Integer bonusNumber;

    public LottoBonus(Integer bonusNumber, List<Integer> LottoNumber) {
        validate(bonusNumber, LottoNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer number, List<Integer> lottoNumber) {
        if (number < LottoNumberInclusive.START.getValue() || number > LottoNumberInclusive.END.getValue()) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_NUMBER_INCLUSIVE.getValue(),
                    LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
        }
        if (lottoNumber.contains(number)) {
            throw new IllegalArgumentException(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_DUPLICATED.getValue());
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
