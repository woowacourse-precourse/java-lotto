package lotto.model;

import static lotto.controller.LottoSystem.LOTTO_PRICE;

public class MoneyParser {
    public int parse(String input) throws IllegalArgumentException {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 금액은 0으로 시작할 수 없습니다.");
        }
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 금액은 %d원 단위로 입력하세요.", LOTTO_PRICE));
        }
        return money;
    }
}