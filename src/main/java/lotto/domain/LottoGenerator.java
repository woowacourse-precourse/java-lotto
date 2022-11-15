package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Lotto> createLottos(Ticket tickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int ticket = 0; ticket < tickets.getTickets(); ticket++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
