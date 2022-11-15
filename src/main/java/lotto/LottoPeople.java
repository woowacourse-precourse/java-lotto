package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoPeople {
    private final List<Lotto> lottos;
    private final long principal;

    private LottoPeople(List<Lotto> lottos, long principal) {
        this.lottos = lottos;
        this.principal = principal;
    }

    public static LottoPeople from (long principal) {
        long size = principal / UniqueFile.PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            lottos.add(Lotto.createLotto());
        }
        return new LottoPeople(lottos, principal);
    }

    public static LottoPeople from (List<Lotto> lottos) {
        return new LottoPeople(lottos, lottos.size() * UniqueFile.PRICE);
    }

    @Override
    public String toString() {
        String sizeDescription = String.format(lottos.size() + "개를 구매하였습니다.\n");
        StringBuilder description = new StringBuilder(sizeDescription);
        lottos.forEach(lotto -> description.append(lotto).append('\n'));
        return description.toString();
    }

    public Map<Rank, Integer> matchResult(WinNumber winNumber) {
        EnumMap<Rank, Integer> matchResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            matchResult.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winNumber);
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
