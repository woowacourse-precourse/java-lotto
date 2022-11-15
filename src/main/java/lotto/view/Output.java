package lotto.view;

import static java.util.stream.Collectors.joining;
import static lotto.domain.Grade.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Grade;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class Output {

    private static final String NEW_LINE_REGEX = "\n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_SUFFIX = "]";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String ERROR = "[ERROR]";

    public void printPurchaseInfo(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getQuantity() + LOTTO_PURCHASE_MESSAGE);
        printLottoTicket(lottoTicket.getLottoTicket());
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR + exceptionMessage);
    }

    private void printLottoTicket(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(printLotto(lotto))
                    .append(NEW_LINE_REGEX);
        }
        System.out.println(stringBuilder);
    }

    private String printLotto(Lotto lotto) {
        return lotto.getLotto().stream()
                .sorted()
                .map(number -> String.valueOf(number))
                .collect(joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX));
    }

    public void printLottoResult(Map<Grade, Integer> gradeResult) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", gradeResult.getOrDefault(FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) -% d개\n", gradeResult.getOrDefault(FORTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", gradeResult.getOrDefault(THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", gradeResult.getOrDefault(SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", gradeResult.getOrDefault(FIRST, 0));
    }

    public void printLottoYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield * 100);
    }
}
