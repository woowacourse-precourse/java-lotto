package lotto.controller;

import lotto.view.Input;

public class LottoController {
    private static final int LOTTO_PRICE_DEFAULT_UNIT = 1000;
    private static int price;
    private static int lottoQuantity;

    public static void execute() {
        LottoController.getPrice();
        getLottoQuantity(price);
    }

    public static void getPrice() {
        price = Input.inputPrice();
    }

    public static void getLottoQuantity(int price) {
        lottoQuantity = price / LOTTO_PRICE_DEFAULT_UNIT;
    }
    
}
