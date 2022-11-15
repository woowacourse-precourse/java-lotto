package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoIssue {
    public static List<Lotto> issueLotto(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(lottoNumber));
            lotto.get(i).printSortedLottoNumbers();
        }

        return lotto;
    }
}
