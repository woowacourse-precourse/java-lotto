package lotto.controller;

import lotto.model.Consumer;
import lotto.model.Draw;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoController {
    public static final String INPUT_PRIZE_NUMBER_COUNT_ERROR = "[ERROR] 당첨 번호를 6개 입력하세요.";
    public static final String INPUT_PRIZE_NUMBER_RANGE_ERROR = "[ERROR] 당첨 번호는 1~45까지 입력 가능합니다.";
    public static final String INPUT_PRIZE_NUMBER_DUPLICATION_ERROR = "[ERROR] 당첨 번호에 중복이 있습니다.";

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
        validatePrizeNumber(prizeNumbers);
        return prizeNumbers;
    }

    private void validatePrizeNumber(List<Integer> prizeNumbers) {
        for(Integer number : prizeNumbers){
            if(!(number >= 1 && number <= 45)){
                throw new IllegalArgumentException(INPUT_PRIZE_NUMBER_RANGE_ERROR);
            }
        }
        Set<Integer> checkDuplication = new HashSet<>();
        for(Integer number : prizeNumbers){
            if(!checkDuplication.add(number)){
                throw new IllegalArgumentException(INPUT_PRIZE_NUMBER_DUPLICATION_ERROR);
            }
        }
        if(prizeNumbers.size() < 6){
            throw new IllegalArgumentException(INPUT_PRIZE_NUMBER_COUNT_ERROR);
        }
    }

    private int inputBonusNumber() {
        Output.printInputBonusNumber();
        int bonusNumber = Input.inputBonusNumber();
        return bonusNumber;
    }
}
