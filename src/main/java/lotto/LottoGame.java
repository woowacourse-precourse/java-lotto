package lotto;

import lotto.domain.Dealer;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.util.Rank;

import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private User user = new User();
    private Dealer dealer = new Dealer();
    private Map<Rank, Integer> matchResult = new HashMap<>();

    public void start() {
        user.start();
        dealer.start();
        matchLottoUserAndDealer();
    }

    private void matchLottoUserAndDealer() {
        user.getLottos()
                .forEach(lotto -> {
                    long count = lotto.containsResultCount(dealer.getNumbers());
                    addMatchResult(count, lotto.containsBonusNumber(dealer.getBonusNumber()));
                });
    }

    private void addMatchResult(long count, boolean matchBonus) {
        Rank rank = Rank.fromCount(count, matchBonus);
        matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
    }
}
