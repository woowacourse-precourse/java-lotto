package lotto;

import lotto.domain.Dealer;
import lotto.domain.User;
import lotto.util.Message;
import lotto.util.Rank;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LottoGame {
    private User user = new User();
    private Dealer dealer = new Dealer();
    private Map<Rank, Integer> matchResult = new TreeMap<>(Comparator.reverseOrder());

    public void start() {
        user.start();
        dealer.start();
        matchLottoUserAndDealer();
        removeEmptyMatchResult();
        printMatchResult();
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

    private void removeEmptyMatchResult() {
        matchResult.remove(Rank.EMPTY);
    }

    private void printMatchResult() {
        System.out.println(Message.STATS_WIN_LOTTO);
        matchResult.keySet()
                .forEach(this::printStatsResult);
        printYield();
    }

    private void printYield() {
        long matchPrice = matchResult.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        System.out.printf(Message.YIELD_RESULT, (double) user.getMoney() / matchPrice);
    }

    private void printStatsResult(Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.printf(Message.STATS_RESULT_BONUS, rank.isMatchBonus(), priceFommater(rank.getPrice()), matchResult.get(rank));
            return;
        }

        System.out.printf(Message.STATS_RESULT, rank.isMatchBonus(), priceFommater(rank.getPrice()), matchResult.get(rank));
    }

    private String priceFommater(long price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }
}
