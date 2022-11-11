package lotto.utils;

import java.util.Arrays;

public class InputValidation {

    public void checkNumber(String input) {
        String[] split = input.split("");

        boolean result = Arrays.stream(split).allMatch((alphbet) -> alphbet.charAt(0) >= '0' && alphbet.charAt(0) <= '9');
        if (!result)
            throw new IllegalArgumentException("[ERROR] 구매금액은 숫자여야만 합니다.");
    }

    public void checkThousandMoney(String input) {
        int price = Integer.parseInt(input);

        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위여야 합니다.");
    }
}
