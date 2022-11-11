package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public List<Lotto> generate(Integer ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<Lotto>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
            return lottoTickets;
    }

    private void printGeneratedLotto(List<Lotto> generatedLotto) {
        return;
    }
}
