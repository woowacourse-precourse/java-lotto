package lotto.service;

import lotto.domain.Buyer;

public class LottoService {
    public static final int STANDARD_WON = 1000;
    public static final String NOT_MOD_ZERO_MESSAGE = "[ERROR] 1000으로 나누어지는 금액이 아닙니다.";

    public LottoService(Buyer buyer) {
        int money = Integer.parseInt(buyer.inputMoney());
        validateMoney(money);
    }

    public void validateMoney(int money) {
        if(Math.floorMod(Math.round(money), STANDARD_WON) != 0) {
            throw new IllegalArgumentException(NOT_MOD_ZERO_MESSAGE);
        }
    }
}
