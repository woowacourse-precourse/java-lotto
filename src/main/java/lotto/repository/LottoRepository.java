package lotto.repository;

import lotto.Lotto;

import java.util.List;

public class LottoRepository {

    private static List<Lotto> lastUserLottoGroup;
    private static Lotto lastWinningLotto;

    public static void saveUserLotto(List<Lotto> userLottoGroup) {
        lastUserLottoGroup = userLottoGroup;
    }

    public static void saveWinningLotto(Lotto winningLotto) {
        lastWinningLotto = winningLotto;
    }

    public static Lotto getLastWinningLotto() {
        return lastWinningLotto;
    }

    public static List<Lotto> getLastUserLottoGroup() {
        return lastUserLottoGroup;
    }
}
