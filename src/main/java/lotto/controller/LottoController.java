package lotto.controller;

import lotto.view.Input;

public class LottoController {
    private static int price;

    //로또 프로그램 실행 메서드
    public static void execute() {
        //금액 입력 받기
        LottoController.getPrice();
        //입력한 금액에 대한 로또 개수 구하기
    }

    public static void getPrice() {
        price = Input.inputPrice();
    }
}
