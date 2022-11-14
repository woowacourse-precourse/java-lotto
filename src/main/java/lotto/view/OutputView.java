package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {

    private static final long LOTTO_RESULT_IS_ZERO = 0L;

    public void printLottoBundleInfo(List<Lotto> lottoBundle) {
        System.out.printf("%d개를 구매했습니다.\n", lottoBundle.size());

        lottoBundle.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void printLottoResult(List<LottoResult> lottoResults) {
        printResultInfoStartMessage();

        Map<LottoResult, Long> numberOfEachLottoResult = getNumberOfEachLottoResult(lottoResults);

        Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.getPayout() != 0)
                .forEach(lottoResult -> printResultMessage(lottoResult, numberOfEachLottoResult));
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    private void printResultInfoStartMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private Map<LottoResult, Long> getNumberOfEachLottoResult(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private void printResultMessage(LottoResult lottoResult,
                                    Map<LottoResult, Long> numberOfEachLottoResult) {
        DecimalFormat df = new DecimalFormat("###,###");

        if (lottoResult.equals(LottoResult.FIVE_WITH_BONUS)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    lottoResult.getNumberOfMatches(),
                    df.format(lottoResult.getPayout()),
                    numberOfEachLottoResult.getOrDefault(lottoResult, LOTTO_RESULT_IS_ZERO));
            return;
        }

        System.out.printf("%d개 일치 (%s원) - %d개\n",
                lottoResult.getNumberOfMatches(),
                df.format(lottoResult.getPayout()),
                numberOfEachLottoResult.getOrDefault(lottoResult, LOTTO_RESULT_IS_ZERO));
    }
}
