package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private static final int LOTTO_PRICE = 1000;
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
        for (int i = 0; i < countingLottos(money); i++) {
            Lotto lotto = new Lotto(pickNumberForLotto());
            userLottos.add(lotto);
        }
//        Stream<Lotto> stream = userLottos.stream().map(n -> new Lotto(pickNumberForLotto())).limit(5);
    }

    private void moneyValidate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private int countingLottos(int money) {
        return money / LOTTO_PRICE;
    }


    private List<Integer> pickNumberForLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream().sorted().collect(Collectors.toList());
    }
}
