package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoDto;
import lotto.dto.PurchaseAmountDto;

public enum InputView {
    INSTANCE;

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public PurchaseAmountDto inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();

        return InputValidator.validatePurchaseAmount(purchaseAmount);
    }

    public LottoDto inputLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String winningNumbers = Console.readLine();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();

        return InputValidator.validateLottoNumber(winningNumbers, bonusNumber);
    }
}
