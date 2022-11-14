package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class UserLottos {
    private final int LOTTO_PRICE = 1000;
    private int count;
    private Set<Lotto> userLottos;

    public UserLottos(int money) {
        validateMoney(money);
        setCount(money);
        createLottos(count);
    }

    public void validateMoney(int money) {
        if(money < LOTTO_PRICE || money%LOTTO_PRICE !=0) {
            throw new IllegalArgumentException();
        }
    }

    public void setCount(int money) {
        this.count = money/LOTTO_PRICE;
    }

    public void createLottos(int count) {
        userLottos = new HashSet<>();

        while (userLottos.size() != count) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            userLottos.add(lotto);
        }
    }

    public Set<Lotto> getUserLottos() {

        return userLottos;
    }

    public int getLottoCount() {

        return count;
    }
}
