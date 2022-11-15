package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class Counter {
    private static final String inputAmountMessage = "구입 금액을 입력해 주세요.";

    public int inputAmount() {
        System.out.println(inputAmountMessage);
        return parseInput(Console.readLine());
    }

    private int parseInput(String input) {
        int result;

        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        return validation(result);
    }

    private int validation(int price) {
        if (price % Lotto.lottoPrice != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        return price;
    }
}
