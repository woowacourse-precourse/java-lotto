package lotto.print;

import java.text.DecimalFormat;
import java.util.List;

import lotto.Lotto;

public class PrintOutputMessage {

    private static final String PRINT_PURCHASE_AMOUNT = "\n%d개를 구매했습니다.\n";

    private static final String PRINT_WINNING_STATISTICS = "당첨 통계\n---";

    private static final String PRINT_WINNING_PRIZE_AMOUNT = "%d개 일치 (%d원) - %d개";

    private static final String PRINT_TOTAL_PROFIT_RATE = "총 수익률은 %.2f입니다.";

    DecimalFormat formatWinningPrize = new DecimalFormat("###,###");

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

}
