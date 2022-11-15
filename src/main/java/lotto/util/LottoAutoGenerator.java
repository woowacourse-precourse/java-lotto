package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoSetting;

import java.util.ArrayList;

public class LottoAutoGenerator {
    public static Lotto generate() {
        return new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoSetting.LOTTO_MIN_NUMBER.getSetting(), LottoSetting.LOTTO_MAX_NUMBER.getSetting(), LottoSetting.LOTTO_NUMBER_COUNT.getSetting())));
    }
}
