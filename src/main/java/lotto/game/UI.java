package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;

public class UI {
    public static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String receiveInput(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printTotalResult(Map<LottoGrade, Integer> totalWinnings) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", totalWinnings.getOrDefault(LottoGrade.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", totalWinnings.getOrDefault(LottoGrade.FOURTH, 0));
        System.out.printf("5개 일치 (5,000원) - %d개%n", totalWinnings.getOrDefault(LottoGrade.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", totalWinnings.getOrDefault(LottoGrade.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", totalWinnings.getOrDefault(LottoGrade.FIRST, 0));
    }
}
