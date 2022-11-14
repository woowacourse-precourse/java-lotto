package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSet {
    public static final Integer LOTTO_PRICE = 1000;

    private int inputMoney;
    private List<Lotto> lottos;

    public LottoSet(List<Lotto> lottoSet) {
        this.lottos = lottoSet;
        this.inputMoney = lottos.size() * LOTTO_PRICE;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public List<Integer> checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto : this.lottos) {
            int ranking = lotto.checkWinning(winningNumbers, bonusNumber);
            if (ranking != 0) {
                result.set(ranking - 1, result.get(ranking - 1) + 1);
            }
        }
        return result;
    }
}
