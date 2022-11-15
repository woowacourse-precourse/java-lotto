package lotto;


import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class LottoGenerator {

    public int calculatePurchasableCount(Money money) {
        return money.getMoney() / Constants.ONE_TICKET_PRICE;
    }

    public Lotto pickRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOWER_BOUND_OF_LOTTO_NUMBER, Constants.UPPER_BOUND_OF_LOTTO_NUMBER,
                Constants.LENGTH_OF_LOTTO_NUMBERS
        );
        return new Lotto(numbers);
    }

    public List<Lotto> makeQuickPickTicketsBy(Money money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int purchasableCount = calculatePurchasableCount(money);
        for (int i = 0; i < purchasableCount; i++) {
            lottoTickets.add(pickRandomNumbers());
        }
        return lottoTickets;
    }

}
