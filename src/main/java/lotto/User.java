package lotto;

import java.util.ArrayList;
import java.util.Collections;
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
        this.lottoNum = money / 1000;
        generateLottos();
        this.winnings = new ArrayList<>();
        this.earn = 0;
    }


    private void validateMoney(int money) {
        if (money % 1000 != 0) {
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

    public void printLottos() {
        System.out.println(lottoNum + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void addWinning(Winning winning) {
        winnings.add(winning);
    }

    public void printWinnings() {
        winnings.stream()
                .forEach(winning -> System.out.println(winning.name()));
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(this.winnings, Winning.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(this.winnings, Winning.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(this.winnings, Winning.THIRD) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(this.winnings, Winning.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(this.winnings, Winning.FIRST) + "개");
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
