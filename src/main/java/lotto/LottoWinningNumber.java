package lotto;

import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidationUtil;

public class LottoWinningNumber {

    private final InputUtil inputUtil = new InputUtil();

    private final MessageUtil messageUtil = new MessageUtil();

    private final ValidationUtil validationUtil = new ValidationUtil();

    public void getWinningNumbersInfo() {
        getWinningNumbers();
        getBonusNumbers();
    }

    private void getWinningNumbers() {
        messageUtil.printWinningInput();
        String winningNums = inputUtil.getUserInput();
        validationUtil.validateWinningAmount(winningNums);
    }

    private void getBonusNumbers() {
        messageUtil.printBonusInput();
        int bonusNum = Integer.parseInt(inputUtil.getUserInput());
        validationUtil.validateBonusRange(bonusNum);
    }
}
