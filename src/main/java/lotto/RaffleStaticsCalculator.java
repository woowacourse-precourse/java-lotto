package lotto;

import java.util.List;

public class RaffleStaticsCalculator {

    public double calculateStatics(List<Integer> lottoResult, int lottosSize) {
        // TODO: lottoResult 리스트 리팩토링 필요, ENUM으로 리팩터링 필요
        List<Integer> winningMoney = List.of(0, 2000000000, 30000000, 1500000, 50000, 5000);
        int totalWinningMoney = 0;
        int totalLottoBuyMoney = lottosSize* 1000;

        for (int i = 1; i <= 5; i++) {
            totalWinningMoney += winningMoney.get(i) * lottoResult.get(i);
        }

        return (Math.round((double) totalWinningMoney / (double) totalLottoBuyMoney)) * 100.0;
    }
}
