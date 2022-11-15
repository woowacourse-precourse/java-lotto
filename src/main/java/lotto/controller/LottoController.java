package lotto.controller;

import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private static final int LOTTO_PRICE_DEFAULT_UNIT = 1000;
    private static int price;
    private static int lottoQuantity;

    //로또 프로그램 실행 메서드
    public static void execute() {
        //금액 입력 받기
        LottoController.getPrice();
        //입력한 금액에 대한 로또 개수 구하기
        getLottoQuantity(price);
        //입력한 로또에 대한 출력 기능
        Output.printQuantity(lottoQuantity);
    }

    public static void getPrice() {
        price = Input.inputPrice();
    }

    public static void getLottoQuantity(int price) {
        lottoQuantity = price / LOTTO_PRICE_DEFAULT_UNIT;
    }
}
