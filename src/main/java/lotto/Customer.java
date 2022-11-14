package lotto;

import lotto.machine.LottoChecker;
import lotto.machine.LottoKiosk;

import java.util.List;

public class Customer {
    private List<Lotto> myLottos;

    public void insertMoney(LottoKiosk lottoKiosk) throws IllegalArgumentException {
        lottoKiosk.getMoney();
    }

    public void getLotto(List<Lotto> lottos) {
        this.myLottos = lottos;
    }

    public void insertLottos(LottoChecker lottoChecker){
        lottoChecker.insertLottos(myLottos);
    }
}
