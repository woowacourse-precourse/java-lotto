package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private static final int LOTTERY_PRICE = 1000;
    List<Lotto> lotto = new ArrayList<>();

    public void setLotto(int money) {
        while (money != 0) {
            lotto.add(new Lotto(setLottoNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList())));
            money -= LOTTERY_PRICE;
        }
    }

    private List<Integer> setLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
