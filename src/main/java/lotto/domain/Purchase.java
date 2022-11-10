package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private int money = 0;
    private static final String INPUT_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    public int inputMoney() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int input = Integer.parseInt(Console.readLine());

        validate(input);

        return numOfLotto(input);
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR);
        }
    }

    private int numOfLotto(int money) {
        int num = money / 1000;
        return num;
    }
}
