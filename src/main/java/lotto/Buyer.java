package lotto;

import static lotto.Constant.ErrorMessage.WRONG_MONEY_UNIT;

import static lotto.Constant.LottoValue.LOTTO_PRICE;

import static lotto.Util.Printer.printLottos;
import static lotto.Util.Printer.printWinnings;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.LottoGenerator;



public class Buyer {
    private final List<Lotto> lottos;
    private final List<Rank> ranks;
    private int lottoNum;
    private int money;


    public Buyer(int money) {
        try {
            validate(money);
        } catch (Exception exception) {
            throw exception;
        }

        this.money = money;
        this.lottoNum = money / LOTTO_PRICE;
        this.lottos = new ArrayList<>(this.lottoNum);
        buyLottos();
        this.ranks = new ArrayList<>(this.lottoNum);
    }


    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(WRONG_MONEY_UNIT);
        }
    }

    private void buyLottos() {
        for (int i = 0; i < this.lottoNum; i++) {
            final Lotto lotto = LottoGenerator.generate();

            lottos.add(lotto);
        }
    }

    public void showLottos() {
        printLottos(lottos);
    }

    public void showWinnings() {
        printWinnings(ranks);
    }

    public void addRank(Rank rank) {
        ranks.add(rank);
    }

    public double getProfit() {
        int earn = ranks.stream()
                .mapToInt(Rank::getPrizeMoney)
                .sum();

        double profit = (double) earn / money * 100;

        return Math.round(profit * 10) / 10.0;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
