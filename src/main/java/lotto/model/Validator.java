package lotto.model;

import static lotto.utils.ConstantUtil.ERROR;
import static lotto.utils.ConstantUtil.LOTTO_NUMBER_SIZE;
import static lotto.utils.ConstantUtil.MIN_LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final String SIZE_ERROR_MESSAGE = ERROR + "로또 번호의 개수는 6개이어야 합니다.";
    private static final String DUPLICATES_ERROR_MESSAGE = ERROR + "로또 번호에 중복된 숫자가 있습니다.";
    private static final String MIN_MONEY_ERROR_MESSAGE = ERROR + "구입금액은 1000원 이상부터 가능합니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = ERROR + "구입금액은 1000원 단위만 가능합니다.";
    private static final String BONUS_ERROR_MESSAGE = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATES_ERROR_MESSAGE);
        }
    }

    public void validateMinMoney(int money) {
        if (money < MIN_LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MESSAGE);
        }
    }

    public void validateMoneyUnit(int money) {
        if (isNotValidMoneyUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.isExistNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
    }

    private boolean isNotValidMoneyUnit(int money) {
        return money % MIN_LOTTO_PRICE != 0;
    }
}
