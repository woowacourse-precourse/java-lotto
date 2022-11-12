package lotto.controller;

import lotto.domain.LottoQuantity;
import lotto.domain.LottoRanking;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public List<Integer> userLottoNumbers;
    public int userLottoQuantity;
    public int userLottoMoney;
    public Lottos lottos=new Lottos(userLottoQuantity);
    public LottoQuantity lottoQuantity=new LottoQuantity();
    public Map<LottoRanking, Integer> lottoRanking;
    public void startLotto() {
        getUserMoney();
        printLottoQuantity();
        printLottos();
        getUserLottoNumbers();
        getUserBonusNumber();
        System.out.println("userLottoNumbers: "+userLottoNumbers);
        compareLottos();
        System.out.println("ranking: "+lottoRanking);
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

    public void compareLottos(){
        lottoRanking=lottos.calculateLottos(userLottoNumbers);
    }
}
