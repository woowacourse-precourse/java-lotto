package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.LottoConstants.*;

public class Computer {

    public static Lotto issueLotto() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_LENGTH);
        return new Lotto(lottoNumber);
    }
}
