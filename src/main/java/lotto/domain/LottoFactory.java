package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static Money money;

    public LottoFactory(Money money) {
        this.money = money;
    }

    public Lotto chooseNumbers() {
        List<Integer> chosenNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(chosenNumbers);
    }

    public List<Lotto> purchaseLottoTicket() {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int i = 0; i < money.numberOfTickets(); i++) {
            lottoTicket.add(chooseNumbers());
        }
        return lottoTicket;
    }
}