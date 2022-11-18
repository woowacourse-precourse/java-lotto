package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Policy;
import java.util.List;
import java.util.Map;

public class IOProcessor {
    private enum Messages {
        ERROR_MESSAGE_PREFIX("[ERROR]"),
        BOUNS_NUMBER_FORMAT(", 보너스 볼 일치 "),
        PURCHASE("개를 구매했습니다."),
        STATISTICES_HEADER("당첨 통계\n---"),
        MARGIN_RATIO_FORMAT("총 수익률은 %.1f%%입니다.\n");

        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    private enum WinningMessageFormat {
        WINNING_FIVE("%d개 일치%s(%,d원) - %d개\n"),
        WINNING_FOUR("%d개 일치%s(%,d원) - %d개\n"),
        WINNING_THREE("%d개 일치%s(%,d원) - %d개\n"),
        WINNING_TWO("%d개 일치%s(%,d원) - %d개\n"),
        WINNING_ONE("%d개 일치%s(%,d원) - %d개\n");

        private final String format;

        WinningMessageFormat(String format) {
            this.format = format;
        }

        public String getFormat() {
            return this.format;
        }
    }

    /*
     * message: 입력 유도를 위해 출력되는 메시지
     * end: 입력메시지 뒤에 붙일 접미사
     * => 사용자에게 값을 입력받기 전 message + end가 출력됨
     */
    public static String getUserInput(String message, String end) {
        System.out.print(message + end);
        return Console.readLine();
    }

    public static void printLottoPurchaseInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + Messages.PURCHASE.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printWinningStatistics(Map<String, Integer> winningInfo) {
        System.out.println(Messages.STATISTICES_HEADER.getMessage());

        for (String key : winningInfo.keySet()) {
            String bonusNumber = " ";
            if (Policy.WinningCriteria.valueOf(key).getBonusNumberCount() == 1) {
                bonusNumber = Messages.BOUNS_NUMBER_FORMAT.getMessage();
            }
            System.out.printf(WinningMessageFormat.valueOf(key).getFormat(),
                    Policy.WinningCriteria.valueOf(key).getMatchingCount(),
                    bonusNumber,
                    Policy.WinningAmount.valueOf(key).getAmount(),
                    winningInfo.get(key));
        }
    }

    public static void printMarginInfo(double margin) {
        System.out.printf(Messages.MARGIN_RATIO_FORMAT.getMessage(), margin);
    }

    public static void printErrorMessage(String message) {
        System.out.println(Messages.ERROR_MESSAGE_PREFIX.getMessage() + " " + message);
    }
}