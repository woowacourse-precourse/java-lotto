package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseView {
    private static final String INPUT_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private final int input;

    public int getInput() {
        return input;
    }

    public PurchaseView() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        input = Integer.parseInt(Console.readLine());
    }
}
