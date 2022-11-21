package lotto.game.view;

import static java.util.stream.Collectors.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.game.domain.Lotto;
import lotto.game.domain.LottoGrade;
import lotto.game.domain.TotalResult;

public class UI {
    public static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String receiveInput(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.stream()
                .map(lotto -> lotto.getNumbers().stream()
                                .sorted()
                                .collect(toList()))
                .forEach(System.out::println);
        System.out.println();
    }

    public void printTotalResult(TotalResult totalResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", totalResult.getCount(LottoGrade.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", totalResult.getCount(LottoGrade.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", totalResult.getCount(LottoGrade.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", totalResult.getCount(LottoGrade.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", totalResult.getCount(LottoGrade.FIRST));
    }

    public void printProfitRate(String profitRate) {
        System.out.printf("총 수익률은 %s입니다.", profitRate);
    }
}
