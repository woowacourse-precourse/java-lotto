package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class LottoGame {

    public void startLottoGame() {
        try {
            Purchase purchase = new Purchase();
            int lottoCount = inputPurchaseMoney(purchase);
            List<Lotto> lottos = getRandomLottos(lottoCount);
            WinNumber winNumber = inputAnswerNumbers();
            Map<Prize, Integer> result = makePrizeCountMap();
            checkEachLotto(lottos, winNumber, result);
            float earningRate = calcEarningRate(purchase, result);
            printStats(result, earningRate);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    int inputPurchaseMoney(Purchase purchase) {
        System.out.println("구입 금액을 입력해주세요.");
        int lottoCount = purchase.enterPurchaseMoney();
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
        return lottoCount;
    }

    private static List<Lotto> getRandomLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(LottoGenerator.makeLottoNumber());
            lottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottos;
    }

    private static WinNumber inputAnswerNumbers() {
        WinNumber winNumber = new WinNumber();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        winNumber.inputWinNumbers(Console.readLine());
        System.out.println("\n보너스 번호를 입력해 주세요.");
        winNumber.inputBonusNumber(Console.readLine());
        return winNumber;
    }

    private static Map<Prize, Integer> makePrizeCountMap() {
        Map<Prize, Integer> result = new HashMap<>();
        result.put(Prize.FIRST, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.FOURTH, 0);
        result.put(Prize.FIFTH, 0);
        result.put(Prize.NONE, 0);
        return result;
    }

    private static void checkEachLotto(List<Lotto> lottos, WinNumber winNumber, Map<Prize, Integer> result) {
        for (Lotto lotto : lottos) {
            lotto.checkResult(winNumber.getWinNumbers(), winNumber.getBonusNumber());
            Integer value = result.get(lotto.getGrade());
            result.replace(lotto.getGrade(), value + 1);
        }
    }

    private static float calcEarningRate(Purchase purchase, Map<Prize, Integer> result) {
        int totEarning = 0;
        for (Prize prize : result.keySet()) {
            totEarning += prize.getValue() * result.get(prize);
        }
        return purchase.clacEarningRate(totEarning);
    }

    private static void printStats(Map<Prize, Integer> result, float earningRate) {
        System.out.println("\n당첨 통계\n---");
        StringBuilder sb = new StringBuilder();
        sb.append(Prize.FIFTH.getAttribute() + " - " + result.get(Prize.FIFTH) + "개\n");
        sb.append(Prize.FOURTH.getAttribute() + " - " + result.get(Prize.FOURTH) + "개\n");
        sb.append(Prize.THIRD.getAttribute() + " - " + result.get(Prize.THIRD) + "개\n");
        sb.append(Prize.SECOND.getAttribute() + " - " + result.get(Prize.SECOND) + "개\n");
        sb.append(Prize.FIRST.getAttribute() + " - " + result.get(Prize.FIRST) + "개\n");
        sb.append("총 수익률은 " + earningRate + "%입니다.");
        System.out.println(sb);
    }












    
}
