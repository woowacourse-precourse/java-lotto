package lotto.print;

import java.text.DecimalFormat;
import java.util.List;

import lotto.Lotto;
import lotto.LottoAmount;
import lotto.LottoRank;

public class PrintOutputMessage {

    private static final int ZERO = 0;

    private static final String PRINT_PURCHASE_AMOUNT = "\n%d개를 구매했습니다.\n";

    private static final String PRINT_WINNING_STATISTICS = "당첨 통계\n---";

    private static final String PRINT_WINNING_PRIZE_AMOUNT = "%s - %d개\n";

    private static final String PRINT_TOTAL_PROFIT_RATE = "총 수익률은 %.1f%입니다.";

    public static void printLottoAccount(int lottoAccount) {
        System.out.printf(PRINT_PURCHASE_AMOUNT,lottoAccount);
    }

    public static void printUserLottoNumbers(List<Lotto> userLottoNumbers) {
        System.out.printf(PRINT_PURCHASE_AMOUNT,userLottoNumbers.size());
        for(int i = 0 ; i < userLottoNumbers.size(); i++) {           //for문 작성법 수정
            System.out.println(userLottoNumbers.get(i).getNumbers());
        }
        System.out.println();
    }
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printLottoRank(int[] countWinPrize) {
        System.out.println();
        System.out.println(PRINT_WINNING_STATISTICS);
        System.out.printf(PRINT_WINNING_PRIZE_AMOUNT,LottoRank.FIFTH.printPrintPrize(),countWinPrize[LottoRank.FIFTH.printLottoRank()]);
        System.out.printf(PRINT_WINNING_PRIZE_AMOUNT,LottoRank.FOURTH.printPrintPrize(),countWinPrize[LottoRank.FOURTH.printLottoRank()]);
        System.out.printf(PRINT_WINNING_PRIZE_AMOUNT,LottoRank.THIRD.printPrintPrize(),countWinPrize[LottoRank.THIRD.printLottoRank()]);
        System.out.printf(PRINT_WINNING_PRIZE_AMOUNT,LottoRank.SECOND.printPrintPrize(),countWinPrize[LottoRank.SECOND.printLottoRank()]);
        System.out.printf(PRINT_WINNING_PRIZE_AMOUNT,LottoRank.FIRST.printPrintPrize(),countWinPrize[LottoRank.FIRST.printLottoRank()]);
    }
    public static void printLottoRatio(LottoAmount purchaseAmount, int[] countWinPrize) {
        float ratio = countWinPrize[ZERO]/purchaseAmount.getpurchaseAmount();
        System.out.printf(PRINT_TOTAL_PROFIT_RATE,ratio);
    }
    }
