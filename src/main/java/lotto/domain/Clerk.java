package lotto.domain;

import lotto.Constants;

public class Clerk {

    public int giveLottoQuantity(String input) {
        int money;
        int lottoQuantity;

        validateBlank(input);
        money = validateNumeric(input);
        validateZero(money);
        validateRest(money);

        lottoQuantity = money / Constants.LOTTO_PRICE.getValue();

        return lottoQuantity;
    }

    private void validateZero(int money) {
        if (money == 0) {
            throw new IllegalArgumentException("0원은 입력받을 수 없습니다.");
        }
    }

    private void validateRest(int money) {
        money = money % Constants.LOTTO_PRICE.getValue();
        if (money != 0) {
            throw new IllegalArgumentException("입력금액과 로또 금액이 나누어 떨어지지 않습니다.");
        }
    }

    private int validateNumeric(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수가 아닌 입력이 있습니다.");
        }
        return money;
    }

    private void validateBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }

}
