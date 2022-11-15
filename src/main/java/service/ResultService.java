package service;

import domain.Rank;

import java.util.List;
import java.util.Map;

public interface ResultService {
    Map<Rank, Integer> getResult(List<Integer> listOfUserNum, List<List<Integer>> lottoList, int bonus);
    int getCntOfMatchedNum(List<Integer> listOfUserNum, List<Integer> newLotto);
    boolean isBonusMatched(List<Integer> newLotto, int bonus);
    double getYield(Map<Rank, Integer> result, int userPayment);
    void initiateResult();
}
