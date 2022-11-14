package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Lotto> createLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        while(lottoList.size()<amount) {
            lottoList.add(new Lotto(getLottoNumbers()));
        }
        return lottoList;
    }
}
