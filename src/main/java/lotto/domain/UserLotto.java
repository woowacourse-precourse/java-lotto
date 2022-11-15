package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
        return new Lotto(lottoNumbers);
    }

    public int getSize() {
        int count = 0;
        for(Lotto lotto : lottos) {
            count++;
        }
        return count;
    }

    public Lotto getLottos(int index) {
        return lottos.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos) {
            sb.append("[");
            sb.append(lotto.toString()).append("]\n");
        }
        return sb.toString();
    }

}
