package utils;

import lotto.Lotto;
import java.util.HashSet;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberLottoGenerator {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_CNT = 6;

    public Set<Integer> generate(){
        Set<Integer> lottoNumSet = new HashSet<>();

        while (lottoNumSet.size() != NUM_CNT){
            lottoNumSet.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        return lottoNumSet;
    }
}
