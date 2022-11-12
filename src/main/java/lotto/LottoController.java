package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class LottoController {

    public void readUserMoney(String userMoney) {
        isDigit(userMoney);
        validate(userMoney);
    }

    private void isDigit(String userInput){
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, userInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주셔야 합니다");
        }
    }

    private void validate(String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 금액을 입력해야합니다");
        }
    }
}
