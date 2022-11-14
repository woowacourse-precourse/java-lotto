package lotto.domain;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class ListOfLottos {
    private List<Lotto> listOfLottos;

    public ListOfLottos(int size) {
        this.listOfLottos = new ArrayList<>();
        Lotto lotto;
        for (int idx = 0; idx < size; idx++) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            listOfLottos.add(lotto);
        }
    }
    public void printAllLottos() {
        for (Lotto lotto : this.listOfLottos) {
            lotto.printLotto();
        }
    }
}
