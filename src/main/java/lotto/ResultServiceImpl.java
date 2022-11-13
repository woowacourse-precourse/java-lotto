package lotto;

import java.util.List;
import java.util.Map;

public class ResultServiceImpl implements ResultService{
    @Override
    public int getCntOfMatchedNum(List<Integer> userNumList, List<Integer> newLotto) {
        int cntOfMatchedNum = 0;
        for (int num : newLotto) {
            if (userNumList.contains(num)) {
                cntOfMatchedNum++;
            }
        }
        return cntOfMatchedNum;
    }

    @Override
    public Map<Rank, Integer> getResult() {
        return null;
    }

    @Override
    public long getYield() {
        return 0;
    }
}
