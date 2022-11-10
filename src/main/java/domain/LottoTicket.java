package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.NumberConstant.LOTTO_LENGTH;
import static constant.NumberConstant.LOTTO_MIN_VALUE;
import static constant.NumberConstant.LOTTO_MAX_VALUE;

public class LottoTicket {

    public Lotto generate(){
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < LOTTO_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE);
            if (!lottoNumbers.contains(randomNumber)) lottoNumbers.add(randomNumber);
        }
        return new Lotto(lottoNumbers);
    }


}
