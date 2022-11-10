package lotto.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(int amountOfLotto) {
        lottos = new ArrayList<>();
        settingLottos(amountOfLotto);
    }



    private void settingLottos(int amountOfLotto) {
        for (int i = 0; i < amountOfLotto; i++) {
            List<Integer> unSortedLottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(unSortedLottoNumbers);
            lottos.add(new Lotto(unSortedLottoNumbers));
        }
    }

    public static Lottos from(int amountOfLotto) {
        return new Lottos(amountOfLotto);
    }

    public List<Lotto> currentLottos() {
        return lottos;
    }

    public void printWholeLottoNumbers() {
        lottos.stream().forEach(lotto -> lotto.printLottoNumbers());
    }
}
