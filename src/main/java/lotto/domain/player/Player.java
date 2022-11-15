package lotto.domain.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoPrize;

public class Player {
    private final long LOTTO_PRICE = 1000;
    private long money;

    private long insertedMoney;
    private long earningMoney;
    private List<Lotto> lotteries;

    public Player(long insertedMoney) {
        this.money = insertedMoney;
        this.lotteries = new ArrayList<>();
    }

    public Player(long insertedMoney, List<Lotto> lottoList) {
        this.money = insertedMoney;
        this.lotteries = lottoList;
    }

    public void buyLotto() {
        long count = money / LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            lotteries.add(LottoGenerator.generate());
        }

        insertedMoney = money;
        money = 0;
    }

    public void saveResult(HashMap<LottoPrize, Long> lottoResults) {
        lottoResults.keySet()
                .forEach((lottoPrize) -> {
                    long reward = lottoPrize.getReward();
                    long count = lottoResults.get(lottoPrize);

                    earningMoney += reward * count;
                });
        System.out.println(earningMoney);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public double getEarningRate() {
        return (double) earningMoney / insertedMoney * 100;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player player = (Player) obj;

            if (player.insertedMoney == insertedMoney && Objects.equals(player.lotteries, lotteries)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(insertedMoney, lotteries);
    }

}
