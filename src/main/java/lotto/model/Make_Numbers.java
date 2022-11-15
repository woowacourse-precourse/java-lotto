package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Make_Numbers {
    Constant constant;

    private List<Integer> make_Numbers() {
        int number_start = constant.LOTTO_RANGE_START.getNum();
        int number_end = constant.LOTTO_RANGE_END.getNum();
        int number_cnt = constant.LOTTO_NUMBER_CNT.getNum();
        return Randoms.pickUniqueNumbersInRange(number_start, number_end, number_cnt);
    }

    public List<Lotto> make_RandomLotto(int lottoCnt) {
        List<Lotto> RandomLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            RandomLottoNumbers.add(new Lotto(make_Numbers()));
        }
        return RandomLottoNumbers;
    }
}