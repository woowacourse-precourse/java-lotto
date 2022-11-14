package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Money purchasePrice = new Money(askPurchasePrice());
            Ticket tickets = new Ticket(purchasePrice);

            LottoGenerator generator = new LottoGenerator();
            List<Lotto> lottos = generator.createLottos(tickets);
            printPurchasedLottos(lottos);

            WinLotto winLotto = new WinLotto(askWinNumbers(), askBonusNumber());
            Statistics statistics = new Statistics(lottos, winLotto, purchasePrice);
            printStatisticsResult(statistics);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String askPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        System.out.println();
        return purchasePrice;
    }

    public static String askWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbers = Console.readLine();
        System.out.println();
        return winNumbers;
    }

    public static String askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printStatisticsResult(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int index = 4; index >= 0; index--) {
            Rank rank = Rank.values()[index];
            System.out.print(rank.getMatchCount() + "개 일치");
            if (rank == Rank.SECOND) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" (" + String.format("%,d", rank.getReward()) + "원) - ");
            System.out.println(statistics.getResult().get(rank) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", statistics.getYield());
    }
}
