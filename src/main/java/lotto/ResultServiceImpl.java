package lotto;

import domain.Statistics;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultServiceImpl implements ResultService{
    public static Map<Statistics, Integer> result = new EnumMap<Statistics, Integer>(Statistics.class);

    @Override
    public Map<Statistics, Integer> getResult(List<Integer> listOfUserNum, List<List<Integer>> lottoList, int bonus) {
        initiateResult();
        result = compare(listOfUserNum, lottoList, bonus);
        return result;
    }


    @Override
    public Map<Statistics, Integer> compare(List<Integer> listOfUserNum, List<List<Integer>> lottoList, int bonus) {
        int cntOfMatchedNum = 0;
        for (List<Integer> lotto : lottoList) {
            cntOfMatchedNum = getCntOfMatchedNum(listOfUserNum, lotto, bonus);

            if (cntOfMatchedNum == 5 && isBonusMatched(lotto, bonus)) {
                result.put(Statistics.SECOND, result.get(Statistics.SECOND) + 1);
            } else if (cntOfMatchedNum >= 3) {
                result.put( Statistics.getStatistics(cntOfMatchedNum), result.get( Statistics.getStatistics(cntOfMatchedNum) ) + 1);
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
    public double getYield(Map<Statistics, Integer> result, int userPayment) {
        double totalPrize = 0;
        double yield = 0;

        for (Statistics statistics : Statistics.values()) {
            totalPrize += ( result.get(statistics) * statistics.getPrize() );
        }

        yield = totalPrize / userPayment * 100;
        return yield;
    }



    @Override
    public void initiateResult() {
        for (Statistics statistics : Statistics.values()) {
            result.put(statistics, 0);
        }
    }

}