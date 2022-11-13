package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputPurchaseView {
    private static final String INPUT_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private final String input;

    public String getInput() {
        return input;
    }

    public InputPurchaseView() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        input = Console.readLine();
    }
}
