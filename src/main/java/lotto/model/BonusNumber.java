package lotto.model;

import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;

import static lotto.model.Lotto.*;

public class BonusNumber {
    private int bonusNumber;
    private List<Integer> winningNumber;
    private final String INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.";

    public BonusNumber(String bonusNumberString, List<Integer> winningNumber) {
        this.bonusNumber = validate(bonusNumberString, winningNumber);
        this.winningNumber = winningNumber;
    }

    public int validate(String bonusNumberString, List<Integer> winningNumber) {
        int bonusNumber = 0;
        bonusNumber = Integer.parseInt(bonusNumberString);
        try {
            if (!(bonusNumber >= LOTTO_NUMBER_MIN && bonusNumber <= LOTTO_NUMBER_MAX)) {
                throw new IllegalArgumentException();
            }
            if (winningNumber.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            LottoService.status = LottoService.ERROR_STATUS;
            OutputView.printError(INVALID_BONUS_NUMBER_ERROR);
        }

        return bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumber() {

        return winningNumber;
    }
}
