package lotto.application.port.in.dto;

import lotto.exception.MoneyIllegalArgumentException;

public class RequestBuyLottoDto {
    private String money;

    public RequestBuyLottoDto(String money) {
        validate(money);
        this.money = money;
    }

    public int convertToInteger() {
        int result = Integer.parseInt(this.money);
        return result;
    }

    private void validate(String money) {
        System.out.println(money);
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                throw new MoneyIllegalArgumentException("숫자여야합니다.");
            }
        }
    }
}
