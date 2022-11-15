package lotto.utill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YieldResult {
    private final WinningLotto winningLotto;

    public String getResult() {
        return Rank.FIFTH.getMessage() + " - " + result.get(Rank.FIFTH) +"개\n" +
                Rank.FOURTH.getMessage() + " - " + result.get(Rank.FOURTH) + "개\n" +
                Rank.THIRD.getMessage() + " - " + result.get(Rank.THIRD) + "개\n" +
                Rank.SECOND.getMessage() + " - " + result.get(Rank.SECOND) + "개\n" +
                Rank.FIRST.getMessage() + " - " + result.get(Rank.FIRST) + "개";
    }

    private final Map<Rank, Integer> result = new HashMap<>();

    public YieldResult(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
    }

    public void calcRank(List<Lotto> lottos) {
        for(int i=0; i<lottos.size(); i++) {
            countLotto(lottos.get(i));
        }
    }

    public int calcReward() {
        int reward = 0;
        for(Map.Entry<Rank, Integer> entry : result.entrySet()) {
            reward += entry.getKey().getMoney() * entry.getValue();
        }
        return reward;
    }

    private void countLotto(Lotto lotto) {
        boolean bonusFlag = false;
        int count = 0;
        Lotto win = winningLotto.getLotto();
        List<Integer> numbers = lotto.getNumbers();
        for(Integer num : numbers) {
            if(win.getNumbers().contains(num))
                count++;
            if(winningLotto.getBonus() == num)
                bonusFlag = true;
        }
        Rank rank = countRank(count, bonusFlag);
        if (rank != Rank.NONE) {
            Integer integer = result.get(rank);
            result.put(rank, integer + 1);
        }
    }

    private Rank countRank(int count, boolean bonusFlag) {
        if(count == 6)
            return Rank.FIRST;
        else if(count == 5 && bonusFlag)
            return Rank.SECOND;
        else if(count == 5)
            return Rank.THIRD;
        else if(count == 4)
            return Rank.FOURTH;
        else if(count == 3)
            return Rank.FIFTH;
        else
            return Rank.NONE;
    }
}
