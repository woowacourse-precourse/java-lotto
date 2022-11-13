package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TYPE_ERROR = "[ERROR] 금액은 숫자만 입력 가능합니다.";

    public static int inputPlayerAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }



}
