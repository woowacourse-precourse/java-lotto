package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Converter;

public class InputView {
    private static final String ENTER_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPurchaseMoney() {
        System.out.println(ENTER_PURCHASE_MONEY_MESSAGE);
        int money = 0;
        try {
            money = Converter.changeToInt(readLine());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        return money;
    }
}
