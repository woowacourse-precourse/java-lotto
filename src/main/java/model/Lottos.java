package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static constant.Config.MAX_NUMBER;
import static constant.Config.MIN_NUMBER;
import static constant.Config.NUMBER_COUNT;
import static constant.Config.PRICE;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Money money) {
        this.lottos = new ArrayList<>();

        setLottos(money);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private void setLottos(Money money) {
        int count = getCount(money);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(getNumbers());
            lottos.add(lotto);
        }
    }

    private int getCount(Money money) {
        return money.getMoney() / PRICE;
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return List.copyOf(numbers);
    }

    public WinningResult getTotalWinningResult(WinningLotto winningLotto) {
        Map<Win, Integer> winningResults = new EnumMap<>(Win.class);

        for (Lotto lotto : lottos) {
            WinningResult winningResult = lotto.getWinningResult(winningLotto);
            winningResults.putAll(winningResult.getWinningResult());
        }

        return new WinningResult(winningResults);
    }
}