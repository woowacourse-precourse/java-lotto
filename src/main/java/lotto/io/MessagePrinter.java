package lotto.io;

import lotto.domain.Lotto;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoConstants.LOTTO_PRICE;
import static lotto.io.OutputMessages.MONEY_INPUT_REQUEST_MESSAGE;
import static lotto.io.OutputMessages.WINNING_NUMBERS_INPUT_REQUEST_MESSAGE;
import static lotto.io.OutputMessages.BONUS_NUMBER_INPUT_REQUEST_MESSAGE;
import static lotto.io.OutputMessages.LOTTO_PURCHASE_MESSAGE;
import static lotto.io.OutputMessages.WINNING_STATISTICS_MESSAGE;
import static lotto.io.OutputMessages.DIVIDING_LINE;
import static lotto.io.OutputMessages.EARNING_RATE_MESSAGE;
import static lotto.io.OutputMessages.FIFTH_STATISTICS_MESSAGE;
import static lotto.io.OutputMessages.FOURTH_STATISTICS_MESSAGE;
import static lotto.io.OutputMessages.THIRD_STATISTICS_MESSAGE;
import static lotto.io.OutputMessages.SECOND_STATISTICS_MESSAGE;
import static lotto.io.OutputMessages.FIRST_STATISTICS_MESSAGE;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.THIRD;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.FIRST;

public class MessagePrinter {
    public static void printMoneyInputRequest() {
        System.out.println(MONEY_INPUT_REQUEST_MESSAGE.getMessage());
    }

    public static void printGeneratedLottoQuantity(int paidMoney) {
        int lottoQuantity = paidMoney / LOTTO_PRICE.getValue();
        String message = String.format(LOTTO_PURCHASE_MESSAGE.getMessage(), lottoQuantity);
        System.out.println(message);
    }

    public static void printGeneratedLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningNumbersInputRequest() {
        System.out.println(WINNING_NUMBERS_INPUT_REQUEST_MESSAGE.getMessage());
    }

    public static void printBonusNumberInputRequest() {
        System.out.println(BONUS_NUMBER_INPUT_REQUEST_MESSAGE.getMessage());
    }

    public static void printWinningDetails(Map<Integer, Integer> winningDetails) {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(DIVIDING_LINE.getMessage());
        printStatistics(winningDetails);
    }

    public static void printStatistics(Map<Integer, Integer> winningDetails) {
        System.out.println(String.format(FIFTH_STATISTICS_MESSAGE.getMessage(),
                winningDetails.get(FIFTH.prizeMoney())));
        System.out.println(String.format(FOURTH_STATISTICS_MESSAGE.getMessage(),
                winningDetails.get(FOURTH.prizeMoney())));
        System.out.println(String.format(THIRD_STATISTICS_MESSAGE.getMessage(),
                winningDetails.get(THIRD.prizeMoney())));
        System.out.println(String.format(SECOND_STATISTICS_MESSAGE.getMessage(),
                winningDetails.get(SECOND.prizeMoney())));
        System.out.println(String.format(FIRST_STATISTICS_MESSAGE.getMessage(),
                winningDetails.get(FIRST.prizeMoney())));
    }

    public static void printEarningRate(double earningRate) {
        String message = String.format(EARNING_RATE_MESSAGE.getMessage(), earningRate);
        System.out.println(message);
    }

    public static void printErrorMessage(Exception exception) {
        String errorMessage = exception.getMessage();
        System.out.println(errorMessage);
    }
}
