package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Person {
    private final List<Lotto> lottos;
    private final long principal;

    private Person(List<Lotto> lottos, long principal) {
        this.lottos = lottos;
        this.principal = principal;
    }

    public static Person from (long principal) {
        long size = principal / Constants.PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            lottos.add(Lotto.createLotto());
        }
        return new Person(lottos, principal);
    }

    public static Person from (List<Lotto> lottos) {
        return new Person(lottos, lottos.size() * Constants.PRICE);
    }

    @Override
    public String toString() {
        String sizeDescription = String.format(lottos.size() + "개를 구매했습니다.\n");
        StringBuilder description = new StringBuilder(sizeDescription);
        lottos.forEach(lotto -> description.append(lotto).append('\n'));
        return description.toString();
    }

    public Map<Rank, Integer> matchResult(WinningNumbers winningNumbers) {
        EnumMap<Rank, Integer> matchResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            matchResult.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningNumbers);
            matchResult.put(rank, matchResult.get(rank) + 1);
        }
        return matchResult;
    }

    public double yield(Map<Rank, Integer> matchResult) {
        long profit = 0;
        for (Rank rank : matchResult.keySet()) {
            profit += rank.getMoney() * matchResult.get(rank);
        }
        return profit * 100.0 / principal;
    }
}
