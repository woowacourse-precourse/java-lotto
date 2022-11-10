package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class MyLottoNumbers {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int SIZE = 6;

    private List<Integer> myLottoNumbers;



    public List<Integer> getMyLottoNumbers() {
        myLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE);
        Lotto lotto = new Lotto(myLottoNumbers);
        Collections.sort(myLottoNumbers);
        return myLottoNumbers;
    }

}
