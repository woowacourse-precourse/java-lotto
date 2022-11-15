package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.service.ResultService;

public class OutputView {
    public static void messageAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printTotalCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Object[] sortedLotto = sortAscendingOrder(lotto.getNumbers().toArray());
            System.out.println(Arrays.toString(sortedLotto));
        }
    }

    private static Object[] sortAscendingOrder(Object[] lottoNumbers) {
        Arrays.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void messageWinningInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void messageBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult(User user, Result result) {
        messageStrategy();
        printRankResult(result);
        printProfitRate(ResultService.getProfitRate(user, result));
    }

    private static void messageStrategy() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private static void printRankResult(Result result) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        for (Rank rank : result.getResults().keySet()) {
            if (rank == Rank.NONE) {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(rank.getMessage());
            stringBuilder.append(String.format("(%s원)", formatter.format(rank.getMoney())));
            stringBuilder.append(String.format(" - %s개", result.getResults().get(rank)));
            System.out.println(stringBuilder.toString());
        }
    }

    private static void printProfitRate(double profitRate) {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        stringBuilder.append(String.format("총 수익률은 %s%%입니다.", formatter.format(profitRate)));
        System.out.println(stringBuilder.toString());
    }
}
