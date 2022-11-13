package lotto.ui.formatter.result;

import lotto.domain.winningresult.WinningType;
import lotto.ui.formatter.OutputFormatter;

public class WinningTypeFormatter implements OutputFormatter<WinningType> {
    private static final String MONEY_UNIT = "원";
    private static final String OPEN_BRACE = " (";
    private static final String CLOSE_BRACE = ")";

    @Override
    public String outputFormat(WinningType winningType) {
        StringBuilder format = new StringBuilder();
        appendWinningContent(format, winningType);
        appendWinningPrice(format, winningType);

        return format.toString();
    }

    private void appendWinningContent(StringBuilder format, WinningType winningType) {
        format.append(winningType.getContent());
    }

    private void appendWinningPrice(StringBuilder format, WinningType winningType) {
        format.append(OPEN_BRACE)
                .append(convertNumberWithComma(winningType))
                .append(MONEY_UNIT)
                .append(CLOSE_BRACE);
    }

    private static String convertNumberWithComma(WinningType winningType) {
        return String.format("%,d", winningType.getReward());
    }
}
