package lotto.controller;

import lotto.model.Consumer;
import lotto.model.Draw;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void run() {
        try {
            int money = inputMoney();
            Consumer consumer = new Consumer(money);
            List<Lotto> lottos = showLottos(consumer);

            List<Integer> prizeNumbers = inputPrizeNumbers();
            int bonusNumber = inputBonusNumber();
            Draw draw = new Draw();
            draw.drawLotto(lottos, prizeNumbers, bonusNumber);
            Map<Rank, Integer> result = draw.getResult();

            Output.printWinStatistics(result);
            Output.printYield(draw.calculateRate(money));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int inputMoney() {
        Output.printInputMoney();
        int money = Input.inputMoney();
        return money;
    }

    private List<Lotto> showLottos(Consumer consumer) {
        int lottoAmount = consumer.divideMoneyIntoLottoPrice();
        Output.printCountLotto(lottoAmount);
        consumer.createLottos();
        List<Lotto> lottos = consumer.getLottos();

        for (Lotto lotto : lottos) {
            Output.printLottoNumbers(lotto.getNumbers());
        }
        return lottos;
    }

    private List<Integer> inputPrizeNumbers() {
        Output.printInputPrizeNumbers();
        List<Integer> prizeNumbers = Input.inputPrizeNumbers();
        return prizeNumbers;
    }

    private int inputBonusNumber() {
        Output.printInputBonusNumber();
        int bonusNumber = Input.inputBonusNumber();
        return bonusNumber;
    }
}
