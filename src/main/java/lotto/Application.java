package lotto;

import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Rank;
import lotto.ui.Input;
import lotto.ui.Output;

public class Application {
    public static void main(String[] args) {
        try {
            int amount = Input.inputAmount();
            List<Lotto> lottos = LottoMachine.publishLotto(amount);
            Output.outputBuyLotto(lottos);

            List<Integer> numbers = Input.inputNumbers();
            Lotto userLotto = new Lotto(numbers);
            int bonus = Input.inputBonus(userLotto);

            List<Integer> result = LottoMachine.getResult(lottos, numbers, bonus);
            Output.outputStatistics(result, Calculator.calRevenue(result, amount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
