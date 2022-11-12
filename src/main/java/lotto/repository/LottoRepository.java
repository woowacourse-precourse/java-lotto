package lotto.repository;

import lotto.Lotto;

import java.util.List;

public class LottoRepository {

    private static List<Lotto> lastUserLottoGroup;

    public static void saveUserLotto(List<Lotto> userLottoGroup) {
        lastUserLottoGroup = userLottoGroup;
    }
}
