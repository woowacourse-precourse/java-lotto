package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    public List<Lotto> getLottos(int numberPurchase){ // Lotto-create-001
        List<Lotto> lottos = new ArrayList<>();
        for (int nowPurchase = 0; nowPurchase < numberPurchase; nowPurchase++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }
}
