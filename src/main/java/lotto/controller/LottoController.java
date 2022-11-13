package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoFactory;
import lotto.model.WinningLotto;
import lotto.utils.InputUtils;

import java.util.List;

public class LottoController extends Controller {
    private InputUtils inputUtils = InputUtils.getInstance();

    public List<Lotto> createLottos(int numberOfLotto) {
        outputView.printOutputNumberOfPurchaseLotto(numberOfLotto);

        LottoFactory lottoFactory = new LottoFactory();
        List<Lotto> lottos = lottoFactory.createLottos(numberOfLotto);

        outputView.printLottos(lottos);
        return lottos;
    }

    public WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = createWinningNumbers();
        outputView.printNewLine();
        int bonusNumber = createBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> createWinningNumbers() {
        outputView.printInputWinningNumbersSentence();
        String winningNumbersInput = inputView.input();
        validateWinningNumbersInput(winningNumbersInput);

        return inputUtils.convertToWinningNumbers(winningNumbersInput);
    }

    private void validateWinningNumbersInput(String winningNumbersInput) {
        String validateFormat = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
        if (!winningNumbersInput.matches(validateFormat)) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    private int createBonusNumber() {
        return 0;
    }
}