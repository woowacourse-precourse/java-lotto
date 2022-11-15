package ui;

import lotto.Lotto;
import lotto.Prize;
import user.User;

import java.util.List;

public class View {
    private static final String PROMPT_SEED_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_PURCHASE_MOUNT = "개를 구매했습니다.";
    private static final String RESULT_SUMMARY = "당첨 통계\n---";
    private static final String RESULT_TOTAL_PRIZE_PRE = "총 수익률은 ";
    private static final String RESULT_TOTAL_PRIZE_END = "%입니다.";

    public static void promptSeedMoney() {
        System.out.println(PROMPT_SEED_MONEY);
    }

    public static void promptWinningNumber() {
        System.out.println(PROMPT_WINNING_NUMBER);
    }

    public static void promptBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
    }

    public static void printPurchaseMount(User user) {
        System.out.println(user.getLottoMount() + RESULT_PURCHASE_MOUNT);
    }

    public static void printWinnigSummary(List<Integer> correctList) {
        System.out.println(RESULT_SUMMARY);
        String message = "";
        for (int i = 0; i < correctList.size(); i++) {
            System.out.println(Prize.getPrizeMessage(i + 1) + correctList.get(i) + "개");
        }
    }

    public static void printLottoList(User user) {
        for (Lotto lotto : user.getLottos()) {
            View.printLottoNumber(lotto.toNumberForm());
        }
    }

    public static void printLottoNumber(String numberForm) {
        System.out.println(numberForm);
    }

    public static void printTotalPrize(User user) {
        System.out.print(RESULT_TOTAL_PRIZE_PRE + user.getRatio() + RESULT_TOTAL_PRIZE_END);
    }
}