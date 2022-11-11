package model;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
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
        return money.getMoney() / Config.PRICE;
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}