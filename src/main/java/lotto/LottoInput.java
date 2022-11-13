package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoInput {
    private static final String BOUGHT_LOTTO = "개를 구매했습니다.";
    private static final String INPUT_MONEY = "구입 금액을 입력하세요.";
    public static int inputMoney; // 구입금액
    public static int numberOfLotto; // 로또 개수

    // 구입금액 입력
    public static int inputNumber() {
        System.out.println(INPUT_MONEY);
        String inputNum = Console.readLine();
        Validator.validateInteger(inputNum); // 정수만 입력되었는지 확인
        inputMoney = Integer.parseInt(inputNum);
        Validator.validateInputMoney(inputMoney); // 1000원 단위로 구입했는지 확인
        Validator.validateNegativePrice(inputMoney); // 음수로 입력했는지 확인

        return inputMoney;
    }

    // 구입한 로또 개수
    public static int theNumberOfLotto() {
        numberOfLotto = inputMoney / 1000;
        System.out.println(numberOfLotto + BOUGHT_LOTTO);

        return numberOfLotto;
    }
}
