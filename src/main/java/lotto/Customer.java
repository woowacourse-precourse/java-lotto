package lotto;

import java.util.List;
import lotto.machine.LottoChecker;
import lotto.machine.LottoKiosk;

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
