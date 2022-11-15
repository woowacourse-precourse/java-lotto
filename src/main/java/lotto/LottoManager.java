package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_COUNT = 6;

    public List<Integer> makeRandomLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_COUNT);
    }
}
