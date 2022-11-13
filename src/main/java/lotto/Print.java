package lotto;

import java.util.List;

public class Print {
    static void getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    static void userLottos(int purchaseAmount){
        int buyAmount = Operation.buyAmount(purchaseAmount);
        List<Lotto> lottos=Operation.buyLotto(purchaseAmount);
        System.out.printf("%d개를 구매했습니다.\n", buyAmount);
        for (Lotto lotto: lottos) {
            lotto.printLotto();
        }
    }

    static void getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    static void getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    static void result(int purchaseAmount, Match match){
        int earning=Operation.calculateEarning(match);
        double earningRate = Operation.calculateEarningRate(purchaseAmount, earning);
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", match.match3);
        System.out.printf("4개 일치 (5,000원) - %d개\n", match.match4);
        System.out.printf("5개 일치 (5,000원) - %d개\n", match.match5);
        System.out.printf("5개 일치, 보너스 볼 일치 (5,000원) - %d개\n", match.match5Bonus);
        System.out.printf("6개 일치 (5,000원) - %d개\n", match.match6);
        System.out.printf("총 수익률은 %.2f%%입니다.\n", earningRate);
    }

}
