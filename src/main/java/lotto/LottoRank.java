package lotto;

import lotto.constant.Rank;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRank {
    private EnumMap<Rank, Integer> lottoRank = new EnumMap<>(Rank.class);

    public LottoRank(LottoCollection lottoCollection, WinningNumber winningNumber) {
        for (Rank value : Rank.values()) {
            lottoRank.put(value, 0);
        }
        makeRankInfo(lottoCollection, winningNumber);
    }

    public EnumMap<Rank, Integer> makeRankInfo(LottoCollection lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos.copyCollection()) {
            Rank ranks = Rank.judgeRank(lotto.compareWinNum(winningNumber), lotto.containBonusNum(winningNumber));
            lottoRank.compute(ranks, (Enum, count) -> count + 1);
        }
        return lottoRank;
    }

    public List<Rank> reverseByReward() {
        /* 3개 미만 일치 시 출력하지 않고 5등부터 역순으로 출력하기 위함*/
        return lottoRank.keySet().
                stream().
                filter(rank -> !rank.equals(Rank.NOT_WINNING)).
                sorted(Comparator.comparingInt(Rank::getReward)).
                collect(Collectors.toList());
    }

    public int calculateRewardWithRank() {
        int reward = 0;
        for (Rank rank : lottoRank.keySet()) {
            reward += rank.getReward() * lottoRank.get(rank);
        }
        return reward;
    }

    public EnumMap<Rank, Integer> getLottoRank() {
        return lottoRank;
    }

    public int getRankCount(Rank rank) {
        return lottoRank.get(rank);
    }

}
