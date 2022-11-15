package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class User {
    private long amount;
    private List<Lotto> lottos;

    public User(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000 단위로 입력해야 합니다.");
        }
    }

    public void buyLotto() {
        long purchaseCount = amount / 1000;

        for (int purchaseIndex = 0; purchaseIndex < purchaseCount; purchaseIndex++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }
    }
}
