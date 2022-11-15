package ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.PrizeMoney;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    public static final int PRICE_UNIT = 1000;
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_SUCCESS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    public static int enterPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        String price = Console.readLine();
        System.out.println();

        return Integer.parseInt(price);
    }

    public static void printPurchaseResult(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + PURCHASE_SUCCESS_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static WinningLotto enterWinningLotto() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String winningNumbers = Console.readLine();
        System.out.println();

        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        System.out.println();

        // 나중에 입력 값을 검증하여 에러를 잡는 코드가 추가돼야 함
        return new WinningLotto(
                Arrays.stream(winningNumbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()),
                Integer.parseInt(bonusNumber));
    }

    public static void printStatistics(List<Lotto> lottos, WinningLotto winningLottos) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        Statistics statistics = new Statistics(lottos, winningLottos);

        List<Integer> information = statistics.calculateInformation();
        printInformation(information);

        float profitRate = statistics.calculateProfitRate(information);
        printProfitRate(profitRate);
    }

    public static void printInformation(List<Integer> information) {
        for (int i = 0; i < information.size(); i++) {
            String name = "RANK" + (5 - i);
            System.out.println(PrizeMoney.valueOf(name).getLabel() + " - " + information.get(i) + "개");
        }
    }

    private static void printProfitRate(float profitRate) {
        String totalProfitRateMessage = "총 수익률은 %.1f%%입니다.\n";
        System.out.printf(totalProfitRateMessage, profitRate);
    }
}
