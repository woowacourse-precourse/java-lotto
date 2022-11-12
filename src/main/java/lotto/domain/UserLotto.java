package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    private List<Lotto> lottos;

    public void setLottos(int lottoQuantity) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public int getSize() {
        int count = 0;
        for(Lotto lotto : lottos) {
            count++;
        }
        return count;
    }

}
