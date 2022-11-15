package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Util;

public class Input {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public static int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return inputNumber();
    }

}
