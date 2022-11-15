package lotto.vaildator;

public class PurchaseValidator {

    private final int LOTTO_PRICE = 1000;
    private final static String ONE_THOUSAND_VALIDATE = "[ERROR] 로또 구입은 1,000원 단위로 입력해 주세요.";
    private final static String INPUT_IS_CORRECT = "[ERROR] 올바른 금액을 입력해주세요.";

    protected void validateInput(String lottoPrice) {
        if (ConvertStringToInteger(lottoPrice) % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(ONE_THOUSAND_VALIDATE);
        } else if (!validateInputIsDigit(lottoPrice)) {
            throw new IllegalArgumentException(INPUT_IS_CORRECT);
        }
    }

    private boolean validateInputIsDigit(String lottoPrice) {
        return lottoPrice.chars().allMatch(Character::isDigit);
    }

    public int ConvertStringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
