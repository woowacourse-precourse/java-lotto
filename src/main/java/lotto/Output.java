package lotto;

import static java.util.stream.Collectors.joining;
import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static lotto.Rank.FORTH;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;

import java.util.List;
import java.util.Map;

public class Output {

    private static final String NEW_LINE_REGEX = "\n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_SUFFIX = "]";
    private static final String ERROR_MESSAGE = "[ERROR]";

    public void printPurchaseInfo(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        printLottos(lottos.getLottos());
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_MESSAGE + exceptionMessage);
    }

    private void printLottos(List<Lotto> lottos) {
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
                .map(String::valueOf)
                .collect(joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX));
    }

    public void printLottoResult(Map<Rank, Integer> lottoResult) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.getOrDefault(FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) -% d개\n", lottoResult.getOrDefault(FORTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.getOrDefault(THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.getOrDefault(SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.getOrDefault(FIRST, 0));
    }

    public void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit * 100);
    }
}
