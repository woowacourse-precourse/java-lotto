package lotto;

import static lotto.FinalString.REQUIRE_INPUT_MONEY;
import static lotto.Validator.validateInputMoney;
import static lotto.Validator.validateInteger;
import static lotto.Validator.validateMaxInputMoney;
import static lotto.Validator.validateNegativePrice;

import camp.nextstep.edu.missionutils.Console;

// 랜덤한 로또 생성
public class LottoGenerator {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM_LENGTH = 6;

    //금액 검사
    private void validateMoney(int price) {
        validateNegativePrice(price);        // 음수 확인
        validateInputMoney(price);           // 1000원 단위인지 확인
        validateMaxInputMoney(price);        // 10만원 한도 넘겼는지 확인
    }

    private int inputMoney() {
        System.out.println(REQUIRE_INPUT_MONEY);
        String input = Console.readLine();
        validateInteger(input);
        int inputMoney = Integer.parseInt(input);
        validateMoney(inputMoney);

        return inputMoney;
    }

}

