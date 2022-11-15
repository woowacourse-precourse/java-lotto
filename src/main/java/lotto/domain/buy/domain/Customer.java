package lotto.domain.buy.domain;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

    static final String ERROR_ONLY_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    static final String ERROR_ONLY_THOUSANDS = "[ERROR] 로또 구입은 1,000원 단위로만 가능합니다.";
    static final int LOTTO_PRICE = 1000;
    public final int count;
    final int price;

    public Customer() {
        String tmp = Console.readLine();
        try {
            price = Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        validate(price);
        this.count = price / LOTTO_PRICE;
    }

    private void validate(int price) {
        if (price % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ERROR_ONLY_THOUSANDS);
    }
}
