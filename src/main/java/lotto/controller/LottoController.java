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
    public Lottos lottos=new Lottos(userLottoQuantity);
    public LottoQuantity lottoQuantity=new LottoQuantity();
    public void startLotto() {
        getUserMoney();
        printLottoQuantity();
        printLottos();
        getUserLottoNumbers();
        getUserBonusNumber();
        System.out.println("userLottoNumbers: "+userLottoNumbers);
    }

    public void getUserMoney() {
        userLottoMoney=InputView.requestPurchaseMoney();
    }


    public void printLottoQuantity() {
        LottoQuantity lottoQuantity=new LottoQuantity();
        lottoQuantity.setLottoQuantityNumber(userLottoMoney/1000);
        userLottoQuantity=lottoQuantity.getLottoQuantityNumber();
        OutputView.printPurchaseLottoSet(userLottoQuantity);
    }
    public void printLottos(){
        lottos.initLottos(userLottoQuantity);
        OutputView.printPurchaseLottoNumbers(lottos.getLottos());
    }

    public void getUserLottoNumbers(){
        userLottoNumbers = InputView.requestLottoNumbers();
        //System.out.println("userLottoNumbers: "+userLottoNumbers);
    }
    public void getUserBonusNumber(){
        userLottoNumbers.add(InputView.requestBonusNumber());
    }
}
