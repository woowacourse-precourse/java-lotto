package lotto.model;

import lotto.resource.WinningType;

import java.util.EnumMap;
import java.util.List;


public class LottoWinningAnalyzer {
    private static final int INIT_WINNING_COUNT = 0;
    private static final int DECIMAL_POINT = 2;

    private EnumMap<WinningType, Integer> winningResult;
    private WinningLotto winningLotto;

    public LottoWinningAnalyzer(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        winningResult = new EnumMap<>(WinningType.class);

        for (WinningType type : WinningType.values()) {
            winningResult.put(type, INIT_WINNING_COUNT);
        }
    }

    public EnumMap<WinningType, Integer> calculateWinningResult(List<Lotto> lottoTickets) {
        for (int i = 0; i < lottoTickets.size(); i++) {
            Lotto lottoTicket = lottoTickets.get(i);
            int count = winningLotto.countWinningNumber(lottoTicket);

            if (count >= WinningType.THREE.getNumberOfMatching())
                updateWinningResult(count);
        }

        return winningResult;
    }

    public double calculateProfit(int userMoney) {
        double winningMoney = getSumAllWinningMoney();
        double profit = winningMoney / userMoney * 100;
        double roundDecimalPoint = Math.pow(10, DECIMAL_POINT);

        return Math.round(profit * roundDecimalPoint) / roundDecimalPoint;
    }

    private void updateWinningResult(int count) {
        WinningType type = winningResult.keySet().stream().
                filter(winningType -> winningType.getNumberOfMatching() == count)
                .findAny()
                .get();
        int currentCount = winningResult.get(type);

        winningResult.put(type, currentCount + 1);
    }

    private long getSumAllWinningMoney() {
        long sum = 0;

        for (WinningType type : WinningType.values()) {
            sum += type.getMoney() * winningResult.get(type);
        }

        return sum;
    }
}
