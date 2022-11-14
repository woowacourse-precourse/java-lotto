package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CreateLottoNum {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int COUNT_LOTTO_NUM = 6;

    private final List<Lotto> userLottoNumbers = new ArrayList<>();

    public List<Lotto> getGetLottoNumbers(int countTickets) {
        for (int i = 0; i < countTickets; i++) {
            userLottoNumbers.add(new Lotto(generateLottoNumber()));
        }
        return userLottoNumbers;
    }
    private static List<Integer> generateLottoNumber() {
        List<Integer> tmpLottoNumber = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM
                , MAX_LOTTO_NUM, COUNT_LOTTO_NUM);
        Collections.sort(tmpLottoNumber);
        return tmpLottoNumber;
    }
}