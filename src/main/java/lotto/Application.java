package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    static Map<WinningResult, Integer> winningBoard = new HashMap<>();
    public static void main(String[] args) {
        try{
            initializeBoard();
            int userMoney = IOUtil.moneyInput();
            List<Lotto> lottos = new ArrayList<>();
            publishLottosByUserMoney(lottos, userMoney);
            IOUtil.printLottos(lottos);
            Lotto answer = IOUtil.answerNumberInput();
            int bonus = IOUtil.bonusNumberInput();
            calculateWinningBoard(lottos, answer, bonus);
            int sum = calculateRewardSum();
            double yield = calculateYield(sum, userMoney);
            IOUtil.printWinningBoard(winningBoard);
            IOUtil.printYield(yield);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void publishLottosByUserMoney(List<Lotto> lottos, int userMoney) {
        int lottoCount = userMoney / 1000;
        while (lottos.size() < lottoCount) {
            Lotto lotto = Lotto.publishLotto();
            lottos.add(lotto);
        }
    }

    public static void calculateWinningBoard(List<Lotto> lottos, Lotto answer, int bonus) {
        for (Lotto lotto : lottos) {
            lotto.calculate(answer, bonus).ifPresent(r -> {
                winningBoard.put(r, winningBoard.get(r) + 1);
            });
        }
    }

    public static int calculateRewardSum() {
        int sum = 0;
        for (Entry<WinningResult, Integer> entry : winningBoard.entrySet()) {
            if (entry.getValue() > 0) {
                sum += entry.getKey().getReward()*entry.getValue();
            }
        }
        return sum;
    }

    public static double calculateYield(int rewardSum, int userMoney) {
        double yield = rewardSum / (double) userMoney * 100;
        return Math.round(yield * 10) / 10.0;
    }

    public static void initializeBoard() {
        for (WinningResult result : WinningResult.values()) {
            winningBoard.put(result, 0);
        }
    }
}
