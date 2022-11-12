package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.common.constant.NumberConstant.LOTTO_LENGTH;
import static lotto.common.constant.NumberConstant.LOTTO_MIN_VALUE;
import static lotto.common.constant.NumberConstant.LOTTO_MAX_VALUE;

public class LottoTicket {

    public static Lotto generate(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_LENGTH);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

}
