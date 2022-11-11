package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Validator {

    private final int LENGTH = 6;
    private final int MAX_VALUE = 45;
    private final int MIN_VALUE = 1;
    private final int MONEY_UNIT = 1000;
    private final int MIN_MONEY = 1000;

    public Validator() {

    }
    public void validateMoneyOnlyNumber(String inputMoney){
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, inputMoney)) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로만 입력해야 합니다.");
        }
    }

    public void validateMoney(int inputMoney) {
        if(inputMoney<MIN_MONEY){
            throw new IllegalArgumentException("[ERROR] 1000원 이상 내셔야 로또 구매가 가능합니다.");
        }
        if (inputMoney % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력해야 합니다.");
        }
    }
}
