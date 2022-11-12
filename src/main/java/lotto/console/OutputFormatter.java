package lotto.console;

import java.util.List;
import java.util.StringJoiner;

class OutputFormatter {

    static String formatThousandsSeparator(long money) {
        return String.format("%,d", money);
    }

    static String formatPercent(float number) {
        return String.format("%,.1f%%", number * 100f);
    }

    static String formatLottoNumbers(List<Integer> lottoNumbers) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lottoNumbers.stream()
                .map(number -> number + "")
                .forEach(joiner::add);

        return joiner.toString();
    }
}
