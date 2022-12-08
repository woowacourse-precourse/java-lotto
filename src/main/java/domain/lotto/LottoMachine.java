package domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Money;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final int MONEY_UNIT = 1000;

    public Lottos makeLotteries(Money money) {
        List<Lotto> lotteries = new ArrayList<>();
        int sheets = money.getMoney() / MONEY_UNIT;
        for (int times = 0; times < sheets; times++) {
            Lotto lotto = makeRandomNumbers();
            lotteries.add(lotto);
        }
        return new Lottos(lotteries);
    }

    private Lotto makeRandomNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
