package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLottoNumbers {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int SIZE = 6;

    private List<Integer> mine;
    List<Integer> myLottoNumbers;

    public List<Integer> getMyLottoNumbers() {
        mine = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE);
        myLottoNumbers = new ArrayList<>(mine);
        Lotto lotto = new Lotto(myLottoNumbers);
        Collections.sort(myLottoNumbers);
        return myLottoNumbers;
    }
}
