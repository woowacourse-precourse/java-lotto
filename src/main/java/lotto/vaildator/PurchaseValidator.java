package lotto.vaildator;

import java.rmi.server.ExportException;
import java.util.regex.Pattern;

public class PurchaseValidator {

    private final int LOTTO_PRICE = 1000;
    private final static String ERROR = "[ERROR]";
    private final static String ONE_THOUSAND_VALIDATE = "로또 구입은 1,000원 단위로 입력해 주세요.";
    private final static String INPUT_IS_CORRECT = "올바른 금액을 입력해주세요.";
    private final static String INPUT_NUMBER_VALIDATE = "올바른 숫자를 입력해주세요.";


    protected void validateInput(String lottoPrice) {
        if (validateNumberFormat(lottoPrice)) {
            throw new IllegalArgumentException(ERROR + INPUT_NUMBER_VALIDATE);
        } else if (ConvertStringToInteger(lottoPrice) % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(ERROR + ONE_THOUSAND_VALIDATE);
        } else if (!validateInputIsDigit(lottoPrice)) {
            throw new IllegalArgumentException(ERROR + INPUT_IS_CORRECT);
        }
    }

    private boolean validateInputIsDigit(String lottoPrice) {
        return lottoPrice.chars().allMatch(Character::isDigit);
    }

    private boolean validateNumberFormat(String lottoPrice) {
        String regExp = "^[1-9]\\d*0{3}$";
        if (Pattern.matches(regExp, lottoPrice)) {
            return false;
        }
        return true;
    }

    public int ConvertStringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
