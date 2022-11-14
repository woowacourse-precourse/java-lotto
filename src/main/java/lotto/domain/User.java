package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private final int money;
    private final List<Lotto> userLottos;

    public int getMoney() {
        return money;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public User(int money) {
        moneyValidate(money);
        this.money = money;
        userLottos = new ArrayList<>();
        for (int i = ZERO; i < countingLottos(money); i++) {
            Lotto lotto = new Lotto(pickNumberForLotto());
            userLottos.add(lotto);
        }
    }

    private void moneyValidate(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private int countingLottos(int money) {
        return money / LOTTO_PRICE;
    }
    
    private List<Integer> pickNumberForLotto() {
        return Randoms.pickUniqueNumbersInRange(RANGE_MIN, RANGE_MAX, LOTTO_SIZE)
                .stream().sorted().collect(Collectors.toList());
    }
    
}
