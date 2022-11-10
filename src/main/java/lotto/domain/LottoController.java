package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private int price;
    private static final int start_Range = 1;
    private static final int end_Range = 45;
    private static final int range = 6;

    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(start_Range,end_Range,range);
    }

}
