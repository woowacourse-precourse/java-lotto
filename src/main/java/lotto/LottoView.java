package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoView {

    private static final String LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final int SKIP_RESULT_ELSE_CASE = 1;
    private static final String PREFIX_YIELD_MESSAGE = "총 수익률은 ";
    private static final String SUFFIX_YIELD_MESSAGE = "%입니다.";

    public void printLottoInfo(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + LOTTO_NUMBER_MESSAGE);
        for (Lotto lotto : lottoBundle) {
            lotto.printNumbers();
        }
    }

    public void printLottoResult(List<LottoResult> lottoResults) {
        Map<LottoResult, Long> lottoResultToCount = lottoResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Arrays.stream(LottoResult.values())
                .skip(SKIP_RESULT_ELSE_CASE)
                .forEach(lottoResult -> lottoResult.printMessage(lottoResultToCount));
    }

    public void printYield(double yield) {
        String yieldFormat = String.format("%.1f", yield);
        System.out.println(PREFIX_YIELD_MESSAGE + yieldFormat + SUFFIX_YIELD_MESSAGE);
    }
}
