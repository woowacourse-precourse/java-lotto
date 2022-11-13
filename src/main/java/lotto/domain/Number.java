package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final String ERROR_NUMBER_DUPLICATED = "[ERROR] 로또 번호가 중복되었습니다.";
    public static final String ERROR_NUMBER_LENGTH = "[ERROR] 로또 번호는 6자리여야 합니다.";
    public static final String ERROR_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_LENGTH);
    }
}
