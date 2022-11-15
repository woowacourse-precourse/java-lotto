package lotto.LottoGame;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.winning.WinningStatistical;
import lotto.winning.WinningStatisticalFormatter;

public class LottoGameKoreanConsolePrinter implements LottoGamePrinter {
    public static final String REQUEST_BUYING_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_MESSAGE_FORMATTER = "%d개를 구매했습니다.\n";

    public static final String REQUEST_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final WinningStatisticalFormatter winningStatisticalFormatter;

    public LottoGameKoreanConsolePrinter(WinningStatisticalFormatter winningStatisticalFormatter) {
        this.winningStatisticalFormatter = winningStatisticalFormatter;
    }

    @Override
    public void printRequestBuyingPrice() {
        System.out.println(REQUEST_BUYING_PRICE_MESSAGE);
    }

    @Override
    public void printBoughtLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_COUNT_MESSAGE_FORMATTER, lottos.size());
        lottos.forEach(System.out::println);
    }

    @Override
    public void printRequestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    @Override
    public void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    @Override
    public void printWinningStatistical(WinningStatistical winningStatistical) {
        System.out.println(winningStatisticalFormatter.format(winningStatistical));
    }
}
