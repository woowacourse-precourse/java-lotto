package lotto.console;

import java.util.List;
import java.util.StringJoiner;

class OutputFormatter {

    private OutputFormatter() {
    }

    static String formatThousandsSeparator(long number) {
        return String.format("%,d", number);
    }

    static String formatPercent(double number) {
        return String.format("%,.1f%%", number * 100d);
    }

    static String formatLottoNumbers(List<Integer> lottoNumbers) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lottoNumbers.stream()
                .map(number -> number + "")
                .forEach(joiner::add);

        return joiner.toString();
    }
}
