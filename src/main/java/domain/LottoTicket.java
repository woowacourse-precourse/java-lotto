package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static constant.NumberConstant.LOTTO_LENGTH;
import static constant.NumberConstant.LOTTO_MIN_VALUE;
import static constant.NumberConstant.LOTTO_MAX_VALUE;

public class LottoTicket {

    public static Lotto generate(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_LENGTH);
        return new Lotto(lottoNumbers);
    }


}
