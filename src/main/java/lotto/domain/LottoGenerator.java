package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoGenerator(int count) {
        createLotto(count);
    }

    private void createLotto(int count) {
        for (int index = 0; index < count; index++) {
            List<Integer> Numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> lottoNumbers = new ArrayList<>(Numbers);
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        printLotto();
    }

    private void printLotto() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
