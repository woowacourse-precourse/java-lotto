package lotto.controller;

import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private List<Integer> userLottoNumbers;
    private int userLottoQuantity;
    private int userLottoMoney;

    public void startLotto() {
        getUserMoney();
    }

    public void getUserMoney() {
        InputView.requestPurchaseMoney();
        //userLottoMoney= Integer.parseInt(Console.readLine());
    }

    public void printLottoNumbers() {
        //service에서 구현하기
    }
}
