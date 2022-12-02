package lotto.model.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.model.numbers.LottoDraw;
import lotto.model.numbers.PlayerNumber;
import lotto.model.numbers.PlayerNumbers;

public class WinningStatistics {

    private final LottoDraw lottoDraw;
    private final PlayerNumbers playerNumbers;
    private final Map<WinningRank, Integer> winningStatistics;

    private WinningStatistics(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        this.lottoDraw = lottoDraw;
        this.playerNumbers = playerNumbers;
        this.winningStatistics = drawWinningStatistics(playerNumbers);
    }

    private Map<WinningRank, Integer> drawWinningStatistics(PlayerNumbers playerNumbers) {
        initializeStatistics();
        for (PlayerNumber player : playerNumbers.getPlayerNumbers()) {
            WinningRank winningRank = WinningRank.from(calculateMatch(player), hasBonus(player));
            winningStatistics.put(winningRank, winningStatistics.get(winningRank) + 1);
        }
        return new HashMap<>(winningStatistics);
    }

    private void initializeStatistics() {
        for (WinningRank winningRank : WinningRank.values()) {
            winningStatistics.put(winningRank, 0);
        }
    }

    public static WinningStatistics from(LottoDraw lottoDraw, PlayerNumbers playerNumbers) {
        return new WinningStatistics(lottoDraw, playerNumbers);
    }

    private boolean hasBonus(PlayerNumber player) {
        return player.getPlayerNumber().contains(lottoDraw.getBonusNumber());
    }

    private int calculateMatch(PlayerNumber player) {
        List<Integer> intersection = new ArrayList<>(player.getPlayerNumber());
        intersection.retainAll(lottoDraw.getWinningNumbers());
        return intersection.size();
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner();
        for (WinningRank winningRank : WinningRank.values()) {
            String matchDisplay = String.format("%d개 일치", winningRank.getMatch());
        }
        return result.toString();
    }
}
