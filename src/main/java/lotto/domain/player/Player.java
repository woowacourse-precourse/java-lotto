package lotto.domain.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

public class Player {
    private final long LOTTO_PRICE = 1000;

    private long money;
    private List<Lotto> lotteries;

    public Player(long money) {
        this.money = money;
        this.lotteries = new ArrayList<>();
    }

    public Player(long money, List<Lotto> lottoList) {
        this.money = money;
        this.lotteries = lottoList;
    }

    public void buyLotto() {
        long count = money / LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            lotteries.add(LottoGenerator.generate());
        }

        money = 0;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player player = (Player) obj;

            if (player.money == money && Objects.equals(player.lotteries, lotteries)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lotteries);
    }

}
