package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String REQUEST_INPUT_TARGET_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {

    }

    public static String requestInputMoney(){
        System.out.println(REQUEST_INPUT_MONEY);
        return Console.readLine();
    }

    public static String requestInputTargetLottoNumbers(){
        System.out.println(REQUEST_INPUT_TARGET_LOTTO_NUMBERS);
        return Console.readLine();
    }

    public static String requestBonusNumber(){
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
