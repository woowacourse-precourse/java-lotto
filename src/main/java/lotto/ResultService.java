package lotto;

import java.util.List;
import java.util.Map;

public interface ResultService {
    int getCntOfMatchedNum(List<Integer> userNumList, List<Integer> newLotto);
    Map<Rank, Integer> getResult();
    long getYield();
}
