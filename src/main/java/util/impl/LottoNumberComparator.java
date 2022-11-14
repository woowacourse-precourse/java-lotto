package util.impl;

import util.Comparator;
import util.RankType;

import java.util.List;

public class LottoNumberComparator implements Comparator {
    private final int MAX_LOTTO_COUNT = 7;
    @Override
    public int doIntCompare(List<Integer> standard, List<Integer> target) {
        int count = comparetoTarget(standard, target);
        if(count == 6){
            if(target.contains(standard.get(6))) {
                return RankType.SECCOND.ordinal();
            }
            return RankType.FIRST.ordinal();
        }
        if(count < 3) {
            return RankType.NONE.ordinal();
        }
        return count-2;
    }

    public int comparetoTarget(List<Integer> standard, List<Integer> target) {
        int count = 0;
        for(int i = 0 ; i < MAX_LOTTO_COUNT ; i++) {
            if(target.contains(standard.get(i))) {
                count += 1;
            }
        }
        return count;
    }
}
