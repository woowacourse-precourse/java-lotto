package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLottoNumber {
    private final int maxNumber = 6;
    private final int rangeStartValue = 1;
    private final int rangeEndValue = 45;


    public List<Integer> returnLottoNumber() {
        List<Integer> tmp;
        tmp = Randoms.pickUniqueNumbersInRange(rangeStartValue, rangeEndValue, maxNumber);
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        lottoNumbers.addAll(tmp);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

}
