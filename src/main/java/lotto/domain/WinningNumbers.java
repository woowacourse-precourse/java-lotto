package lotto.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String DUPLICATE_BONUS_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다";
    private Lotto winningLottoNumbers;
    private LottoNumber bonus;

    public WinningNumbers() {
    }

    private WinningNumbers(List<Integer> mainNumbers, Integer bonus) {
        this.winningLottoNumbers = Lotto.generateFromRawValues(mainNumbers);
        this.bonus = LottoNumber.generateFromRawValue(bonus);
        validate(); //반드시 필드 값 할당 후에 실행해야 함
    }

    public WinningNumbers generateFromRawValues(List<Integer> mainNumbers
            , Integer bonus) {

        WinningNumbers createdWinningNumbers = new WinningNumbers(mainNumbers
                , bonus);

        return createdWinningNumbers;
    }

    private void validate() {
        validateDuplicateWithBonus();
    }

    private void validateDuplicateWithBonus() {
        if (this.winningLottoNumbers.isMatchedNumbersWith(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_ERROR_MESSAGE);
        }
    }
}
