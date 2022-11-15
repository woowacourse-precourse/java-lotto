package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.TotalLottoResult;
import lotto.domain.constants.LottoRank;
import lotto.view.constants.Format;
import lotto.view.constants.OutputMessage;
import lotto.view.utils.KeyboardReader;
import lotto.view.utils.MessagePrinter;

import java.text.DecimalFormat;
import java.util.List;

public class GameView {
    private static final GameView instance = new GameView();

    private GameView() { }

    public static GameView getInstance() {
        return instance;
    }

    public int askPayment() throws IllegalArgumentException, NullPointerException {
        MessagePrinter.printLine(OutputMessage.ASK_PAYMENT);
        int payment = KeyboardReader.readInteger();
        MessagePrinter.printLine("");
        return payment;
    }

    public List<Integer> askLottoDrawNumbers() throws IllegalArgumentException, NullPointerException {
        MessagePrinter.printLine(OutputMessage.ASK_DRAW_LOTTO_NUMBERS);
        List<Integer> drawnNumbers = KeyboardReader.readFormattedStringToInteger(Format.DELIMITER_LOTTO_NUMBERS);
        MessagePrinter.printLine("");
        return drawnNumbers;
    }

    public int askLottoDrawBonusNumber() throws IllegalArgumentException, NullPointerException {
        MessagePrinter.printLine(OutputMessage.ASK_DRAW_BONUS_NUMBER);
        int drawnBonusNumber = KeyboardReader.readInteger();
        MessagePrinter.printLine("");
        return drawnBonusNumber;
    }

    public void showPurchaseAmount(int amount) throws NullPointerException {
        MessagePrinter.printLine(Format.STRING_ISSUE_AMOUNT, amount);
    }

    public void showPurchasedLottos(List<Lotto> lottos) throws NullPointerException {
        for (Lotto lotto : lottos) {
            MessagePrinter.printLine(lotto);
        }
        MessagePrinter.printLine("");
    }

    public void showTotalLottoResult(TotalLottoResult result) throws NullPointerException {
        MessagePrinter.printLine(OutputMessage.INFORM_TOTAL_LOTTO_RESULT);
        DecimalFormat currecyFormatter= new DecimalFormat(Format.NUMBER_CURRENCY.getText());
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.RANK_LOSE) {
                continue;
            }
            Format format = selectFormatForRankResult(rank);
            int count = result.getCountByRank(rank);
            String prize = currecyFormatter.format(rank.getPrize());
            MessagePrinter.printLine(format, rank.getRequiredMatchCount(), prize, count);
        }
    }

    public void showEarningRatio(double earningRatio) throws NullPointerException {
        DecimalFormat currecyFormatter= new DecimalFormat(Format.NUMBER_CURRENCY_WITH_FIRST_DECIMAL.getText());
        MessagePrinter.printLine(Format.STRING_EARNING_RATIO, currecyFormatter.format(earningRatio));
    }

    public void showExitByErrorMessage(Exception exception) throws NullPointerException {
        String errorMessage = exception.getMessage();
        if (errorMessage != null) {
            MessagePrinter.printLine(Format.STRING_ERROR_MESSAGE, errorMessage);
        }
        MessagePrinter.printLine("오류 발생으로 인해 프로그램을 종료합니다.");
    }

    private Format selectFormatForRankResult(LottoRank rank) {
        if (rank.isRequiredToCheckBonus()) {
            return Format.STRING_RANK_WITH_BONUS_RESULT;
        }
        return Format.STRING_RANK_RESULT;
    }
}
