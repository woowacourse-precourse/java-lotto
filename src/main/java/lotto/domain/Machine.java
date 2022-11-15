package lotto.domain;

import java.math.BigInteger;

public class Machine {

    public static BigInteger countNumberOfLottos(BigInteger money) {
        return money.divide(BigInteger.valueOf(1_000));
    }

}
