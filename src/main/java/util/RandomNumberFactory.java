package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberFactory {
    private Integer startInclusive;
    private Integer endInclusive;
    private Integer count;

    public RandomNumberFactory(Integer start, Integer end, Integer count) {
        this.startInclusive = start;
        this.endInclusive = end;
        this.count = count;
    }
    
    public List<Integer> makeUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(this.startInclusive, this.endInclusive, this.count);
    }
}
