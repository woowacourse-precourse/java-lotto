package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Constant.SHOW_BUY_COUNT;
import static lotto.Game.GeneratedLotto;

public class MakeLotto {
    public static void LottoGenerator(int nLotto) {
        System.out.println("\n" + nLotto + SHOW_BUY_COUNT);
        for (int i = 0; i < nLotto; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            GeneratedLotto.add(lottoNumbers);
        }
    }

    public static void PrintGeneratedLotto(int nLotto, List<List<Integer>> GeneratedLotto) {
        for (int i = 0; i < nLotto; i++) {
            List<Integer> lotto = GeneratedLotto.get(i);
            System.out.println(lotto);
        }
    }
}
