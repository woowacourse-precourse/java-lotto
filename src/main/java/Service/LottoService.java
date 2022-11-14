package Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public static List<Lotto> lottos = new ArrayList<>();

    public static void lottoSpawner(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public static void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            lotto.print();
            System.out.print("\n");
        }
    }
}
