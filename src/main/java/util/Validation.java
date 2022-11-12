package util;

public class Validation {

    // 구입 금액이 1000의 배수인지 검증하는 기능
    public static void validatePurchaseMoney(String money) {
        if(Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000의 배수여야 합니다.");
        }
    }

}
