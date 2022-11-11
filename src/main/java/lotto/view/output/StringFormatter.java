package lotto.view.output;

import java.util.StringJoiner;

public class StringFormatter {

    static String resultStatisticsFormat(String lottoResults, double rateOfReturn) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner
                .add("당첨 통계")
                .add("---")
                .add(lottoResults)
                .add("총 수익률은 " + rateOfReturn + "%입니다.");

        return stringJoiner.toString();
    }

    static String errorMessageFormat(String message) {
        final String ERROR_MESSAGE_PREFIX = "[ERROR]";
        return ERROR_MESSAGE_PREFIX + message;
    }

    static String purchasedNumberOfLottosFormat(int number) {
        final String PURCHASED_SUFFIX = "개를 구매했습니다.";
        return number + PURCHASED_SUFFIX;
    }
}
