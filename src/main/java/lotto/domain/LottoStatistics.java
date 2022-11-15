package lotto.domain;

import lotto.utils.FormatYieldNumber;

import java.util.Map;

import static lotto.domain.LottoReward.*;

public class LottoStatistics {
    private static final String LINE_FEED = "\n";
    private static final String PIECE = "개";
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private final Map<Lotto, Integer> rank;

    public LottoStatistics(Map<Lotto, Integer> rank, int bonusNumber) {
        this.rank = rank;
        rank.entrySet().forEach(lottoTicket -> countWinningLotto(bonusNumber, lottoTicket));
    }

    private void countWinningLotto(int bonusNumber, Map.Entry<Lotto, Integer> lottoTicket) {
        if (isRightLottoNumberCount(lottoTicket, FIRST.getMatchCount())) {
            first++;
        }
        if (isRightLottoNumberCount(lottoTicket, SECOND.getMatchCount()) &&
                isBonusNumberContain(lottoTicket, bonusNumber)) {
            second++;
        }
        if (isRightLottoNumberCount(lottoTicket, THIRD.getMatchCount()) &&
                !isBonusNumberContain(lottoTicket, bonusNumber)) {
            third++;
        }
        if (isRightLottoNumberCount(lottoTicket, FOURTH.getMatchCount())) {
            fourth++;
        }
        if (isRightLottoNumberCount(lottoTicket, FIFTH.getMatchCount())) {
            fifth++;
        }
    }

    private static boolean isRightLottoNumberCount(Map.Entry<Lotto, Integer> lottoTicket, int rightNumber) {
        return lottoTicket.getValue() == rightNumber;
    }

    private static boolean isBonusNumberContain(Map.Entry<Lotto, Integer> lottoTicket, int bonusNumber) {
        return lottoTicket.getKey().getNumbers().contains(bonusNumber);
    }

    public String getYield() {
        return FormatYieldNumber.get((double) (this.first * FIRST.getReward() +
                this.second * SECOND.getReward() +
                this.third * THIRD.getReward() +
                this.fourth * FOURTH.getReward() +
                this.fifth * FIFTH.getReward()) / (this.rank.size() * LOTTO_PRICE) * PERCENTAGE);
    }

    @Override
    public String toString() {
        return FIFTH.getRewardMessage() + fifth + PIECE + LINE_FEED +
                FOURTH.getRewardMessage() + fourth + PIECE + LINE_FEED +
                THIRD.getRewardMessage() + third + PIECE + LINE_FEED +
                SECOND.getRewardMessage() + second + PIECE + LINE_FEED +
                FIRST.getRewardMessage() + first + PIECE;
    }
}