package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.practice.InputView.inputPurchase;

public class InputView {

    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPurchase() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        String purchase = Console.readLine();
        return Integer.parseInt(purchase);
    }
}
