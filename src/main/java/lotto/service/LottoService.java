package lotto.service;

import lotto.common.Error;

public class LottoService {

    public void buy(String in) {
        int money = isValid(in);
    }

    private int isValid(String in) {
        int i = 0;
        try {
            i = Integer.parseInt(in);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.NUMBER.getMsg());
        }
        if (i % 1000 != 0) {
            throw new IllegalArgumentException(Error.THOUSAND.getMsg());
        }
        return i;
    }
}
