package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validation;

public class InputView {
    public static int inputMoney;
    public static void inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoneyString = Console.readLine();
        Validation.validateInputMoney(inputMoneyString);
    }
}
