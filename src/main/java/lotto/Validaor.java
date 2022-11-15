package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Validaor {

    public static Integer validatePurchaseAmount(String inputVal) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(inputVal);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000의 배수여야 합니다.");
        }
        return purchaseAmount;
    }


}
