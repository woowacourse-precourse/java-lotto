package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class ServiceInput {

    public static List<Integer> getLottoNumbers(){

        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.LOTTO_SIZE)
        );

        return numbers;
    }
}
