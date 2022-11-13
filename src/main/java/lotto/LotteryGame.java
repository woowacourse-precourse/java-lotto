package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryGame {
    private static final int AMOUNT_UNIT = 1000;
    private final List<Lotto> lottos;

    public LotteryGame() {
        lottos = new ArrayList<>();
    }

    public void buyLottos(int amount) {
        validateAmount(amount);
        getRandomNumbers(amount / AMOUNT_UNIT);
    }

    private void getRandomNumbers(int number) {
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    private void validateAmount(int amount) {
        if (amount % AMOUNT_UNIT != 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000단위여야 합니다.");
    }
}
