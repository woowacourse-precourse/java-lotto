package lotto;

public class LotteriesExceptionCase {
    public static void validateInputType(String amount) {
        for (int seq = 0; seq < amount.length(); seq++) {
            characterCheck(amount.charAt(seq));
        }
    }

    public static void characterCheck(char inputSequence) {
        if (47 >= inputSequence || 58 <= inputSequence) {
            System.out.println("[ERROR] 금액은 숫자로만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputEmpty(String amount) {
        if (amount.equals("")) {
            System.out.println("[ERROR] 공백을 입력할 수 없습니다 금액을 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateAmount(String amount) {
        int money = Integer.parseInt(amount);
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}