package lotto.service;

import lotto.domain.Buyer;

public class LottoService {
    public static final int STANDARD_WON = 1000;
    public static final int ZERO_WON = 0;
    public static final String NOT_MOD_ZERO_MESSAGE = "[ERROR] 1000으로 나누어지는 금액이 아닙니다.";
    public static final String REJECT_ZERO = "[ERROR] 구입 금액에 0을 입력할 수 없습니다.";
    
    public LottoService() { }

    public void validateMoney(int money) {
        if(money == ZERO_WON) { throw new IllegalArgumentException(REJECT_ZERO); }

        if(Math.floorMod(Math.round(money), STANDARD_WON) != 0) { throw new IllegalArgumentException(NOT_MOD_ZERO_MESSAGE); }
    }
}
