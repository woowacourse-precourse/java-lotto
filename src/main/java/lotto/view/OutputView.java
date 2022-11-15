package lotto.view;

import static lotto.Constants.ASK_BONUS_NUMBER;
import static lotto.Constants.ASK_LOTTO_WINNING_NUMBERS;
import static lotto.Constants.ASK_PURCHASE_AMOUNT;
import static lotto.Constants.LOTTO_EARNING_RATE_MESSAGE;
import static lotto.Constants.LOTTO_ISSUE_COUNT_MESSAGE;
import static lotto.Constants.LOTTO_RESULT_HEADER_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void printAskPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
    }

    public static void printAskWinningNumbers() {
        System.out.println(ASK_LOTTO_WINNING_NUMBERS);
    }

    public static void printAskBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
    }

    public static void printIssuedLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println("[" + lotto.toString() + "]");
        }
    }

    public static void printLottoResultHeaderMessage() {
        System.out.println(LOTTO_RESULT_HEADER_MESSAGE);
    }

    public static void printLottoResult(String winningResultInfo, int count) {
        System.out.println(winningResultInfo + count + "개");
    }

    public static void printEarningRate(String earningRate) {
        System.out.printf(LOTTO_EARNING_RATE_MESSAGE, earningRate);
        System.out.println();
    }

    public static void printIssueCount(long issueCnt) {
        System.out.printf(LOTTO_ISSUE_COUNT_MESSAGE, issueCnt);
        System.out.println();
    }
}
