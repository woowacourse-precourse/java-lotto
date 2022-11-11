package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumberGenerater {

    final int MIN_NUMBER = 1;
    final int MAX_NUMBER = 45;
    final int LENGTH = 6;
    private static final Map<Integer, LottoNumber> idxLottoNumber = new HashMap<>();

    public LottoNumberGenerater() {

    }

    public Map<Integer, LottoNumber> makeLottoNumberMap() {
        LottoNumber[] lottoNumbers = LottoNumber.values();
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            idxLottoNumber.put(number, lottoNumbers[number - 1]);
        }
        return idxLottoNumber;
    }

    public List<Integer> makeLottoNumber(Lotto lotto) {
        List<Integer> lottoNumber = new ArrayList<>();
        for (int number = 0; number < LENGTH; number++) {
            lottoNumber.add(lotto.get(number).getNumber());
        }
        return lottoNumber;
    }
}
