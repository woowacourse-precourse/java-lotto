package lotto.view;

import lotto.exception.CheckThisNumException;

public class InputLottoView {
    private static final String HOW_MUCH_YOU_BUY = "구입금액을 입력해 주세요.";
    private static final String PLEASE_INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PLEASE_INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String printHowMuch() {
        System.out.println(HOW_MUCH_YOU_BUY);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }


    public static String printInputLottoNumber() {
        System.out.println(PLEASE_INPUT_LOTTO_NUMBER);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public static String printInputLottoBonusNumber() {
        System.out.println(PLEASE_INPUT_LOTTO_BONUS_NUMBER);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
