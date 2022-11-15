package lotto.io;

import lotto.domain.Lotto;
import java.util.List;
import java.util.Map;

import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.PrinterMessages.MONEY_INPUT_REQUEST_MESSAGE;
import static lotto.PrinterMessages.WINNING_NUMBERS_INPUT_REQUEST_MESSAGE;
import static lotto.PrinterMessages.BONUS_NUMBER_INPUT_REQUEST_MESSAGE;
import static lotto.PrinterMessages.LOTTO_PURCHASE_MESSAGE;
import static lotto.PrinterMessages.WINNING_STATISTICS_MESSAGE;
import static lotto.PrinterMessages.DIVIDING_LINE;
import static lotto.PrinterMessages.EARNING_RATE_MESSAGE;

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
        System.out.println(String.format("3개 일치 (5,000원) - %d개\n", winningDetails.get(5_000)) +
                String.format("4개 일치 (50,000원) - %d개\n", winningDetails.get(50_000)) +
                String.format("5개 일치 (1,500,000원) - %d개\n", winningDetails.get(1_500_000)) +
                String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningDetails.get(30_000_000)) +
                String.format("6개 일치 (2,000,000,000원) - %d개", winningDetails.get(2_000_000_000)));
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
