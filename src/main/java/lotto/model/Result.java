package lotto.model;

import java.util.LinkedHashMap;

public class Result {

    private final LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();

    public Result(LottoGroup lottolist, UserLotto usernumbers) {
        for (Lotto lotto : lottolist.getLOTTO_LIST()) {
            Rank rank = Rank.valueOf(SameCount(lotto, usernumbers.getNUMBERS()),
                lotto.getNumbers().contains(usernumbers.getBONUS_NUMBER()));
            resultAdd(rank);
        }
    }

    private int SameCount(Lotto userlotto, Lotto answerlotto) {
        Lotto userlotoclone = new Lotto(userlotto.getNumbers());
        userlotoclone.getNumbers().retainAll(answerlotto.getNumbers());
        return userlotoclone.getNumbers().size();
    }

    public double getSumPrice() {
        double price = 0;
        for (Rank rank : result.keySet()) {
            price += (double) rank.getPrice() * result.get(rank);
        }
        return price;
    }

    public int getRankCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    private void resultAdd(Rank rank) {
        result.merge(rank, 1, (v1, v2) -> v1 + v2);
    }

}
