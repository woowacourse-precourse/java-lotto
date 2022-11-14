package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getWinningAmount(WinningNumbers winningNumbers) {
        return lottos.stream()
                .mapToInt(lotto -> lotto.getWinningAmount(winningNumbers))
                .sum();
    }

    public WinningInfo getWinningInfo(WinningNumbers winningNumbers) {
        WinningInfo result = new WinningInfo();

        lottos.stream()
                .map(lotto -> lotto.getPrize(winningNumbers))
                .filter(prize -> prize != Prize.NO_PRIZE)
                .forEach(result::increaseWinningCount);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Lotto lotto : lottos) {
            result.append(lotto).append('\n');
        }

        return result.toString();
    }
}
