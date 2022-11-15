package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public List<List<Integer>> lottoNums;
    private int buyAmount;

    public LottoNumbers(int buyAmount) {
        this.buyAmount = buyAmount;
        lottoNums = new ArrayList<>();
        setLottoNumbers();
    }

    private void setLottoNumbers() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < buyAmount; i++) {
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6); //중복 숫자는 리스트에 저장 하지 않음.

            System.out.println(lotto);

            lottoNums.add(lotto);
        }
    }
}
