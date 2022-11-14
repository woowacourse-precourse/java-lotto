package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(NumberOfLotto numberOfLotto) {
        // LottoNumber lottoNumber = new LottoNumber();
        int number = numberOfLotto.getNumberOfLotto();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(setLotto()));
        }

        this.lottos = lottos;
        printLottos();
    }

    private List<Integer> setLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void printLottos() {
        for (Lotto lotto : this.lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
