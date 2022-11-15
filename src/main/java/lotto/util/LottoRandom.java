package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/15
 */
public class LottoRandom {
    // 로또 번호 생성
    public static List<Lotto> createLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(createLottoNumber()));
        }
        return lottos;
    }

    private static List<Integer> createLottoNumber() {
        return  Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_RANGE_MIN.getValue(), LottoConstant.LOTTO_RANGE_MAX.getValue(), LottoConstant.LOTTO_LENGTH.getValue()).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
