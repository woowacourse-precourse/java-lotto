package lotto.Entity;

import lotto.util.MatchMoney;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultLotto {
    private Map<MatchMoney, Integer> map = new LinkedHashMap<>();

    public ResultLotto(){
        Arrays.stream(MatchMoney.values()).forEach(x -> map.put(x,0));
    }

    public void addMatchMoney(MatchMoney matchMoney){
        if(matchMoney == null) return;
        map.put(matchMoney, map.getOrDefault(matchMoney,0)+1);
    }

    public Map<MatchMoney, Integer> getMap() {
        return map;
    }

    public String calYield(int buyMoney){
        double result = (double)sumTotalMoney() / (double)buyMoney;
        return String.format("%.1f",result*100);
    }
}
