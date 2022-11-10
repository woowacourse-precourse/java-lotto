package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현c
    }

    /* 구매금액 입력 관련 */
    static Long purchase() {
        String purchaseAmountInputStr = purchaseAmountInput();
        validatePurchaseAmountInput(purchaseAmountInputStr);

        Long purchaseAmountInput = transformStringNumberToLong(purchaseAmountInputStr);
        return calculatePurchaseQuantity(purchaseAmountInput);
    }

    static String purchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    static Long transformStringNumberToLong(String purchaseAmount) {
        return Long.parseLong(purchaseAmount);
    }

    static void validatePurchaseAmountInput(String purchaseAmountInput) {
        if (!purchaseAmountInput.replaceAll("[0-9]", "").equals("")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
        }

        if (purchaseAmountInput.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해 주세요.");
        }

        Long intPurchaseAmountInput = transformStringNumberToLong(purchaseAmountInput);
        if(intPurchaseAmountInput % 1000 != 0 || intPurchaseAmountInput == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해 주세요.");
        }

    }

    static Long calculatePurchaseQuantity(Long purchaseAmount) {
        return purchaseAmount / 1000;
    }

}
