package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Integer numberOfLottoes =
                getTheNumberOfLottoesAsMuchThePurchaseAmount(
                        Integer.parseInt(Console.readLine())
                );
    }

    public static Integer getTheNumberOfLottoesAsMuchThePurchaseAmount(Integer purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / 1000;

    }

    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000의 배수가 아닙니다.");
        }
    }
}
