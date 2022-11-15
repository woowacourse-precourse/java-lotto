package lotto.Generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int LOTTO_LENGTH = 6;

    public List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<Integer>();
        while (lottoNumber.size() < LOTTO_LENGTH) {
            Integer randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber);
            }
        }

        Collections.sort(lottoNumber);

        return lottoNumber;
    }

    

}
