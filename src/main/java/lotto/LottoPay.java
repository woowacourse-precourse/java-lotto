package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPay {
    private static final String MESSAGE = "[ERROR]";
    private static Long payment;

    public static long LottoPay() {
        String pay = Console.readLine();
        try {
            payment = Long.parseLong(pay);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE + " 숫자만 입력해 주세요.");

        }
        validatePay(payment);

        return payment;
    }

    private static void validatePay(Long payment) {
        if (payment < 1000) {
            throw new IllegalArgumentException(MESSAGE + " 최소 구매 금액은 1,000원 입니다.");
        }
        if (payment >= 2_000_000_000) {
            throw new IllegalArgumentException(MESSAGE + " 최대 구매 금액은 20억 미만입니다.");
        }
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(MESSAGE + " 구매금의 최소 단위는 1,000원 입니다.");
        }
    }

}
