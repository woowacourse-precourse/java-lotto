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

    public int countWinningLottos(Prize prize, WinningNumbers winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isWinningLotto(prize, winningNumbers))
                .count();
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
