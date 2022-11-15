package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Result {

    private static HashMap<Reward, Integer> map = new HashMap<>();
    
    Result(List<Lotto> lottos, WinnersLotto winnersLotto)
    {
        for(Lotto lotto_ : lottos)
        {
            Reward reward = Reward.of(lotto_.getSameNum(winnersLotto),lotto_.isContaining(winnersLotto.getBonus()));
            map.merge(reward, 1, Integer::sum);
        }
    }
    
    public long getPrizeMoney()
    {
        long prizeMoney = 0;
        for(Reward reward : map.keySet())
        {
            prizeMoney += (long) reward.getPrize() * map.get(reward);
        }

        return prizeMoney;
    }

    public int getRank(final Reward rank) {
        return map.getOrDefault(rank, 0);
    }

    
}
