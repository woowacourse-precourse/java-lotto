package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> makeLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() <= Lotto.WIN_NUMBER_SIZE) {
            int random = Randoms.pickNumberInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER);
            if (!lottoNumbers.contains(random)) {
                lottoNumbers.add(random);
            }
        }
        lottoNumbers.sort(Integer::compareTo);
        return lottoNumbers;
    }
}
