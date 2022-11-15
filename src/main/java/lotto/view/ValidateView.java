package lotto.view;

import lotto.constant.LottoConstant;

public class ValidateView {
    // test: test/java/lotto/view/ValidateViewTest
    public static int possibleNumber(String number) throws IllegalArgumentException {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1,000원으로 나누어 떨어져야한다.");
        }
        return num;
    }

    // test: test/java/lotto/view/ValidateViewTest
    public static boolean isPossibleMoney(int money) throws IllegalArgumentException {
        if(money / LottoConstant.ONE_PRICE == 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 이상이어야 합니다.");
        }

        if(money % LottoConstant.ONE_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위입니다.");
        }

        return true;
    }

    public static boolean isPossibleBonusNumber(int num) throws IllegalArgumentException {
        if(num < LottoConstant.START_NUMBER || num > LottoConstant.END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        return true;
    }
}
