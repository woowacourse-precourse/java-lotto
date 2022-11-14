package lotto;

import java.util.List;

public class Print {
    static void getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    static void userLottos(List<Lotto> lottos, int purchaseAmount){
        int buyAmount = Operation.buyAmount(purchaseAmount);
        System.out.printf("%d개를 구매했습니다.\n", buyAmount);
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    static void getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    static void getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    static void result(double earningRate, Match match){
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", match.match3);
        System.out.printf("4개 일치 (50,000원) - %d개\n", match.match4);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", match.match5);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", match.match5Bonus);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", match.match6);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }

}
