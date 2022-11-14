package lotto.model;

import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;

import static lotto.model.Lotto.*;
import static lotto.service.LottoService.*;

public class BonusNumber {
    private int bonusNumber;
    private List<Integer> winningNumber;
    private final String INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.";

    public BonusNumber(String bonusNumberString, List<Integer> winningNumber) {
        this.bonusNumber = validate(bonusNumberString, winningNumber);
        this.winningNumber = winningNumber;
    }

    public int validate(String bonusNumberString, List<Integer> winningNumber) {
        try {
            int bonusNumberInt = Integer.parseInt(bonusNumberString);
            if (!(bonusNumberInt >= LOTTO_NUMBER_MIN && bonusNumberInt <= LOTTO_NUMBER_MAX)
                    || winningNumber.contains(bonusNumberInt)) {
                throw new IllegalArgumentException();
            }
            bonusNumberInt = Integer.parseInt(bonusNumberString);
            return bonusNumberInt;
        } catch (IllegalArgumentException e) {
            status = ERROR_STATUS;
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
