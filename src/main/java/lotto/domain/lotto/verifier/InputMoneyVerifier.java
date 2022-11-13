package lotto.domain.lotto.verifier;

public class InputMoneyVerifier {

    private static final String REGEXP = "[0-9]+";

    public static void inputMoneyVerifier(String inputMoney) {
        isMoneyOnlyNumber(inputMoney);
        isMoneyDividedBy1000(inputMoney);
    }

    private static void isMoneyDividedBy1000(String inputMoney) {
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 돈만 입력할 수 있습니다.");
        }
    }

    private static void isMoneyOnlyNumber(String inputMoney) {
        if (!inputMoney.matches(REGEXP)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
