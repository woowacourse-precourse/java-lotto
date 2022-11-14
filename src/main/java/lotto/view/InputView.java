package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.BuyAmountDto;
import lotto.dto.LottoDto;

public enum InputView {
    INSTANCE;

    private static final String INPUT_BUY_AMOUNT_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public BuyAmountDto inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        String buyAmount = Console.readLine();
        return new BuyAmountDto(InputValidator.validateBuyAmount(buyAmount));
    }

    public LottoDto inputLottoNumbers() {
        List<Integer> winningNumbers = inputWinningNumbers();
        Integer bonusNumber = inputBonusNumber(winningNumbers);
        return new LottoDto(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String winningNumbers = Console.readLine();
        return InputValidator.validateWinningNumbers(winningNumbers);
    }

    private Integer inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return InputValidator.validateBonusNumber(winningNumbers, bonusNumber);
    }
}
