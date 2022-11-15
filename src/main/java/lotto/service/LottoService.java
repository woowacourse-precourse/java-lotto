package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<Lotto> lotteries = new ArrayList<>();

    public LottoService() {

    }

    public void addLotteries(int buyNumber) {
        while (buyNumber != 0) {
            List<Integer> randomNumbers = Lotto.createRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lotteries.add(lotto);
            buyNumber--;
        }
    }
}
