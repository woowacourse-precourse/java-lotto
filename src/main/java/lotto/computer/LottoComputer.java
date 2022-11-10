package lotto.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Money;
import lotto.computer.lottoNumber.LottoNumber;
import lotto.computer.repository.LottoRepository;

public class LottoComputer {

    LottoRepository lottoRepository;
    Money money;

    public LottoComputer(Money money) {
        this.lottoRepository = new LottoRepository();
        this.money = money;
    }

    public void buyLotto() {
        LottoNumber lottoNumber;
        for (int i = 0; i < money.moneyDivide1000(); i++) {
            lottoNumber = new LottoNumber(sortLotto(createLottoNumber()));
            lottoRepository.saveLotto(lottoNumber);
        }
    }

    public void prinAllLotto() {
        lottoRepository.printLotto();
    }

    public int howManyLotto() {
        return lottoRepository.sizeOfLotto();
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> sortLotto(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }
}
