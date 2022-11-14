package lotto.ui.formatter.result;

import lotto.domain.winningresult.WinningType;
import lotto.ui.formatter.OutputFormatter;

public class WinningTypeFormatter implements OutputFormatter<WinningType> {
    private static final String PRICE_FORMAT = " (%,d원)";

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
        format.append(String.format(PRICE_FORMAT, winningType.getReward()));
    }
}
