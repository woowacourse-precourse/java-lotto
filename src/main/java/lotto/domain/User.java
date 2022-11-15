package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private static final int ZERO = 0;
    private final List<Lotto> userLottos;
    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public User(int ticketsCount) {
        userLottos = new ArrayList<>();
        for (int i = ZERO; i < ticketsCount; i++) {
            Lotto lotto = new Lotto(pickNumberForLotto());
            userLottos.add(lotto);
        }
    }
    
    private List<Integer> pickNumberForLotto() {
        return Randoms.pickUniqueNumbersInRange(Lotto.RANGE_MIN, Lotto.RANGE_MAX, Lotto.LOTTO_SIZE)
                .stream().sorted().collect(Collectors.toList());
    }
    
}
