package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LotteryWheel {
    private final List<Integer> winningLotto;

    public  LotteryWheel() {
        winningLotto = createWinningLotteryNumbers();
    }

    private List<Integer> createWinningLotteryNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
