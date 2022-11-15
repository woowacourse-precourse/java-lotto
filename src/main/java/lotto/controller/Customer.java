package lotto.controller;

import java.util.HashMap;
import java.util.List;
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
    private void printLotteries(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        lotteries.forEach(System.out::println);
    }

    private void setLotteries(List<Lotto> lotteries) {
        printLotteries(lotteries);
        this.lotteries = lotteries;
    }

}
