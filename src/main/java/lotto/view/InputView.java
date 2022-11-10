package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String ERROR_NON_POSITIVE_INTEGER = "[ERROR] 올바른 금액을 입력해주세요";
    private static final String ERROR_NON_LOTTO_MONEY = "[ERROR] 로또는 하나 당 1000원 입니다.";

    public int inputMoney() {
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();

        return validateMoney(money);
    }

    private int validateMoney(String money) {
        int purchaseMoney;

        try {
            purchaseMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_INTEGER);
        }

        if (purchaseMoney < 0) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_INTEGER);
        }

        if (purchaseMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NON_LOTTO_MONEY);
        }

        return purchaseMoney;
    }
}
