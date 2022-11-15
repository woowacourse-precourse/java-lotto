package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_NUMS_SIZE;
import static lotto.domain.Lotto.MIN_LOTTO_NUM;
import static lotto.domain.Lotto.MAX_LOTTO_NUM;

public class UserLottos {
    private final List<Lotto> lottos;

    public UserLottos(int ticketCount) {
        validate(ticketCount);
        this.lottos = createLottos(ticketCount);
    }

    public void validate(int ticketCount) {
        if (ticketCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 발행할 로또 개수는 적어도 하나 이상이여야 합니다.");
        }
    }

    public List<Lotto> createLottos(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUMS_SIZE);
            lottos.add(new Lotto(nums));
        }
        return lottos;
    }

    public List<Lotto> get() {
        return lottos;
    }
}
