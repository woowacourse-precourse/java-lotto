package lotto.view;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PrizeType;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String ENTER_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = NEW_LINE + "{0}개를 구매했습니다.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER_MESSAGE = NEW_LINE + "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = NEW_LINE + "당첨 통계" + NEW_LINE + "---" + NEW_LINE;
    private static final String PROFIT_FORMAT = "#,##0.0";
    private static final String PROFIT_RATE = "총 수익률은 {0}%입니다.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printInputMoney() {
        System.out.println(ENTER_PURCHASE_MONEY_MESSAGE);
    }

    public static void printInputWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER_MESSAGE);
    }

    public static void printPurchaseLotto(List<Lotto> lottos) {
        System.out.println(MessageFormat.format(PURCHASE_LOTTO_COUNT_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printInputBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER_MESSAGE);
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.print(WINNING_STATISTICS);
        Map<PrizeType, Integer> result = lottoResult.getResult();
        for (PrizeType type : PrizeType.values()) {
            System.out.println(MessageFormat.format(type.getMessage(), result.get(type)));
        }
        printProfitPercent(lottoResult);
    }

    private static void printProfitPercent(LottoResult lottoResult) {
        DecimalFormat untilFirstDecimal = new DecimalFormat(PROFIT_FORMAT);
        String profitRate = untilFirstDecimal.format(lottoResult.getProfitRate());
        System.out.print(MessageFormat.format(PROFIT_RATE,profitRate));
    }
}