package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Result {

    private static Map<ResultType,Integer> allResult = new HashMap<>(){{
        put(ResultType.THREE,0);
        put(ResultType.FOUR,0);
        put(ResultType.FIVE,0);
        put(ResultType.FIVEPLUS,0);
        put(ResultType.SIX,0);
    }};


    public Map<ResultType,Integer> calculateLotto(List<Lotto> input, List<Integer> winning, String bonus){
        int check = 0;
        boolean checkBonus = false;
        for(int i=0; i<input.size(); i++){
            check = compareLotto(input.get(i), winning);
            checkBonus = compareBonus(input.get(i),bonus);
            togetherResult(check,checkBonus);
        }
        return allResult;
    }
    private void togetherResult(int check, boolean checkBonus) {
        ResultType resultType = makeTotalWinnings(check, checkBonus);
        if(allResult.containsKey(resultType))
            allResult.put(resultType,allResult.get(resultType)+1);

    }



    private int compareLotto(Lotto lotto, List<Integer> winning) {
        int check = 0;
        for(int i = 0; i< lotto.getLotto().size(); i++){
            if(winning.contains(lotto.getLotto().get(i))){
                check++;
            }
        }
        return check;
    }

    private boolean compareBonus(Lotto lotto, String bonus){
        if(lotto.getLotto().contains(Integer.parseInt(bonus))){
            return true;
        }
        return false;
    }

    public double calculateRate(int purchase, int win){
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
    public void printResult(Map<ResultType,Integer> allResult){
        System.out.println(ResultType.THREE.getDetail() + " - " + allResult.get(ResultType.THREE) + "개");
        System.out.println(ResultType.FOUR.getDetail() + " - " + allResult.get(ResultType.FOUR) + "개");
        System.out.println(ResultType.FIVE.getDetail() + " - " + allResult.get(ResultType.FIVE) + "개");
        System.out.println(ResultType.FIVEPLUS.getDetail() + " - " + allResult.get(ResultType.FIVEPLUS) + "개");
        System.out.println(ResultType.SIX.getDetail() + " - " + allResult.get(ResultType.SIX) + "개");


    }

}
