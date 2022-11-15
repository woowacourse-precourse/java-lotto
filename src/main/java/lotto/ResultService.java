package lotto;

import domain.Statistics;

import java.util.List;
import java.util.Map;

public interface ResultService {
    Map<Statistics, Integer> getResult(List<Integer> listOfUserNum, List<List<Integer>> lottoList, int bonus);
    Map<Statistics, Integer> compare(List<Integer> listOfUserNum, List<List<Integer>> lottoList, int bonus);
    int getCntOfMatchedNum(List<Integer> listOfUserNum, List<Integer> newLotto, int bonus);
    boolean isBonusMatched(List<Integer> newLotto, int bonus);
    double getYield(Map<Statistics, Integer> result, int userPayment);
    void initiateResult();
}