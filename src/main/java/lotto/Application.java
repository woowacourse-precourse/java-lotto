package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return convertToNumber(purchaseAmount);
    }

    static int convertToNumber(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수여야 합니다.");
        }
    }

    static int quantityOfLotto(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    static void validateEnoughMoney(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 부족합니다.");
        }
    }

    static void validateChangeIsZero(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 남는 금액이 존재합니다.");
        }
    }
}
