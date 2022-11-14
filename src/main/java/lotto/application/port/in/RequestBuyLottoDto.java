package lotto.application.port.in;

import exception.MoneyIllegalArgumentException;

public class RequestBuyLottoDto {
    private String money;

    public RequestBuyLottoDto(String money) {
        this.money = money;
    }

    public int convertToInteger() {
        try {
            int result = Integer.parseInt(this.money);
            return result;
        } catch (RuntimeException exception) {
            throw new MoneyIllegalArgumentException("잘못된 입력값 - 돈은 숫자로만 이루어져있어야합니다.");
        }
    }
}
