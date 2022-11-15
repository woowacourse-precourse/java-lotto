package lotto.utils;

public class Validator {
    public static void validateMoney(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 반드시 1,000원 단위여야 합니다.");
        }
    }
}
