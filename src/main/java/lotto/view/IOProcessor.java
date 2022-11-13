package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import java.util.List;

public class IOProcessor {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    private enum WinningMessageFormat {
        WINNING_ONE("6개 일치 (%,d원) - %d개\n"),
        WINNING_TWO("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
        WINNING_THREE("5개 일치 (%,d원) - %d개\n"),
        WINNING_FOUR("4개 일치 (%,d원) - %d개\n"),
        WINNING_FIVE("3개 일치 (%,d원) - %d개\n");

        private final String format;

        WinningMessageFormat(String format) {
            this.format = format;
        }

        public String getFormat() {
            return this.format;
        }
    }

    public static String getUserInput(String message, String end) {
        /*
         * message: 입력 유도를 위해 출력되는 메시지
         * end: 입력메시지 뒤에 붙일 접미사
         * => 사용자에게 값을 입력받기 전 message + end가 출력됨
         */
        System.out.print(message + end);
        return Console.readLine();
    }

    public static void printLottoPurchaseInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printWinningStatistics(List<Integer> winningInfo) {
        System.out.println("당첨 통계\n---");
        WinningMessageFormat[] formats = WinningMessageFormat.values();
        for (int i = 0; i < formats.length; i++)
            System.out.printf(formats[i].getFormat(), 0, winningInfo.get(i));
    }

    public static void printMarginInfo(double margin) {
        System.out.printf("총 수익률은 %.1f%%입니다.", margin);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}