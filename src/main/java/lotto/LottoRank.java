package lotto;

import lotto.constant.Rank;

import java.util.ArrayList;
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
        //비교하고 lottorank에 집어 넣어야 한다..
        //여기서 비교
        makeRankInfo(lottoCollection, winningNumber);
    }

    public EnumMap<Rank, Integer> makeRankInfo(LottoCollection lottoCollection, WinningNumber winningNumber) {
        for (Lotto lotto : lottoCollection.copyCollection()) {
            //lottoCollection, winningBonus와 lotto를 비교해서 몇개가일치하는지, 보너스 포함 여부
            Rank ranks = Rank.judgeRank(lotto.compareWinNum(winningNumber), lotto.containBonusNum(winningNumber));
            lottoRank.compute(ranks, (Enum, count) -> count + 1);
        }
        return lottoRank;
    }

    public List<Rank> reverseByReward(){
        /* 3개 미만 일치 시 출력하지 않고 5등부터 역순으로 출력하기 위함*/
        return lottoRank.keySet().stream().filter(rank -> !rank.equals(Rank.NOT_WINNING)).sorted(Comparator.comparingInt(Rank::getReward)).collect(Collectors.toList());
    }

    public EnumMap<Rank, Integer> getLottoRank() {
        return lottoRank;
    }
    public int getRankCount(Rank rank){
        return lottoRank.get(rank);
    }

}
