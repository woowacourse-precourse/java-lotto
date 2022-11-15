package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class LottoNum {

    private static final int Lotto_MIN = 1;
    private static final int Lotto_MAX = 45;

    private final int number;

    public LottoNum(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private static void validateNumberRange(int number) {
        if (number < Lotto_MIN || Lotto_MAX < number) {
            throw new IllegalArgumentException("[ERROR]1~45범위의 숫자가 아닙니다." );
        }
    }

    public int getNumber() {
        return number;
    }




}
