package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    private static final int CNT_NUMBER = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private List<List> userLotto = new ArrayList<>();

    public UserLotto() {}

    public void setRandomNumber(){
        List<Integer> lottoNumbers = new ArrayList<>();

        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,CNT_NUMBER);
        Collections.sort(lottoNumbers);

        new Lotto(lottoNumbers);

        userLotto.add(lottoNumbers);
    }

}
