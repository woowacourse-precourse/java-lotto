package lotto.view.print;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Statistics;

import java.util.List;
import java.util.Map;

public class MessagePrinter {
    private static final String NOTIFY_INPUT_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String NOTIFY_INPUT_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String NOTIFY_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NOTIFY_TOPIC_STATISTICS = "당첨 통계";
    private static final String NOTIFY_PARAGRAPH_DIVISION = "---";
    private static final String NOTIFY_LOTTO_AMOUNT = "%d개를 구매했습니다.";
    private static final String NOTIFY_WINNING_RECORD = "%s - %d개";
    private static final String NOTIFY_EARNINGS_RATE = "총 수익률은 %f입니다.";

    public void printStaticPaymentNotification() {
        System.out.println(NOTIFY_INPUT_PAYMENT);
    }

    public void printDynamicLottoAmount(Buyer buyer) {
        int lottoAmount = buyer.getLottos().size();
        System.out.printf((NOTIFY_LOTTO_AMOUNT) + "%n", lottoAmount);
    }

    public void printDynamicLottosBought(Buyer buyer) {
        List<Lotto> lottos = buyer.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStaticWinningLottoNumbersNotification() {
        System.out.println(NOTIFY_INPUT_WINNING_LOTTO_NUMBERS);
    }

    public void printStaticBonusNumberNotification() {
        System.out.println(NOTIFY_INPUT_BONUS_NUMBER);
    }

    public void printDynamicWinningRecord(Statistics statistics) {
        Map<Rank, Integer> rankRecord = statistics.getRankRecord();
        for (Rank rank : rankRecord.keySet()) {
            System.out.printf((NOTIFY_WINNING_RECORD) + "%n", rank.getReward(), rankRecord.get(rank));
        }
    }

    public void printStaticStatisticsTopic() {
        System.out.println(NOTIFY_TOPIC_STATISTICS);
    }

    public void printStaticParagraphDivision() {
        System.out.println(NOTIFY_PARAGRAPH_DIVISION);
    }
}
