package lotto;

import domain.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultServiceImpl implements ResultService{
    public static Map<Rank, Integer> result = new EnumMap<Rank, Integer>(Rank.class);

    @Override
    public Map<Rank, Integer> getResult(List<Integer> listOfUserNum, List<List<Integer>> lottoList, int bonus) {
        initiateResult();
        result = compare(listOfUserNum, lottoList, bonus);
        return result;
    }


    @Override
    public Map<Rank, Integer> compare(List<Integer> listOfUserNum, List<List<Integer>> lottoList, int bonus) {
        int cntOfMatchedNum = 0;
        for (List<Integer> lotto : lottoList) {
            cntOfMatchedNum = getCntOfMatchedNum(listOfUserNum, lotto, bonus);

            if (cntOfMatchedNum == 5 && isBonusMatched(lotto, bonus)) {
                result.put(Rank.SECOND, result.get(Rank.SECOND) + 1);
            } else if (cntOfMatchedNum >= 3) {
                result.put( Rank.getRank(cntOfMatchedNum), result.get( Rank.getRank(cntOfMatchedNum) ) + 1);
            }
        }
        return result;
    }


    @Override
    public int getCntOfMatchedNum(List<Integer> listOfUserNum, List<Integer> newLotto, int bonus) {
        int cntOfMatchedNum = 0;
        for (int num : newLotto) {
            if (listOfUserNum.contains(num)) {
                cntOfMatchedNum++;
            }
        }
        return cntOfMatchedNum;
    }



    @Override
    public boolean isBonusMatched(List<Integer> newLotto, int bonus) {
        for (int num : newLotto) {
            if ( num == bonus ) {
                return true;
            }
        }
        return false;
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
