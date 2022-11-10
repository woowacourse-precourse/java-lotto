package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private final Integer price;
    private final static String ENTER_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String ONLY_NUMBER = "^\\d+$";

    public Purchase() {
        System.out.println(ENTER_PURCHASE_PRICE_MESSAGE);
        String input = Console.readLine();
        validateIfNumeric(input);

        Integer price = Integer.valueOf(input);
        validateIfDividedByThousand(price);

        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    private void validateIfNumeric(String input) {
        boolean isNumber = input.matches(ONLY_NUMBER);
        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateIfDividedByThousand(Integer price) {
        final int expectedRemainder = 0;
        final int currencyUnit = 1000;
        if (price % currencyUnit != expectedRemainder) {
            throw new IllegalArgumentException("[ERROR] 금액은 천 원 단위만 입력할 수 있습니다.");
        }
    }
}
