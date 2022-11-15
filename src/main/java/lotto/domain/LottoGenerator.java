package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {

    public Lotto generateLotto(){
        int MIN_LOTTO_NUM = 1;
        int MAX_LOTTO_NUM = 45;
        int LOTTO_LENGTH = 6;
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_LENGTH));
    }
}
