package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CheckLottoPrize {
    private static final int LOTTO_LENGTH = 6;
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private Integer bonusNumber;

    public CheckLottoPrize(List<Lotto> lottos, Lotto winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private String checkPrize(Lotto lotto) {
        lotto.get().retainAll(winningNumbers.get());
        int answerCount = LOTTO_LENGTH - lotto.get().size();
        PrizeRank[] values = PrizeRank.values();
        for (PrizeRank value : values) {
            if (value.getAnswerCount() == answerCount) {
                return value.name();
            }
        }
        return null;
    }
    /**
     * lottos를 반복문으로 돌려서 lotto를 checkPrize에 넣고
     * null이 아니면 map<등수, count>에 넣어서 count++
     * 를 하는 함수를 만들어
     */
}
