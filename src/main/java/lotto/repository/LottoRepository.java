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
    public static List<String> winningAmount = asList("5000", "50000", "1500000",
            "2000000000","30000000");

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
