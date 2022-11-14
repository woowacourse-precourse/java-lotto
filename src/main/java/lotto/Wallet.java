package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wallet {
    private List<Lotto> myLottos;
    private int money;
    private final List<LottoReward> profit;

    Wallet() {
        this.money = 0;
        this.profit = new ArrayList<>();
        this.myLottos = Collections.emptyList();
    }

    public void setMoney(String input) {
        System.out.println("구입금액을 입력해 주세요.\n" + input + "\n");

        int money = c4fiberParser.getIntegerFromString(input);
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }

    public void buyLottos(List<Lotto> boughtLottos) {
        myLottos = boughtLottos;
    }

    public void showMyLottos() {
        for(Lotto l : myLottos) {
            System.out.println(l.getNumbers().toString());
        }
    }

    public List<Lotto> getMyLottos() {
        return myLottos;
    }

    public void addReward(LottoReward reward) {
        this.profit.add(reward);
    }

    public void showStatistics() {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(profit, LottoReward.fifth) + "개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(profit, LottoReward.fourth) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(profit, LottoReward.third) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(profit, LottoReward.second) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(profit, LottoReward.first) + "개");

        int reward = 0;
        for (LottoReward v : profit) {
            reward += v.getReward();
        }
        System.out.printf("총 수익률은 %.1f%%입니다.",(double)reward / money * 100);
    }
}
