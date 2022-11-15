package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningAnalyzer {
    //key : RANK 등수, value : 해당 등수인 로또 티켓 갯수
    private final Map<Rank,Integer> result;

    public WinningAnalyzer() {
        this.result = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }
    public double calculateRate(Map<Rank,Integer> result,int inputMoney){
        int total = 0;
        for(Rank rank:result.keySet()){
            total += rank.getMoney() * result.get(rank);
        }
        return total / (double)inputMoney * 100;
    }


    public void compareAllLottos(WinningLotto winningLotto, List<Lotto> userlottos){
        for(Lotto lotto:userlottos){
            Rank rank = winningLotto.match(lotto);
            result.put(rank, result.get(rank) +1);
        }
    }

    public Map<Rank, Integer> getResult(){
        return result;
    }


}
