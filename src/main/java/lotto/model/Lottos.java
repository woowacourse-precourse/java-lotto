package lotto.model;

import java.util.List;

public class Lottos {
    private static final String LOTTOS_DELIMITER = "\n";
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottosResult getLottosResult(WinningNumbers winningNumbers) {
        LottosResult result = new LottosResult();

        lottos.stream()
                .map(lotto -> lotto.getPrize(winningNumbers))
                .forEach(result::winLotto);

        return result;
    }

    public long calculateWinningAmount(WinningNumbers winningNumbers) {
        return lottos.stream()
                .mapToLong(lotto -> lotto.calculateWinningAmount(winningNumbers))
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Lotto lotto : lottos) {
            result.append(lotto).append(LOTTOS_DELIMITER);
        }

        return result.toString();
    }
}
