package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.dto.LottoResultDto;
import lotto.dto.PrizeDto;

public class OutputView {
    private static final String BOUGHT_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String LOTTO_WIN_RESULT = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_WIN = ", 보너스 볼 일치";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final String RESULT_HEADER = "\n당첨 통계\n---";
    private static final String EMPTY_STRING = "";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###");

    private OutputView() {
    }

    public static void printIssuedLotto(List<List<Integer>> lottos) {
        printIssuedLottoCount(lottos.size());
        printLottos(lottos);
    }

    public static void printLottoResult(LottoResultDto result) {
        System.out.println(RESULT_HEADER);
        result.getPrizes().forEach(OutputView::printEachPrize);
        printRateOfReturn(result.getRateOfReturn());
    }

    private static void printIssuedLottoCount(int size) {
        System.out.printf("\n" + BOUGHT_LOTTO_COUNT + "\n", size);
    }

    private static void printLottos(List<List<Integer>> lottos) {
        lottos.forEach(System.out::println);
    }

    private static void printEachPrize(PrizeDto prize) {
        System.out.printf(LOTTO_WIN_RESULT + "\n",
                prize.getMatchCount(), checkBonus(prize.hasBonus()),
                convertMoneyFormat(prize.getMoney()), prize.getCount());
    }

    private static String checkBonus(boolean hasBonus) {
        if (hasBonus) {
            return BONUS_WIN;
        }
        return EMPTY_STRING;
    }

    private static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN, rateOfReturn);
    }

    private static String convertMoneyFormat(int money) {
        return MONEY_FORMAT.format(money);
    }
}
