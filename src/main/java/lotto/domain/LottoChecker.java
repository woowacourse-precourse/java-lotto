package lotto.domain;

import lotto.config.LottoConfig;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoChecker(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoReward> calculate(List<Lotto> lottos) {
        List<LottoReward> lottoRewards = new ArrayList<>();

        lottos.forEach((lotto) -> {
            List<Integer> numbers = lotto.getNumbers();
            int count = checkNumber(numbers);
            boolean hasBonusNumber = checkBonusNumber(numbers);
            lottoRewards.add(checkLotto(count, hasBonusNumber));
        });

        return lottoRewards;
    }

    private LottoReward checkLotto(int count, boolean hasBonusNumber) {
        if (count >= 3) {
            return LottoReward.getAward(count, hasBonusNumber);
        }
        return LottoReward.EMPTY;
    }

    private boolean checkBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private int checkNumber(List<Integer> numbers) {
        int count = 0;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        for (int i = 0; i < LottoConfig.NUMBER_COUNT; i++) {
            if (winningLottoNumbers.contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
