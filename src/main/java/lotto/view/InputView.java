package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.PurchaseAmountDto;

public enum InputView {
    INSTANCE;

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public PurchaseAmountDto inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();

        InputValidator.validatePurchaseAmount(purchaseAmount);
        return new PurchaseAmountDto(Integer.valueOf(purchaseAmount));
    }
}
