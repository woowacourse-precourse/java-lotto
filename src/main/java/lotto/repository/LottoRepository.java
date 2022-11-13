package lotto.repository;

import lotto.Lotto;

import java.util.List;

import static java.util.Arrays.asList;

public class LottoRepository {

    private static List<Lotto> lastUserLottoGroup;
    private static Lotto lastWinningLotto;
    private static Integer lastBonusNumber;
    public static List<String> winningAmount = asList("5000", "50,000", "1,500,000",
            "2,000,000,000","30,000,000");

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

    public static void saveBonusNumber(int bonusNumber) {
        lastBonusNumber = bonusNumber;
    }

    public static Integer getBonusNumber() {
        return lastBonusNumber;
    }

    public static List<String> getWinningAmount() {
        return winningAmount;
    }
}
