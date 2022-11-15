package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final WinningLotto winningLotto;

    public String getResult() {
        return Rank.FIFTH.getMessage() + " - " + result.get(Rank.FIFTH) +"개\n" +
                Rank.FOURTH.getMessage() + " - " + result.get(Rank.FOURTH) + "개\n" +
                Rank.THIRD.getMessage() + " - " + result.get(Rank.THIRD) + "개\n" +
                Rank.SECOND.getMessage() + " - " + result.get(Rank.SECOND) + "개\n" +
                Rank.FIRST.getMessage() + " - " + result.get(Rank.FIRST) + "개";
    }

    private final Map<Rank, Integer> result = new HashMap<>();

    public WinningResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
    }

    public void calcRank(List<Lotto> lottos) {
        for(int i=0; i<lottos.size(); i++) {
            countLottoOne(lottos.get(i));
        }
    }
    
    public int calcReward() {
        int reward = 0;
        for(Map.Entry<Rank, Integer> entry : result.entrySet()) {
            reward += entry.getKey().getMoney() * entry.getValue();
        }
        return reward;
    }

    private void countLottoOne(Lotto lotto) {
        boolean bonusFlag = false;
        int count = 0;
        List<Integer> numbers = lotto.getNumbers();
        for(Integer num : numbers) {
            if(winningLotto.getNumbers().contains(num))
                count++;
            if(winningLotto.getBonus() == num)
                bonusFlag = true;
        }
        Rank rank = countRankOne(count, bonusFlag);
        if (rank != Rank.NONE) {
            Integer integer = result.get(rank);
            result.put(rank, integer + 1);
        }
    }

    private Rank countRankOne(int count, boolean bonusFlag) {
        if(count == Rank.FIRST.getCount())
            return Rank.FIRST;
        else if(count == Rank.SECOND.getCount() && bonusFlag)
            return Rank.SECOND;
        else if(count == Rank.THIRD.getCount())
            return Rank.THIRD;
        else if(count == Rank.FOURTH.getCount())
            return Rank.FOURTH;
        else if(count == Rank.FIFTH.getCount())
            return Rank.FIFTH;
        else
            return Rank.NONE;
    }
}
