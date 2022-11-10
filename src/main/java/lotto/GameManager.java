package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameManager {

    public GameManager() {
    }

    public void run() {
    }

    private Lotto publishRandomLotto() {
        Lotto lotto;
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < 6) {
            Integer lottoNumber = pickNumberInRange(1, 45);
            if (!lottoNumbers.contains(lottoNumber)) {
                lottoNumbers.add(lottoNumber);
            }
        }
        lotto = new Lotto(lottoNumbers);

        return lotto;
    }
}
