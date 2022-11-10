package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    // 구입 금액
    private final int purchaseAmount;

    public UserInput(String purchaseAmount) {
        validDatePurchaseAmount(purchaseAmount);
        validDateThousandUnitPurchaseAmount(Integer.parseInt(purchaseAmount));
        validRangePurchaseAmount(Integer.parseInt(purchaseAmount));
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }
    private void validDatePurchaseAmount(String purchase) {
        try {
            int p = Integer.parseInt(purchase);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주셔야 합니다.");
        }
    }
    private void validDateThousandUnitPurchaseAmount(Integer purchase) {
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위의 숫자를 입력하셔야 합니다.");
        }
    }

    private void validRangePurchaseAmount(Integer purchase) {
        if (! (1000 <= purchase && purchase <= 100000)) {
            throw new IllegalArgumentException("로또는 최대 100,000원까지 구매하실 수 있습니다.");
        }
    }
    private String getUserInput() {
        System.out.println("입력"); // 상수로 변경하여 문자 출력
        return Console.readLine();
    }
}
