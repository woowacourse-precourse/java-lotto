package lotto.controller;

import lotto.domain.LottoQuantity;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private List<Integer> userLottoNumbers;
    private int userLottoQuantity;
    private int userLottoMoney;
    private LottoQuantity lottoQuantity = new LottoQuantity();

    public void startLotto() {
        getUserMoney();
    }

    public void getUserMoney() {
        userLottoMoney=InputView.requestPurchaseMoney();
    }


    public void printLottoNumbers() {
        //service에서 구현하기
    }
}
