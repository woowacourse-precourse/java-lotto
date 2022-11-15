package lotto;

import java.text.NumberFormat;

public class SystemMessage {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static void moneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public static void purchaseLotto(int lottoTickets, Lottos lottos) {
        System.out.println();
        System.out.println(lottoTickets + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static String putComma(int number) {
        return NumberFormat.getInstance().format(number);
    }

}
