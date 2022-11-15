package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Domain {
    private static final String INPUT_LOTTO_AMOUNT = "로또금액을 입력해 주세요.";

    // TODO: 로또 금액 문장 출력 후 로또 금액을 입력 받는다.
    private static int inputLottoAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Exception.isCorrectAmount(Console.readLine());
    }

}
