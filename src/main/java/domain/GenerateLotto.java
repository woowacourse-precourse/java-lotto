package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLotto {
    public List<Lotto> lottoNumber = new ArrayList<>();

    public GenerateLotto(int lottoCount) {
        getLottoNumber(lottoCount);
    }

    private void getLottoNumber(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoOneGame = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoOneGame);
            Lotto oneLotto = new Lotto(lottoOneGame);
            lottoNumber.add(oneLotto);
        }
    }
}
