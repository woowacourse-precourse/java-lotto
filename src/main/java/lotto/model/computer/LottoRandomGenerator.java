package lotto.model.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import lotto.model.resources.Lotto;

public class LottoRandomGenerator implements LottoGenerator {

    private static final int FIRST_NUMBER_INCLUSIVE = 1;
    private static final int LAST_NUMBER_INCLUSIVE = 45;

    @Override
    public Lotto generateNumber(int numberSize) {
        List<Integer> oneLottoTicket = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(FIRST_NUMBER_INCLUSIVE, LAST_NUMBER_INCLUSIVE, numberSize));
        return new Lotto(oneLottoTicket);
    }
}
