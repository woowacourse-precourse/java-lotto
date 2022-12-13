package lotto.views;

import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinningResultStatus;
import lotto.constants.messages.OutputMessage;
import lotto.domain.Lotto;

public class OutputView {
    public static final int COUNT_OF_LOTTO = 0;
    public static final int BOUGHT_RESULT = 1;
    public static final int STATISTICS = 0;
    public static final int EARNINGS_RATE = 1;

    private final OutputMessageGenerator messageGenerator = new OutputMessageGenerator();

    public void outputLottoBuyingResult(List<Object> resultOfBuyingLotto) {
        System.out.println();
        System.out.println(
                messageGenerator.createBuyingLottoCountMessage((int) resultOfBuyingLotto.get(COUNT_OF_LOTTO)));
        System.out.println(
                messageGenerator.createBuyingLottoResultMessage((List<Lotto>) resultOfBuyingLotto.get(BOUGHT_RESULT)));
    }

    public void outputLottoResult(List<Object> lottoResult) {
        System.out.println();
        System.out.println(OutputMessage.WINNING_STATISTICS);
        System.out.println(OutputMessage.DIVIDING_LINE);
        System.out.println(
                messageGenerator.createStatisticsMessage(
                        (Map<WinningResultStatus, Integer>) lottoResult.get(STATISTICS)));
        System.out.println(messageGenerator.createEarningsRateMessage((double) lottoResult.get(EARNINGS_RATE)));
    }

    public void outputCustomMessage(String message) {
        System.out.println(message);
    }
}
