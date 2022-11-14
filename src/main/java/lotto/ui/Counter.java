package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Counter {
    private static final String inputPriceMessage = "구입 금액을 입력해 주세요.";

    public int inputPrice() {
        System.out.println(inputPriceMessage);
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
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        return price;
    }
}
