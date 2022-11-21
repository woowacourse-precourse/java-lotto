package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Result {

    private static Map<ResultType,Integer> allResults = new HashMap<>();

    public void initMap(){
        for(ResultType resultType:ResultType.values()){
            allResults.put(resultType,0);
        }
    }

    public Map<ResultType,Integer> calculateLotto(List<Lotto> input, List<Integer> winning, String bonus){
        int check = 0;
        boolean checkBonus = false;
        initMap();
        for(int i=0; i<input.size(); i++){
            check = compareLotto(input.get(i), winning);
            checkBonus = compareBonus(input.get(i),bonus);
            saveResult(check,checkBonus);
        }
        return allResults;
    }
    private void saveResult(int check, boolean checkBonus) {
        ResultType resultType = makeTotalWinnings(check, checkBonus);
        if(allResults.containsKey(resultType))
            allResults.put(resultType,allResults.get(resultType)+1);

    }

    public int compareLotto(Lotto lotto, List<Integer> winning) {
        int check = 0;
        for(int i = 0; i< lotto.getLotto().size(); i++){
            if(winning.contains(lotto.getLotto().get(i))){
                check++;
            }
        }
        return check;
    }

    public boolean compareBonus(Lotto lotto, String bonus){
//        if(lotto.getLotto().contains(Integer.parseInt(bonus))){
//            return true;
//        }
//        return false;
        return lotto.getLotto().contains(Integer.parseInt(bonus));
    }

    public double calculateProfit(int purchase, int win){
        return Double.valueOf((double) win/purchase)*100;
    }

    public ResultType makeTotalWinnings(int check, boolean bonus){
        if(check==6)
            return ResultType.SIX;
        if(check==5&&bonus==true)
            return ResultType.FIVEPLUS;
        if(check==5)
            return ResultType.FIVE;
        if(check==4)
            return ResultType.FOUR;
        if(check==3)
            return ResultType.THREE;

        return ResultType.NOWINNING;
    }

    public int makePrize(Map<ResultType,Integer> result){
        int total = 0;
        Iterator<ResultType> keys = result.keySet().iterator();
        while(keys.hasNext()){
            ResultType key = keys.next();
            if(result.get(key) != 0){
                total += key.getWinnings() * result.get(key);
            }
        }
        return total;
    }
    public void printResult(Map<ResultType,Integer> result){
        for(ResultType resultType: ResultType.values()){
            if(resultType!=ResultType.NOWINNING)
                System.out.println(resultType.getDetail()+ " - "+result.get(resultType)+"개");
        }
    }
}
