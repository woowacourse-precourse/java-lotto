package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String WRITE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static int getInputMoney() {
        System.out.println(WRITE_PURCHASE_AMOUNT);

        int inputMoney = Integer.parseInt(Console.readLine());
        return  inputMoney;
    }
}
