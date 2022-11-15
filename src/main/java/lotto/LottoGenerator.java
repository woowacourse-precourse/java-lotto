package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int lottoCount;
    List<Lotto> userLotto = new ArrayList<>();

    public LottoGenerator(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void publishLotto() {
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLotto.add(new Lotto(numbers));
        }
    }

    public void printLotto() {
        for(Lotto lotto: userLotto) {
            System.out.println(lotto);
        }
    }
}
