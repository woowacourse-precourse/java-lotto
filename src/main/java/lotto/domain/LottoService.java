package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Util.Validation;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public static List<Lotto> generate(final int money) {
        int count = money / Validation.LOTTO_MONEY;
        List<Lotto> tickets = new ArrayList<>();

        for(int cnt = 1; cnt <= count; cnt++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return tickets;
    }
}
