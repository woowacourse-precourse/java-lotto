package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultServiceImpl implements ResultService{
    public static Map<Rank, Integer> result = new EnumMap<Rank, Integer>(Rank.class);

    @Override
    public Map<Rank, Integer> getResult(List<Integer> listOfUserNum, int cntOfLotto, List<List<Integer>> lottoList) {
        int cntOfMatchedNum = 0;
        Rank rank;
        initiateResult();

        for (List<Integer> lotto : lottoList) {
            cntOfMatchedNum = getCntOfMatchedNum(listOfUserNum, lotto);
            if (cntOfMatchedNum >= 3) {
                rank = Rank.getRank(cntOfMatchedNum);
                result.put(rank, result.get(rank) + 1 );
            }
        }
        return result;
    }




    @Override
    public int getCntOfMatchedNum(List<Integer> listOfUserNum, List<Integer> newLotto) {
        int cntOfMatchedNum = 0;
        for (int num : newLotto) {
            if (listOfUserNum.contains(num)) {
                cntOfMatchedNum++;
            }
        }
        return cntOfMatchedNum;
    }




    @Override
    public double getYield(Map<Rank, Integer> result, int userPayment) {
        double totalPrize = 0;
        double yield = 0;

        for (Rank rank : Rank.values()) {
            totalPrize += ( result.get(rank) * rank.getPrize() );
        }

        yield = totalPrize / userPayment * 100;
        return yield;
    }



    @Override
    public void initiateResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }


}
