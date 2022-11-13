package lotto.validator;

import static lotto.utils.LottoConstant.ERROR_MESSAGE_PREFIX;
import static lotto.utils.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.utils.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.utils.LottoConstant.RIGHT_LOTTO_SIZE;

import java.util.List;

public class LottoNumberValidator {
    private static final String INVALID_WINNING_NUMBER_MESSAGE = "당첨 번호의 값은 1이상 45이하 정수여야 합니다.";
    private static final String WINNING_SIZE_ERROR_MESSAGE = "당첨 번호 6개를 입력해야합니다.";
    private static final String WINNING_NUMBER_DUPLICATED_MESSAGE = "중복된 당첨 번호가 있습니다.";
    private static final String INVALID_BONUS_NUMBER_MESSAGE = "보너스 번호의 값은 1이상 45이하 정수여야 입력해야 합니다.";
    private static final String OVERLAP_BONUS_NUMBER_AND_WINNING_NUMBERS = "당첨 번호와 중복된 보너스 번호를 입력했습니다.";

    public void validateLottoNumbers(List<Integer> winningNumbers) {
        validateNumberRange(winningNumbers);
        validateNumberSize(winningNumbers);
        validateDuplicateNumber(winningNumbers);
    }

    public void validateBonusNumber(int bonusNumber) {
        if (!validRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + INVALID_BONUS_NUMBER_MESSAGE);
        }
    }

    public void validateNumberRange(List<Integer> lotto) {
        lotto.forEach(number -> {
            if (!validRange(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + INVALID_WINNING_NUMBER_MESSAGE);
            }
        });
    }

    private boolean validRange(Integer number) {
        return (MIN_LOTTO_NUMBER <= number) && (number <= MAX_LOTTO_NUMBER);
    }

    public void validateDuplicateNumber(List<Integer> lotto) {
        if (lotto.size() != lotto.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + WINNING_NUMBER_DUPLICATED_MESSAGE);
        }
    }

    public void validateNumberSize(List<Integer> lotto) {
        if (lotto.size() != RIGHT_LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + WINNING_SIZE_ERROR_MESSAGE);
        }
    }

    public void validateLottoNumbersContainBonusNumber(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + OVERLAP_BONUS_NUMBER_AND_WINNING_NUMBERS);
        }
    }
}
