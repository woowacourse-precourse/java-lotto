package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class LottoView {

    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNINGS_NUMBERS_SETTING_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_SETTING_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";

    private static final String PREFIX_YIELD_MESSAGE = "총 수익률은 ";
    private static final String SUFFIX_YIELD_MESSAGE = "%입니다.";

    private static final int SKIP_RESULT_ELSE_CASE = 3;
    private static final long RESULT_NUMBER_ZERO = 0L;

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printWinningNumbersSettingMessage() {
        System.out.println(WINNINGS_NUMBERS_SETTING_MESSAGE);
    }

    public void printBonusNumberSettingMessage() {
        System.out.println(BONUS_NUMBER_SETTING_MESSAGE);
    }

    public void printLottoBundleInfo(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + LOTTO_NUMBER_MESSAGE);
        lottoBundle.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void printLottoResult(List<LottoResult> lottoResults) {
        printResultInfoStartMessage();

        Arrays.stream(LottoResult.values())
                .skip(SKIP_RESULT_ELSE_CASE)
                .map(lottoResult -> getResultMessage(lottoResult, getResultNumber(lottoResults)))
                .forEach(System.out::println);
    }

    public void printYield(double yield) {
        String yieldFormat = String.format("%.1f", yield);
        System.out.println(PREFIX_YIELD_MESSAGE + yieldFormat + SUFFIX_YIELD_MESSAGE);
    }

    private void printResultInfoStartMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private Map<LottoResult, Long> getResultNumber(List<LottoResult> lottoResults) {
        return lottoResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private String getResultMessage(LottoResult lottoResult,
                                    Map<LottoResult, Long> lottoResultToCount) {
        return getResultMessagePrefix(lottoResult) +
               lottoResultToCount.getOrDefault(lottoResult, RESULT_NUMBER_ZERO) + "개";
    }

    private String getResultMessagePrefix(LottoResult lottoResult) {
        DecimalFormat df = new DecimalFormat("###,###");
        String suffix = "(" + df.format(lottoResult.getPayout()) + "원) - ";

        if (lottoResult.equals(lottoResult.FIVE_WITH_BONUS)) {
            return lottoResult.getMatchingNumberCount() + "개 일치, 보너스 볼 일치 " + suffix;
        }
        return lottoResult.getMatchingNumberCount() + "개 일치 " + suffix;
    }
}
