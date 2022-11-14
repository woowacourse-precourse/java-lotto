package lotto.domain;

import java.util.*;
import java.util.stream.Stream;

public class Result {
    private int[][] result;
    private static Map<ResultType,Integer> allResult = new HashMap<>(){{
        put(ResultType.THREE,0);
        put(ResultType.FOUR,0);
        put(ResultType.FIVE,0);
        put(ResultType.FIVEPLUS,0);
        put(ResultType.SIX,0);
    }};

//    public int[][] calculateLotto(List<Lotto> input,List<Integer> winning, String bonus){
//        result = new int[input.size()][2];
//        for(int i=0; i<input.size(); i++){
//            compareLotto(input.get(i), winning,i);
//            compareBonus(input.get(i),bonus,i);
//        }
//        return result;
//    }

    public Map<ResultType,Integer> initMap(){
        allResult.put(ResultType.THREE,0);
        allResult.put(ResultType.FOUR,0);
        allResult.put(ResultType.FIVE,0);
        allResult.put(ResultType.FIVEPLUS,0);
        allResult.put(ResultType.SIX,0);

        return allResult;
    }

    public Map<ResultType,Integer> calculateLotto(List<Lotto> input,List<Integer> winning, String bonus){
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
//        if(!allResult.containsKey(resultType))
//            allResult.put(resultType,1);
    }

    private void compareLotto(Lotto lotto, List<Integer> winning, int i) {
        for(int j = 0; j< lotto.getLotto().size(); j++){
            if(winning.contains(lotto.getLotto().get(j))){
                result[i][0]++;
            }
        }
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

    private void compareBonus(Lotto lotto, String bonus, int i){
        if(lotto.getLotto().contains(Integer.parseInt(bonus))){
            result[i][1]++;
        }
    }
    public double calculateRate(double purchase, double win){
        return win/purchase;
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

    public Map<ResultType,Integer> makeTotalResult(int[][] result){
        Map<ResultType,Integer> totalResult = new HashMap<>();
        for(int i=0; i<result.length; i++){
            int cnt = 0;
            if(result[i][0] == 6)
                totalResult.put(ResultType.SIX,cnt++);
            if(result[i][0] == 5 && result[i][1]==1)
                totalResult.put(ResultType.FIVEPLUS,cnt++);
            if(result[i][0] == 5)
                totalResult.put(ResultType.FIVE,cnt++);
            if(result[i][0] == 4)
                totalResult.put(ResultType.FOUR,cnt++);
            if(result[i][0] == 3)
                totalResult.put(ResultType.THREE,cnt++);
        }
        return totalResult;
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
