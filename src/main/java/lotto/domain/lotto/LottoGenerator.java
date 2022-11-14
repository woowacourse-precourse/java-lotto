package lotto.domain.lotto;

import java.util.ArrayList;

public class LottoGenerator {

    public static Lotto createLottoWithRandomNumbers() {
        return new Lotto(new ArrayList<>());
    }
}
