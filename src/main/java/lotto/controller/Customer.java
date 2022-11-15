package lotto.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Rank;

public class Customer {
    private List<Lotto> lotteries;
    private LottoBroadcast broadcast;
    private HashMap<Rank, Integer> result;

    public Customer() {
        this.result = new HashMap<>();
    }

    public void buy(LottoShop shop) {
        setLotteries(shop.buy());
    }

    public void watch(LottoBroadcast broadcast) {
        setBroadcast(broadcast);
        calculateResult();
    }


    private void printLotteries(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        lotteries.forEach(System.out::println);
    }

    private void setLotteries(List<Lotto> lotteries) {
        printLotteries(lotteries);
        this.lotteries = lotteries;
    }

    private void setBroadcast(LottoBroadcast broadcast) {
        this.broadcast = broadcast;
    }

    private void calculateResult() {
        List<Rank> ranks = lotteries.stream().map(this::getRank).collect(Collectors.toList());

        for (Rank rank : ranks) {
            result.put(rank, Collections.frequency(ranks, rank));
        }
    }

    private Rank getRank(Lotto mine) {

        Rank rank = Rank.ranking(compareLotto(mine, broadcast.getWinning()));

        if (rank.equals(Rank.THIRD)) {
            if (isContainBonus(mine, broadcast.getBonus())) {
                return Rank.SECOND;
            }
        }
        return rank;
    }

    private int compareLotto(Lotto mine, Lotto winning) {
        return (int) mine.getNumbers().stream().
            filter(winning::contains).count();
    }

    private boolean isContainBonus(Lotto mine, int bonus) {
        return mine.contains(bonus);
    }


}
