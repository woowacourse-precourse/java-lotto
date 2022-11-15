package lotto.application.port.in.dto;

import lotto.exception.ErrorPrefix;

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
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                String message = ErrorPrefix.IllegalArgumentException.getPrefix()
                        + "숫자여야합니다.";
                System.out.println(message);
                throw new IllegalArgumentException(message);
            }
        }
    }
}
