package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> makeLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() <= 6) {
            int random = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumbers.contains(random)) {
                lottoNumbers.add(random);
            }
        }
        return lottoNumbers;
    }


}
