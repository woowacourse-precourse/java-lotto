package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int money;
    private List<Lotto> lottos;
    private LottoMachine lottoMachine;
    private Map<Winning, Integer> winCount = new HashMap<>();
    private int profit;
    public User(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
        this.profit = 0;
    }

    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력할 수 있습니다.");
//            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        isMoneyDividedWith1000(money);

        buyLotto();
    }

    public void isMoneyDividedWith1000(int money) {
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    private void buyLotto(){
        this.lottos = lottoMachine.buyLotto(money);
    }

    public void printWinningStatistics() {
        checkLottoIsWinning();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Winning.fifth.sumDescribeWithCount(winCount.getOrDefault(Winning.fifth, 0)));
        System.out.println(Winning.fourth.sumDescribeWithCount(winCount.getOrDefault(Winning.fourth, 0)));
        System.out.println(Winning.third.sumDescribeWithCount(winCount.getOrDefault(Winning.third, 0)));
        System.out.println(Winning.second.sumDescribeWithCount(winCount.getOrDefault(Winning.second, 0)));
        System.out.println(Winning.first.sumDescribeWithCount(winCount.getOrDefault(Winning.first, 0)));
        String totalProfit = String.format("%.1f", ((double) profit / money * 100));
        System.out.println("총 수익률은 " + totalProfit + "%입니다.");
    }

    private void checkLottoIsWinning() {
        for (Lotto lotto : lottos) {
            Winning winning = lottoMachine.isLottoWin(lotto);
            if (winning != null) {
                winCount.put(winning, winCount.getOrDefault(winning, 0) + 1);
                profit += winning.getPrice();
            }
        }
    }


}
