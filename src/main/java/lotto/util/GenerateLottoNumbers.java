package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.UserLotto;

public class GenerateLottoNumbers {
    public static List<UserLotto> generateLottoNumbers(int buyingPrice) {
        List<UserLotto> lottos = new ArrayList<>();
        int quantity = buyingPrice / 1000;
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            lottos.add(new UserLotto(lottoNumbers));
        }
        return lottos;
    }
}
