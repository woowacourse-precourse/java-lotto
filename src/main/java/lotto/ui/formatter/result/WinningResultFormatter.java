package lotto.ui.formatter.result;

import lotto.domain.winningresult.WinningResultType;
import lotto.ui.formatter.OutputFormatter;

public class WinningResultFormatter implements OutputFormatter<WinningResultType> {
    private static final String MONEY_UNIT = "원";
    private static final String OPEN_BRACE = " (";
    private static final String CLOSE_BRACE = ")";

    @Override
    public String outputFormat(WinningResultType winningResultType) {
        StringBuilder format = new StringBuilder(winningResultType.getContent());

        String numberWithComma = convertNumberWithComma(winningResultType);
        format.append(OPEN_BRACE)
                .append(numberWithComma)
                .append(MONEY_UNIT)
                .append(CLOSE_BRACE);

        return format.toString();
    }

    private static String convertNumberWithComma(WinningResultType winningResultType) {
        return String.format("%,d", winningResultType.getReward());
    }
}
