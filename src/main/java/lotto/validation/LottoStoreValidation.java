package lotto.validation;

import java.util.List;

public class LottoStoreValidation {
    private static final String ERROR_LOTTO_COUNT = "[ERROR] 로또를 최소 1개 이상 구매 해야 합니다. 로또 금액 : 1000원";
    private static final String ERROR_WINNING_NUMBER_DUPLICATED = "[ERROR] 당첨 번호는 서로 다른 숫자를 입력 해 주셔야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 당첨 번호 중 보너스 번호와 동일한 번호가 있습니다.";

    public LottoStoreValidation() {

    }

    public void lottoCountCheck(int lottoCount) {
        if (lottoCount < 1) {
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT);
        }
    }

    public void lottoNumberDuplicateCheck(List<Integer> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_DUPLICATED);
        }
    }

    public void bonusNumberInWinningNumberCheck(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }
}
