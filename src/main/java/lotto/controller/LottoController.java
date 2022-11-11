package lotto.controller;

import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public List<Integer> userLottoNumbers;
    public int userLottoQuantity;
    public int userLottoMoney;
    public Lottos lottos;
    public LottoQuantity lottoQuantity=new LottoQuantity();
    public void startLotto() {
        getUserMoney();
        printLottoQuantity();
    }

    public void getUserMoney() {
        userLottoMoney=InputView.requestPurchaseMoney();
    }


    public void printLottoQuantity() {
        LottoQuantity lottoQuantity=new LottoQuantity();
        lottoQuantity.setLottoQuantityNumber(userLottoMoney/10);
        userLottoQuantity=lottoQuantity.getLottoQuantityNumber();
    }
    public void printLottos(){
        lottos.initLottos(userLottoQuantity);
        OutputView.printPurchaseLottoNumbers(lottos.getLottos());
    }
}
