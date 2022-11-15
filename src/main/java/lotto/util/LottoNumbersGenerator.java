package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Constant;
import lotto.domain.UserLotto;

public class LottoNumbersGenerator {
    public static List<UserLotto> lottoGenerator(int quantity) {
        List<UserLotto> userLottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_NUMBER,
                    Constant.MAX_LOTTO_NUMBER, Constant.LOTTO_SIZE);
            List<Integer> sortedList = new ArrayList<>(randomNumbers);
            Collections.sort(sortedList);
            userLottos.add(new UserLotto(sortedList));
        }

        return userLottos;
    }
}
