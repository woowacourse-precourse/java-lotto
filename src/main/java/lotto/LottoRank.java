package lotto;

import lotto.constant.Rank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

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





}
