package lotto;

import java.util.List;
import java.util.Map;

public interface ResultService {
    Map<Rank, Integer> getResult(List<Integer> listOfUserNum, int cntOfLotto, List<List<Integer>> lottoList);
    int getCntOfMatchedNum(List<Integer> listOfUserNum, List<Integer> newLotto);
    double getYield(Map<Rank, Integer> result, int userPayment);
    void initiateResult();
}
