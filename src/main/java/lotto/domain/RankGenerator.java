package lotto.domain;

import lotto.status.rank.RankBonusStatus;
import lotto.status.rank.RankMatchStatus;
import lotto.status.rank.RankRewardStatus;

import java.util.ArrayList;
import java.util.List;

public class RankGenerator {

    public static List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(new Rank(5, RankMatchStatus.rank5.getMatch(),
                RankRewardStatus.rank5.getReward(), RankBonusStatus.rank5.getBonus()));
        ranks.add(new Rank(4, RankMatchStatus.rank4.getMatch(),
                RankRewardStatus.rank4.getReward(), RankBonusStatus.rank4.getBonus()));
        ranks.add(new Rank(3, RankMatchStatus.rank3.getMatch(),
                RankRewardStatus.rank3.getReward(), RankBonusStatus.rank3.getBonus()));
        ranks.add(new Rank(2, RankMatchStatus.rank2.getMatch(),
                RankRewardStatus.rank2.getReward(), RankBonusStatus.rank2.getBonus()));
        ranks.add(new Rank(1, RankMatchStatus.rank1.getMatch(),
                RankRewardStatus.rank1.getReward(), RankBonusStatus.rank1.getBonus()));

        return ranks;
    }
}
