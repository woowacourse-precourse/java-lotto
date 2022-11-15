package lotto.game.view;

import java.util.Map;

import static lotto.util.Constant.*;

public class View {
    private static final String NEWLINE = "\n";
    private static final String TRIPLE_DASH = "---";
    private static final String RESULT_UNIT = "개";

    public View() {
    }

    public String inputPurchaseAmount() {
        Console.Out.printLine(Message.INPUT_PURCHASE_AMOUNT);
        return Console.In.inputLine();
    }

    public void outputQuantity(int quantity) {
        Console.Out.print(NEWLINE);
        Console.Out.printLine(String.format("%d%s", quantity, Message.OUTPUT_LOTTO_NUMBERS.text()));
    }

    public void outputLottoNumbers(String lottoNumbers) {
        Console.Out.printLine(lottoNumbers);
    }

    public String inputDrawNumbers() {
        Console.Out.printLine(Message.INPUT_DRAW_NUMBERS);
        return Console.In.inputLine();
    }

    public String inputBonusNumber() {
        Console.Out.printLine(Message.INPUT_BONUS_NUMBER);
        return Console.In.inputLine();
    }

    public void outputResult(Map<Integer, Integer> drawScore, Integer bonusScore) {
        Console.Out.print(NEWLINE);
        Console.Out.printLine(Message.OUTPUT_MATCH_TOTAL);
        Console.Out.printLine(TRIPLE_DASH);
        Console.Out.printLine(formatResult(
                        Message.OUTPUT_THREE_MATCHES,
                        drawScore.getOrDefault(THREE, DEFAULT_SCORE)));
        Console.Out.printLine(formatResult(
                Message.OUTPUT_FOUR_MATCHES,
                drawScore.getOrDefault(FOUR, DEFAULT_SCORE)));
        Console.Out.printLine(formatResult(
                Message.OUTPUT_FIVE_MATCHES,
                drawScore.getOrDefault(FIVE, DEFAULT_SCORE)));
        Console.Out.printLine(formatResult(
                Message.OUTPUT_BONUS_MATCHES,
                bonusScore));
        Console.Out.printLine(formatResult(
                Message.OUTPUT_SIX_MATCHES,
                drawScore.getOrDefault(SIX, DEFAULT_SCORE)));
    }

    private String formatResult(Message matchMessage, int score) {
        return String.format("%s%d%s", matchMessage.text(), score, RESULT_UNIT);
    }

    public void outputEarningRate(double earningsRate) {
        Console.Out.print(Message.OUTPUT_EARNINGS_RATE_PREFIX);
        Console.Out.print(formatEarningsRate(earningsRate));
        Console.Out.printLine(Message.OUTPUT_EARNINGS_RATE_POSTFIX);
    }

    private String formatEarningsRate(double earningsRate) {
        return String.format("%,.1f%s", earningsRate * 100, "%");
    }
}
