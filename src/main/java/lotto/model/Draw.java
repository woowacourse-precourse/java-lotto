package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Draw {
    Map<Rank, Integer> result = new HashMap<>();

    public Draw(){
        for(Rank rank : Rank.values()){
            result.put(rank,0);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void drawLotto(List<Lotto> lottos, List<Integer> priceNumbers, int bonusNumber){
        for(int i = 0; i < lottos.size(); i++){
            int matchNumberCount = 0;
            int checkBonus = 0;

            for(int j = 0; j < priceNumbers.size(); j++){
                if(lottos.get(i).getNumbers().contains(j)){
                    matchNumberCount++;
                }
            }

            if(lottos.get(i).getNumbers().contains(bonusNumber)){
                checkBonus = 1;
            }

            Rank rank = Rank.findByMatchNumber(matchNumberCount, checkBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public float calculateRate(int money){
        return calculateTotalProfit() / (float) money * 100L;
    }

    public float calculateTotalProfit(){
        float sum = 0;
        for(Map.Entry<Rank, Integer> entry : result.entrySet()){
            sum += Rank.valueOf(entry.getKey().toString()).getPriceMoney() * entry.getValue();
        }
        return sum;
    }
}
