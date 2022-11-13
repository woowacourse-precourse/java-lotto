package lotto.ui.formatter.result;

import lotto.domain.winningresult.WinningType;
import lotto.ui.formatter.OutputFormatter;

public class WinningTypeFormatter implements OutputFormatter<WinningType> {
    private static final String MONEY_UNIT = "원";
    private static final String OPEN_BRACE = " (";
    private static final String CLOSE_BRACE = ")";

    @Override
    public String outputFormat(WinningType winningType) {
        StringBuilder format = new StringBuilder(winningType.getContent());

        String numberWithComma = convertNumberWithComma(winningType);
        format.append(OPEN_BRACE)
                .append(numberWithComma)
                .append(MONEY_UNIT)
                .append(CLOSE_BRACE);

        return format.toString();
    }

    private static String convertNumberWithComma(WinningType winningType) {
        return String.format("%,d", winningType.getReward());
    }
}
