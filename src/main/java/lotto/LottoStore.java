package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    private List<Integer> winNumbers;

    private Lotto getNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    public List<Lotto> sellLottos(int money) {
        int affordLottos = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<affordLottos; i++) {
            lottos.add(getNewLotto());
        }

        return lottos;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }
}
