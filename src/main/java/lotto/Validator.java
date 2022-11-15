package lotto;

public class Validator {
    public static void validatePurchaseMoney(String input) {
        if (!input.trim().matches("^[0-9]+$") || Long.parseLong(input) <= 0) {
            System.out.println("[ERROR] 금액은 자연수여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (Long.parseLong(input) % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateNumber(String input) {
        if (!input.trim().matches("^[0-9]+$")) {
            System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
}
