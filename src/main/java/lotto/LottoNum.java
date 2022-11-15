package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class LottoNum {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private static final String NUMBER_RANGE_ERROR = "로또 숫자는 " + MIN + " 이상 " + MAX + " 이하의 숫자만 가능합니다.";


    public List<Lotto> makeLottosBy(int Amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < Amount; ++index) {
            List<Integer> lottoCandidate =
                    Randoms.pickUniqueNumbersInRange(
                            MIN, MAX, 6);
            lottos.add(new Lotto(lottoCandidate));
        }
        return lottos;
    }

}
