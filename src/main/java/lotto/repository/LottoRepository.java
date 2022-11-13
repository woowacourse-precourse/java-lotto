package lotto.repository;

import lotto.Lotto;

import java.util.List;

import static java.util.Arrays.asList;

public class LottoRepository {

    private static List<Integer> lastWinningResult;
    private static Integer lastPurchaseMoney;
    private static List<Lotto> lastUserLottoGroup;
    private static Lotto lastWinningLotto;
    private static Integer lastBonusNumber;
    public static List<Long> winningAmount = asList(5000L, 50000L, 1500000L,
            2000000000L,30000000L);

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

    public static List<Long> getWinningAmount() {
        return winningAmount;
    }

    public static void savePurchaseMoney(String purchaseMoney) {
        lastPurchaseMoney = Integer.parseInt(purchaseMoney);
    }

    public static void saveWinningResult(List<Integer> winningResult) {
        lastWinningResult = winningResult;
    }

    public static List<Integer> getWinningResult() {
        return lastWinningResult;
    }

    public static Integer getPurchaseMoney() {
        return lastPurchaseMoney;
    }
}
