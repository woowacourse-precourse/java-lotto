package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.ErrorMessage;
import lotto.Constant.LottoValue;

public class User {
    private List<Lotto> lottos;
    private List<Winning> winnings;
    private int lottoNum;
    private int money;
    private int earn;


    public User(int money) {
        validateMoney(money);

        this.money = money;
        this.lottoNum = money / LottoValue.LOTTO_PRICE;
        generateLottos();
        this.winnings = new ArrayList<>();
        this.earn = 0;
    }


    private void validateMoney(int money) {
        if (money % LottoValue.LOTTO_PRICE != 0) {
            System.out.println(ErrorMessage.WRONG_MONEY_UNIT);
            throw new IllegalArgumentException();
        }
    }

    private void generateLottos() {
        this.lottos = new ArrayList<Lotto>();

        for (int i = 0; i < this.lottoNum; i++) {
            Lotto lotto = Lotto.generate();

            lottos.add(lotto);
        }
    }

    public void showLottos() {
        System.out.println(lottoNum + "개를 구매했습니다.");
        Printer.printLottos(lottos);
    }

    public void showWinnings() {
        Printer.printWinnings(winnings);
    }

    public void addWinning(Winning winning) {
        winnings.add(winning);
    }

    public double getYield() {
        int earn = winnings.stream()
                .mapToInt(Winning::getPrizeMoney)
                .sum();

        System.out.println(earn);
        double yield = (double)earn / money * 100;


        return Math.round(yield * 10) / 10.0;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
