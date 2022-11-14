package lotto.Controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Domain.LottoMachine;
import lotto.Domain.Reward;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {
    List<Lotto> userLotto;
    Lotto winningNumber;
    int bonusNumber;

    private final Map<Reward, Integer> result = new EnumMap<>(Reward.class) {{
        put(Reward.FIFTH, 0);
        put(Reward.FOURTH, 0);
        put(Reward.THIRD, 0);
        put(Reward.SECOND, 0);
        put(Reward.FIRST, 0);
    }};

    public void startGame() {
        int amount = InputView.getAmount();
        OutputView.printAmount(amount);

        userLotto = LottoMachine.publishLotto(amount);
        OutputView.printUserLotto(userLotto);

        winningNumber = InputView.getWinningNumber();
        OutputView.printWinningNumber();

        bonusNumber = InputView.getBonusNumber(winningNumber);
        calculateResult(userLotto, winningNumber, bonusNumber);

        OutputView.printStatistics(amount, result);
    }

    public void calculateResult(List<Lotto> userLotto, Lotto winningNumber, int bonusNumber) {
        for (int i = 0; i < userLotto.size(); i++) {
            int bingo = userLotto.get(i)
                    .getNumbers()
                    .stream()
                    .filter(s -> winningNumber.isContain(s))
                    .mapToInt(n -> 1)
                    .sum();

            boolean bonus = userLotto.get(i).isContain(bonusNumber);

            if (3 <= bingo && bingo <= 6) {
                result.put((Reward.getRanKing(bingo, bonus)), result.get(Reward.getRanKing(bingo, bonus)) + 1);
            }
        }
    }
}