package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public List<Integer> lottoNums;

    public LottoNumbers() {
        lottoNums = new ArrayList<>();
        setLottoNumbers();
    }

    private void setLottoNumbers() {
        lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6); //중복 숫자는 리스트에 저장 하지 않음.
        Collections.sort(lottoNums);
    }
}
