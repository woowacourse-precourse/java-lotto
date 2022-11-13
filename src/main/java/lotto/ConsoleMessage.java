package lotto;

import java.util.List;

public enum ConsoleMessage {
    START {
        public void printMsg() {
            System.out.println(START_MSG);
        }
    },
    PURCHASE {
        public void printMsg(List<Lotto> purchasedLotto) {
            String message = String.format(PURCHASE_MSG, purchasedLotto.size());
            System.out.println(message);
            for (Lotto lotto : purchasedLotto) {
                System.out.println(lotto);
            }
        }
    },
    WINNING_NUMBER {
        public void printMsg() {
            System.out.println(WINNING_NUMBER_MSG);
        }
    },
    BONUS_NUMBER {
        public void printMsg() {
            System.out.println(BONUS_NUMBER_MSG);
        }
    },
    RESULT {
        public void printMsg(int[] result) {
            String message = String.format(RESULT_MSG, result[0], result[1], result[2], result[3], result[4]);
            System.out.println(message);
        }
    },
    YIELD {
        public void printMsg(double yield) {
            String message = String.format(YIELD_MSG, yield);
            System.out.println(message);
        }
    };

    public static final String START_MSG ="구입금액을 입력해주세요.";
    public static final String PURCHASE_MSG ="%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_MSG = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_MSG = "보너스 번호를 입력해주세요";

    //Result 결과에 따라 다른 값을 입력하기 위해 %d, %s를 사용함
    private static final String RESULT_MSG =
            "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개";
    private static final String YIELD_MSG = "총 수익률은 %.2f%%입니다.";

    public void printMsg() {}
    public void printMsg(int[] result) {}
    public void printMsg(double yield) {}
    public void printMsg(List<Lotto> purchasedLotto) {}
}
