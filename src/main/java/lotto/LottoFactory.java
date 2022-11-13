package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

    public List<Integer> randomLottoNumbers() {
        return Collections.unmodifiableList(randomLottoNumbers);
    }
}