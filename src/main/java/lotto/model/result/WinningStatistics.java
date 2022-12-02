package lotto.model.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.numbers.LottoDraw;
import lotto.model.numbers.PlayerNumber;
import lotto.model.numbers.PlayerNumbers;

public class WinningStatistics {

    private final LottoDraw lottoDraw;
    private final PlayerNumbers playerNumbers;

    private WinningStatistics(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        this.lottoDraw = lottoDraw;
        this.playerNumbers = playerNumbers;

        List<Integer> winningNumbers = lottoDraw.getWinningNumbers();
        int bonusNumber = lottoDraw.getBonusNumber();
        for (PlayerNumber player : playerNumbers.getPlayerNumbers()) {
            List<Integer> playerNumber = player.getPlayerNumber();
            boolean hasBonus = playerNumber.contains(bonusNumber);
            playerNumber.retainAll(winningNumbers);
            int match = player.getPlayerNumber().size();
            System.out.println(hasBonus);
            System.out.println(match);
            WinningRank winningRank = WinningRank.from(match,hasBonus);
            System.out.println(winningRank);
        }
    }

    public static WinningStatistics from(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        return new WinningStatistics(lottoDraw, playerNumbers);
    }

}
