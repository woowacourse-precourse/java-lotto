package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoInputNumbersService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public Lotto inputLottoNumbers() {
        outputView.printAskLottoNumbersMessage();
        String numbers = inputView.askInputLottoLuckyNumbers();
        outputView.printAskBonusNumberMessage();
        String bonusNumber = inputView.askInputBonusNumber();
        ;

        Lotto lotto = new Lotto(parsingNumbers(numbers), parsingBonusNumber(bonusNumber));
        return lotto;
    }

    public List<Integer> parsingNumbers(String numbers) {
        String[] arr = numbers.split(",");
        List<Integer> result = new ArrayList<>();

        for (String num : arr) {
            result.add(Integer.parseInt(num));
        }

        return result;
    }

    public int parsingBonusNumber(String bonusNumber) {
        int result = Integer.parseInt(bonusNumber);
        return result;
    }
}
