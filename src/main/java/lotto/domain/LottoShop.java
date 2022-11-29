package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public List<Lotto> purchase(Ticket ticket) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket.getCount(); i++) {
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return lottos;
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.START_NUMBER,
                LottoConstants.END_NUMBER,
                LottoConstants.LENGTH);
        return numbers;
    }
}
