package lotto;


import static lotto.Constant.ErrorMessage.WRONG_MONEY_UNIT;
import static lotto.Constant.LottoValue.LOTTO_PRICE;
import static lotto.Printer.*;

import java.util.ArrayList;
import java.util.List;



public class User {
    private List<Lotto> lottos;
    private List<Winning> winnings;
    private int lottoNum;
    private int money;
    private int earn;


    public User(int money) {
        validateMoney(money);

        this.money = money;
        this.lottoNum = money / LOTTO_PRICE;
        generateLottos();
        this.winnings = new ArrayList<>();
        this.earn = 0;
    }


    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            System.out.println(WRONG_MONEY_UNIT);
            throw new IllegalArgumentException();
        }
    }

    private void generateLottos() {
        this.lottos = new ArrayList<Lotto>();

        for (int i = 0; i < this.lottoNum; i++) {
            final Lotto lotto = Lotto.generate();

            lottos.add(lotto);
        }
    }

    public void showLottos() {
        System.out.println(lottoNum + "개를 구매했습니다.");
        printLottos(lottos);
    }

    public void showWinnings() {
        printWinnings(winnings);
    }

    public void addWinning(Winning winning) {
        winnings.add(winning);
    }

    public double getYield() {
        int earn = winnings.stream()
                .mapToInt(Winning::getPrizeMoney)
                .sum();

        double yield = (double) earn / money * 100;

        return Math.round(yield * 10) / 10.0;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
