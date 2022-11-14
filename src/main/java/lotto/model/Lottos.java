package lotto.model;

import java.util.List;

public class Lottos {
    public static final String NEW_LINE = "\n";
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningInfo getLottosResult(WinningNumbers winningNumbers) {
        WinningInfo result = new WinningInfo();

        lottos.stream()
                .map(lotto -> lotto.getPrize(winningNumbers))
                .filter(prize -> prize != LottoPrize.LOSE)
                .forEach(result::increaseWinningCount);

        return result;
    }

    public int getWinningAmount(WinningNumbers winningNumbers) {
        return lottos.stream()
                .mapToInt(lotto -> lotto.getWinningAmount(winningNumbers))
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Lotto lotto : lottos) {
            result.append(lotto).append(NEW_LINE);
        }

        return result.toString();
    }
}
