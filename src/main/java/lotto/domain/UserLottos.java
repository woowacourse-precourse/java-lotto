package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class UserLottos {
    private static final String USER_LOTTO_ERROR_MESSAGE ="[ERROR] 1000원 단위로 돈을 넣어주세요.";
    private static final int LOTTO_PRICE = 1000;
    private final int count;
    private final int money;
    private final Set<Lotto> userLottos;

    public UserLottos(int money) {
        validateMoney(money);
        this.money = money;
        this.count = setCount(money);
        this.userLottos = createLottos(count);
    }

    public void validateMoney(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(USER_LOTTO_ERROR_MESSAGE);
        }
    }

    public int setCount(int money) {
        return money / LOTTO_PRICE;
    }

    public Set<Lotto> createLottos(int count) {
        Set<Lotto> userLottos = new HashSet<>();

        while (userLottos.size() != count) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            userLottos.add(lotto);
        }
        return userLottos;
    }

    //getter 모음
    public Set<Lotto> getUserLottos() {
        return userLottos;
    }

    public int getLottoCount() {
        return count;
    }

    public int getUserLottosMoney() {
        return money;
    }
}
