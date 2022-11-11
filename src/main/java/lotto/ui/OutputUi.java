package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class OutputUi {

    private static final String INSERT_MONEY_INFO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_INFO_MESSAGE_FORMAT = "\n%d개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_INFO_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_INFO_MESSAGE = "\n보너스 번호를 입력해 주세요.";


    public static void printInsertMoneyInfoMessage() {
        System.out.println(INSERT_MONEY_INFO_MESSAGE);
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {

        System.out.println(String.format(PURCHASED_LOTTO_COUNT_INFO_MESSAGE_FORMAT, lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printInputWinningNumbersInfoMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_INFO_MESSAGE);
    }

    public static void printInputBonusNumberInfoMessage() {
        System.out.println(INPUT_BONUS_NUMBER_INFO_MESSAGE);
    }

}
