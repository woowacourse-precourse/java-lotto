package lotto.domain;

public class LottoBuyer {
    private static final String INT_REGEX = "^[0-9]*$";
    public void checkPayUnit(int money) {
        if(money%1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000 단위로만 입력 가능합니다.");
        }
    }

    public void checkOnlyNumber(String input) {
        if(!input.matches(INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
