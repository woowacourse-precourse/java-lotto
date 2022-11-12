package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.List;

public class LotteryWheel {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int NUMBERS_COUNT = 7;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public LotteryWheel() {
        List<Integer> lotteryNumbers = pickWinningLotteryNumbers();
        this.bonusNumber = lotteryNumbers.remove(NUMBERS_COUNT);
        this.winningLotto = new Lotto(lotteryNumbers);
    }

    private List<Integer> pickWinningLotteryNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBERS_COUNT);
    }
}
