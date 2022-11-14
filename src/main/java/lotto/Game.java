package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Lotto> listOfLottos;

    public List<Lotto> generateListOfLottos(int size) {
        List<Lotto> listOfLottos = new ArrayList<>();
        Lotto lotto;
        for (int idx = 0; idx < size; idx++) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            listOfLottos.add(lotto);
        }
        return listOfLottos;
    }

}
