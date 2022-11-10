package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private final Integer price;
    private final static String ENTER_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public Purchase() {
        System.out.println(ENTER_PURCHASE_PRICE_MESSAGE);
        String input = Console.readLine();
        Integer price = Integer.valueOf(input);
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
