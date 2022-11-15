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
        List<Lotto> myLotto = new ArrayList<>();
        while (myLotto.size() < amount) {
            myLotto.add(new Lotto(getLottoNumbers()));
        }
        return myLotto;
    }
}
