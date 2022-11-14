package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class LottoConsole {

    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";
    private static final String READ_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PRINT_LOTTO_NUMBERS_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String PRINT_LOTTO_RESULT_MESSAGE = "당첨 통계\n---\n";
    private static final String PRINT_LOTTO_RESULT_WINNING_COUNT_MESSAGE = "%s - %d개\n";
    private static final String PRINT_LOTTO_RESULT_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final String PRINT_ERROR_MESSAGE = "[ERROR] %s\n";

    public static String readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String readWinningNumber() {
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static void printLottos(Lottos lottos) {
        System.out.printf(PRINT_LOTTO_NUMBERS_MESSAGE, lottos.getLottos().size());
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(PRINT_LOTTO_RESULT_MESSAGE);

        Map<LottoRank, Integer> winCount = lottoResult.getWinCount();
        List<LottoRank> lottoRanks = LottoRank.getLottoRankList();
        for(LottoRank lottoRank : lottoRanks) {
            sb.append(String.format(PRINT_LOTTO_RESULT_WINNING_COUNT_MESSAGE, lottoRank.getRewardMessage(), winCount.get(lottoRank)));
        }

        sb.append(String.format(PRINT_LOTTO_RESULT_YIELD_MESSAGE, lottoResult.getYield()));
        System.out.print(sb);
    }

    public static void printError(RuntimeException exception) {
        System.out.printf(PRINT_ERROR_MESSAGE, exception.getMessage());
    }
}
