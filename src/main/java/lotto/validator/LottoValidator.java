package lotto.validator;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Money;

public class LottoValidator {
    public static void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당청번호의 갯수는 6개입니다.");
        }
    }

    public static void validateNumberRange(List<Integer> lottoNumbers) {
        for (Integer integer : lottoNumbers) {
            if (integer > LottoConstant.MAX_LOTTO_NUMBER ||
                    integer < LottoConstant.LOW_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateDuplicateWinningAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 정수를 입력하면 안됩니다.");
        }
    }

    public static void validateDuplicateNumber(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream()
                .distinct()
                .count();
        if (count != LottoConstant.WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 정수를 입력하면 안됩니다.");
        }
    }

    public static void validateLottoMoney(Money money) {
        if (!money.checkAmountUnit(LottoConstant.AMOUNT_UNIT)) {
            throw new IllegalArgumentException("[ERROR] 입력금액은 1000원 단위여야 합니다.");
        }
    }

}
