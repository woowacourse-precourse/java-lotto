package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;

import static lotto.domain.LottoSetting.*;

public class LottoAutoGenerator {
    public static Lotto generate() {
        return new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER.getSetting(), LOTTO_MAX_NUMBER.getSetting(), LOTTO_NUMBER_COUNT.getSetting())));
    }
}
