package lotto.View;

import static lotto.Utils.Constant.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Model.Buyer;
import lotto.Model.Calculator;
import lotto.Model.Lotto;
import lotto.Model.WinningRank;

public class OutputView {

    private static final String PRINT_NUMBER_OF_LOTTO = "%d개를 구매했습니다.";
    private static final String PRINT_STATISTICS = "당첨 통계";
    private static final String PRINT_LINE = "---";
    private static final String NEXT_LINE = "%n";
    private static final String PRINT_FIFTH_RANK = "3개 일치 (5,000원) - %d개";
    private static final String PRINT_FORTH_RANK = "4개 일치 (50,000원) - %d개";
    private static final String PRINT_THIRD_RANK = "5개 일치 (1,500,000원) - %d개";
    private static final String PRINT_SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String PRINT_FIRST_RANK = "6개 일치 (2,000,000,000원) - %d개";
    private static final String PRINT_EARNED_RATIO = "총 수익률은 %.1f%%입니다.";



    public static void printBuyerLotto(Buyer buyer) {
        printBlankLine();
        int count = buyer.getPurchaseCount();
        System.out.printf(PRINT_NUMBER_OF_LOTTO, count);
        System.out.println();
        printLottoWallet(buyer.getLottoWallet());
    }

    public static void printLottoWallet(List<Lotto> wallet) {
        for (int i = ZERO; i < wallet.size(); i++) {
            List<Integer> numbers = wallet.get(i).getNumbers();
            numbers.stream()
                    .sorted(Collections.reverseOrder().reversed())
                    .collect(Collectors.toList());
            System.out.println(numbers.toString());
        }
    }

    public static void printWinningStatistics(Calculator calculator) {
        printBlankLine();
        System.out.println(PRINT_STATISTICS);
        System.out.println(PRINT_LINE);
        System.out.printf(PRINT_FIFTH_RANK + NEXT_LINE, calculator.CountOfRank(WinningRank.FIFTH));
        System.out.printf(PRINT_FORTH_RANK + NEXT_LINE, calculator.CountOfRank(WinningRank.FOURTH));
        System.out.printf(PRINT_THIRD_RANK + NEXT_LINE, calculator.CountOfRank(WinningRank.THIRD));
        System.out.printf(PRINT_SECOND_RANK + NEXT_LINE,
                calculator.CountOfRank(WinningRank.SECOND));
        System.out.printf(PRINT_FIRST_RANK + NEXT_LINE, calculator.CountOfRank(WinningRank.FIRST));
        System.out.printf(PRINT_EARNED_RATIO, calculator.earnedRatio());
    }

    public static void printBlankLine(){
        System.out.println("");
    }
}
