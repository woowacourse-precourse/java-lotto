package lotto;

import java.util.List;

public class Referee {

    public static GameResultResponseDto calculateLottoResults(List<GameResult> gameResults, int price) {
        int sumWinnerPrice = GameResult.sumWinnerPrice(gameResults);
        return new GameResultResponseDto(calculateEarningPrice(price, sumWinnerPrice));
    }

    private static double calculateEarningPrice(int price, int sumWinnerPrice) {
        return ((double) sumWinnerPrice) / price * 100;
    }

}
