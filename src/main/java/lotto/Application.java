package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    static Map<WinningResult, Integer> winningBoard = new HashMap<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        initializeBoard();
        try{
            //사용자에게 금액 입력 받기
            int userMoney = IOUtil.moneyInput();
            // 입력 받은 만큼 로또 발행
            List<Lotto> lottos = new ArrayList<>();
            int lottoCount = userMoney / 1000;
            while (lottos.size() < lottoCount) {
                Lotto lotto = Lotto.publishLotto();
                lottos.add(lotto);
            }
            IOUtil.printLottos(lottos);
            Lotto answer = IOUtil.answerNumberInput();
            int bonus = IOUtil.bonusNumberInput();
            AtomicInteger sum = new AtomicInteger();
            for (Lotto lotto : lottos) {
                lotto.calculate(answer, bonus).ifPresent(r -> {
                    sum.addAndGet(r.getReward());
                    winningBoard.put(r, winningBoard.get(r) + 1);
                });
            }
            double yield = sum.get() / (double) userMoney * 100;
            yield = Math.round(yield * 10) / 10.0;
            IOUtil.printWinningBoard(winningBoard);
            IOUtil.printYield(yield);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void initializeBoard() {
        for (WinningResult result : WinningResult.values()) {
            winningBoard.put(result, 0);
        }
    }
}
