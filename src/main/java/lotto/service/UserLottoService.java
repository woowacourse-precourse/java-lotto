package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.IntConstant;
import lotto.domain.Lotto;

public class UserLottoService {

    public static List<Lotto> createLottoNumber(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

}
