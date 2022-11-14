package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
    private static final int AMOUNT_UNIT = 1000;
    private final List<Lotto> lottos;

    public LotteryMachine() {
        lottos = new ArrayList<>();
    }

    public void buyLottos(int amount) {
        validateAmount(amount);
        drawLottos(amount / AMOUNT_UNIT);
    }

    private WinningStat compareNumbers(Lotto winningNumbers, int bonusNumber) {
        WinningStat winningStat = new WinningStat();
        lottos.forEach(x -> winningStat.add(x.countNumbers(winningNumbers), x.hasNumber(bonusNumber)));
        return winningStat;
    }

    private void drawLottos(int number) {
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    private void validateAmount(int amount) {
        if (amount % AMOUNT_UNIT != 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000단위여야 합니다.");
    }
}
