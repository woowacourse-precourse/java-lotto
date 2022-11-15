package lotto;

import controller.*;
import ui.Input;
import ui.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final int PURCHASE_UNIT = 1000;
    static Output output = new Output();
    static Input input = new Input();

    public static void main(String[] args) {
        int purchaseQuantity = purchaseProgress();
        List<Lotto> lottos = publishLotto(purchaseQuantity);
        List<List<Integer>> winningAndBonus = enterWinningAndBonusNumber();
        Map<String, Integer> assembledWinning = getAssembledWinning(winningAndBonus, lottos);
        int winning = calculateYield(winningAndBonus, lottos);
        statisticsProgress(assembledWinning, purchaseQuantity, winning);
    }

    public static int purchaseProgress() {
        output.printPriceInputMessage();
        int money = input.getMoney();
        int purchaseQuantity = Calculate.calculatePurchaseQuantity(money);
        return purchaseQuantity;
    }

    public static List<Lotto> publishLotto(int purchaseQuantity) {
        List<Lotto> lottos = Random.getLottoNumber(purchaseQuantity);
        output.printPurchaseQuantity(purchaseQuantity);
        output.printLottoNumber(lottos);
        return lottos;
    }

    public static List<List<Integer>> enterWinningAndBonusNumber() {
        List<List<Integer>> winningAndBonus = new ArrayList<>();
        output.printWinningNumberInputMessage();
        List<Integer> winningNumber = input.getWinningNumber();
        winningAndBonus.add(winningNumber);
        output.printBonusNumberInputMessage();
        List<Integer> bonusNumber = input.getBonusNumber();
        winningAndBonus.add(bonusNumber);
        InputNumber.getIntegratedWinningNumber(winningNumber, bonusNumber);
        return winningAndBonus;
    }

    public static int calculateYield(List<List<Integer>> winningAndBonus, List<Lotto> lottos) {
        int winning = 0;
        for (Lotto lotto : lottos) {
            String rank = getWinning(winningAndBonus, lotto);
            winning += Calculate.getWinningPrice(rank);
        }
        return winning;
    }

    private static String getWinning(List<List<Integer>> winningAndBonus, Lotto lotto) {
        List<Integer> winningCount = Compare.getWinningCount(winningAndBonus.get(0),
                winningAndBonus.get(1), lotto.getNumbers());
        String rank = Calculate.calculateWinning(winningCount);
        return rank;
    }

    public static Map<String, Integer> getAssembledWinning(List<List<Integer>> winningAndBonus, List<Lotto> lottos) {
        Map<String, Integer> assembledWinning = initiate();
        for (Lotto lotto : lottos) {
            String rank = getWinning(winningAndBonus, lotto);
            Calculate.getWinningCount(rank, assembledWinning);
        }
        return assembledWinning;
    }

    private static Map<String, Integer> initiate() {
        Map<String, Integer> result = new HashMap<>();
        for (Winning winning : Winning.values()) {
            result.put(winning.name(), 0);
        }
        return result;
    }

    public static void statisticsProgress(Map<String, Integer> assembledWinning, int purchaseQuantity, int winning) {
        output.printWinningStatistics(assembledWinning);
        String yield = Calculate.calculateYield(purchaseQuantity * PURCHASE_UNIT, winning);
        output.printYield(yield);
    }


}
