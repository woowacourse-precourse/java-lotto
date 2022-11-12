package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.LottoInfo;

public class LottoFactory {
    public static Lotto generateLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(LottoInfo.START_NUMBER.getNumber(),
                        LottoInfo.END_NUMBER.getNumber(),
                        LottoInfo.LENGTH.getNumber()));
    }
}
