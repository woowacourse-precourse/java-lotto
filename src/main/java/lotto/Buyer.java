package lotto;


import static lotto.Constant.ErrorMessage.WRONG_MONEY_UNIT;
import static lotto.Constant.LottoValue.LOTTO_PRICE;
import static lotto.Printer.printLottos;
import static lotto.Printer.printWinnings;

import java.util.ArrayList;
import java.util.List;



public class Buyer {
    private final List<Lotto> lottos;
    private final List<Rank> ranks;
    private int lottoNum;
    private int money;
    private int earn;


    public Buyer(int money) {
        validate(money);

        this.money = money;
        this.lottoNum = money / LOTTO_PRICE;
        this.lottos = new ArrayList<>(this.lottoNum);
        buyLottos();
        this.ranks = new ArrayList<>(this.lottoNum);
        this.earn = 0;
    }


    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            System.out.println(WRONG_MONEY_UNIT);
            throw new IllegalArgumentException();
        }
    }

    private void buyLottos() {
        for (int i = 0; i < this.lottoNum; i++) {
            final Lotto lotto = Lotto.generate();

            lottos.add(lotto);
        }
    }

    public void showLottos() {
        printLottos(lottos);
    }

    public void showWinnings() {
        printWinnings(ranks);
    }

    public void addWinning(Rank rank) {
        ranks.add(rank);
    }

    public double getYield() {
        int earn = ranks.stream()
                .mapToInt(Rank::getPrizeMoney)
                .sum();

        double yield = (double) earn / money * 100;

        return Math.round(yield * 10) / 10.0;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
