package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Prize, Integer> prizeTable = new HashMap<>();

    public void setPrizeTable(List<List<Integer>> results){
        for (List<Integer> result : results){
            Prize prize = findPrize(result.get(0), result.get(1));
            if (prize == null){
                continue;
            }
            if (prizeTable.containsKey(prize)){
                prizeTable.put(prize, prizeTable.get(prize)+1);
            }
            prizeTable.put(prize, 1);
        }
    }

    public Map<Prize, Integer> getPrizeTable(){
        return prizeTable;
    }

    public Prize findPrize(int matches, int bonus){
        if (matches == Prize.SECOND.getMatches() && bonus == 1){
            return Prize.SECOND;
        }
        if (matches == Prize.SECOND.getMatches()){
            return Prize.THIRD;
        }

        for (Prize prize: Prize.values()){
            if (prize.getMatches() == matches){
                return prize;
            }
        }
        return null;
    }
}
