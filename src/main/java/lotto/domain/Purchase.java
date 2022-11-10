package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private int money = 0;
//    private List<List<Integer>> totalLotto = new ArrayList<>();
    private static final String PURCHASE_AMOUNT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String INPUT_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";

    public Purchase(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR);
        }
    }

    public void inputMoney() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int input = Integer.parseInt(Console.readLine());

        numOfLotto(input);
    }

    private int numOfLotto(int money) {
        int num = money / 1000;
        return num;
    }
}
